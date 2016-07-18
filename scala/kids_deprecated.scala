//warning: trait Actor in package actors is deprecated: Use the akka.actor package instead. For migration from the scala.actors package refer to the Actors Migration Guide.
import scala.actors._
import scala.actors.Actor._

case object Poke
case object Feed
case object Sleep

class Kid() extends Actor {
  def act() {
    loop {
      react {
        case Poke => {
          println("Ow...")
          println("Quit it...")
        }
        case Feed => {
          println("Gurgle...")
          println("Burp...")
        }
        case Sleep => {
          println("Feeling sleepy...")
          Thread.sleep(5000)
          println("Peace")
          System.exit(1)
        }
      }
    }
  }
}

val bart = new Kid().start
val lisa = new Kid().start
println("Ready to poke and feed...")
bart ! Poke
lisa ! Poke
bart ! Feed
lisa ! Feed

//  Addition to original code: Code does not exit unless it is told to exit a loop.
lisa ! Sleep
bart ! Sleep