import scala.io._
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

// START:loader
object PageLoader {
  //  FIX: Thanks to https://github.com/krzysztofr/7lan7wk/blob/master/README.md
  def getPageSize(url: String) = Source.fromURL(url)(io.Codec("ISO-8859-1")).mkString.length
}

// END:loader

val urls = List("http://www.amazon.com/",
  "http://www.twitter.com/",
  "http://www.google.com/",
  "http://www.cnn.com/")

// START:time
def timeMethod(method: () => Unit) = {
  val start = System.nanoTime
  method()
  val end = System.nanoTime
  println("Method took " + (end - start) / 1000000000.0 + " seconds.")
}
// END:time

// START:sequential
def getPageSizeSequentially() = {
  for (url <- urls) {
    println("Size for " + url + ": " + PageLoader.getPageSize(url))
  }
}

// END:sequential

// START:concurrent
object IConcurrent {

  case class PrintSize(url: String)

  case class CalculateDuration(start: Long)

}

class MyActor extends Actor {

  import IConcurrent._

  def receive = {
    case PrintSize(url) => {
      println("Size for " + url + ": " + PageLoader.getPageSize(url))
    }
    case CalculateDuration(start) => {
      val end = System.nanoTime
      println("Method took " + (end - start) / 1000000000.0 + " seconds.")
      System.exit(1)
    }
    case _ => {
      System.exit(1)
    }
  }
}

def getPageSizeConcurrently() = {
  val start = System.nanoTime
  val system = ActorSystem("URLSizerSystem")
  val myActor = system.actorOf(Props(new MyActor), name = "myActor")

  for (url <- urls) {
    myActor ! IConcurrent.PrintSize(url)

    if (url == urls.last)
      myActor ! IConcurrent.CalculateDuration(start)
  }
}

// END:concurrent

// START:script
object Sizer {
  def main(args: Array[String]): Unit = {
    println("Sequential run:")
    timeMethod {
      getPageSizeSequentially
    }

    println("Concurrent run")
    getPageSizeConcurrently()
  }
}

Sizer.main(Array())
// END:script
