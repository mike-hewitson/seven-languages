import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class Kid extends Actor {
  def receive = {
    case "Poke" => {
      println("Ow...")
      println("Quit it...")
    }
    case "Feed" => {
      println("Gurgle...")
      println("Burp...")
    }
    case _ => {
      Thread.sleep(1000)
      println("D'oh!")
      System.exit(1)
    }
  }
}

object Kids {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("KidSystem")
    val lisa = system.actorOf(Props(new Kid), name = "lisaActor")
    val bart = system.actorOf(Props(new Kid), name = "bartActor")
    val homer = system.actorOf(Props(new Kid), name = "homerActor")

    bart ! "Poke"
    lisa ! "Poke"
    bart ! "Feed"
    lisa ! "Feed"
    homer ! "?"
  }
}

Kids.main(Array())
