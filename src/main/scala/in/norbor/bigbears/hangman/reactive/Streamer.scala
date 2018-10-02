package in.norbor.bigbears.hangman.reactive

import akka.actor.Actor
import in.norbor.bigbears.hangman.{State, Status}


/**
  * @author Peerapat A on Oct 1, 2018
  */
class Streamer extends Actor {

  private val word = self.path.name
  private var state = State(word)
  private val secret = self.path.name.toCharArray

  def receive: PartialFunction[Any, Unit] = {
    case c: Char =>
      state = if (!secret.contains(c))
        if (state.lifeLeft > 0)
          state.copy(lifeLeft = state.lifeLeft - 1)
        else
          state.copy(status = Status.Lose)
      else
        state.correct(secret.zipWithIndex.filter(_._1 == c).map(_._2).foldLeft(state.selected)((x, y) => x.patch(y, Seq(c), 1)))

      sender() ! state
  }

}
