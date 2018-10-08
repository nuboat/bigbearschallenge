package controllers.hangman

import javax.inject.Singleton

/**
  * @author Peerapat A on Oct 8, 2018
  */
@Singleton
class Facade {

  def next(state: State, secret: String, c: Char): State = {
    if (!secret.contains(c))
      if (state.lifeLeft > 0)
        state.copy(lifeLeft = state.lifeLeft - 1)
      else
        state.copy(status = State.Lose)
    else
      state.correct(secret.zipWithIndex.filter(_._1 == c).map(_._2).foldLeft(state.selected)((x, y) => x.patch(y, Seq(c), 1)))
  }

}
