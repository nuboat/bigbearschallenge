package in.norbor.bigbears.hangman

/**
  * @author Peerapat A on Oct 1, 2018
  */
object Status extends Enumeration {
  type Status = Value

  val InGame: Value = Value
  val Win: Value = Value
  val Lose: Value = Value
}
