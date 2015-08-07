import scala.actors._
import scala.actors.Actor._
//import akka.actors._

object SillyActor extends Actor {
	def act() {
		for (i <- 1 to 5) {
			println("acting")
			Thread.sleep(1000)
		}
	}
}


object SeriousActor extends Actor {
  	def act() {
	    for (i <- 1 to 5) {
	      println("To be or not to be.")
	      Thread.sleep(1000)
	    }
	} 
}

val seriousActor2 = actor {
	for (i <- 1 to 5) {
      println("That is a question.")
      Thread.sleep(1000)
    }
}

SillyActor.start()
SeriousActor.start()
seriousActor2.start()


var echoActor = actor { 
	var quit = false
	while (!quit) {
		receive {
			case msg => {
				println("received : " + msg)
				quit = (msg == "quit")
			}
		}
	}
}

echoActor ! "hi"
echoActor ! "hello"
echoActor ! "nihao"

val quitEchoActor = actor {
	echoActor ! "quit"
}

quitEchoActor.start()