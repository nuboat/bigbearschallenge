/**
  * © 2018 NORBOR.IN, All Rights Reserved.
  */

package controllers.hangman

/**
  * @author Peerapat A on Oct 8, 2018
  */
case class State(id: String
                 , status: String
                 , lifeLeft: Int
                 , selected: List[Char]) {

  import State._

  val knownSecret: String = selected.mkString("")

  def correct(update: List[Char]): State = if (update.contains('_'))
    this.copy(selected = update)
  else
    this.copy(status = Win, selected = update)

}

object State {
  val InGame: String = "InGame"
  val Win: String = "Win"
  val Lose: String = "Lose"
}