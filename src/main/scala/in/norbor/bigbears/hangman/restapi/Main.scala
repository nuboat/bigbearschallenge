package in.norbor.bigbears.hangman.restapi

import akka.util.Timeout

import scala.concurrent.duration._
import scala.language.postfixOps


/**
  * @author Peerapat A on Oct 1, 2018
  */
object Main extends App {

  private implicit val timeout: Timeout = Timeout(13 seconds)

}
