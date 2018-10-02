package in.norbor.bigbears.hangman.reactive

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import in.norbor.bigbears.hangman.{State, Status}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.io.StdIn
import scala.language.postfixOps
import scala.util.{Failure, Success}


/**
  * @author Peerapat A on Oct 1, 2018
  */
object Main extends App {

  private implicit val timeout: Timeout = Timeout(13 seconds)

  private val streamer = start("bigbears")

  while (true)
    (streamer ? StdIn.readChar())
      .onComplete {
        case Success(s: State) =>
          println(s)
          if (s.status != Status.InGame)
            System.exit(0)

        case Failure(e) =>
          e.printStackTrace()
      }

  def start(word: String): ActorRef = system.actorOf(Props(classOf[Streamer]), word)

  private lazy val system: ActorSystem = ActorSystem("Norbor")

}
