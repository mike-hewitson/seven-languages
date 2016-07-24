import akka.actor.{Actor, ActorSystem, Props}

case object Poke

case object Feed

class Kid extends Actor {
  def receive = {
    case Poke =>
      println("Ow...")
      println("Quit it...")
    case Feed =>
      println("Gurgle...")
      println("Burp...")
  }
}

println("Ready to poke and feed...")
val system = ActorSystem("KidsSystem")

val bart = system.actorOf(Props(new Kid()), name = "barts")
val lisa = system.actorOf(Props(new Kid()), name = "lisa")

bart ! Poke
lisa ! Poke
bart ! Feed
lisa ! Feed