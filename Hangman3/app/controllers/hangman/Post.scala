/**
  * © 2018 NORBOR.IN, All Rights Reserved.
  */

package controllers.hangman

import java.util.UUID

import javax.inject.Singleton

import scala.util.Random

/**
  * {
  * "id": "gameId-1",
  * "life": 7,
  * "selectedLetters": ["w"],
  * "secretWordLength": 5,
  * "knownLetters": "w____"
  * }
  *
  * @author Peerapat A on Oct 8, 2018
  */
@Singleton
class Post extends CController {

  def run = Action {
    val word = randomWord
    val clue = word.toCharArray()(Random.nextInt(word.length))
    val state = State(id = UUID.randomUUID().toString
      , status = State.InGame
      , lifeLeft = 7
      , selected = word.map(_ => '_').toList)

    val gameState = Game(word, facade.next(state, word, clue))

    db.upsert(state.id, gameState)

    Ok(json.toString(gameState.state))
  }

  def randomWord: String = words(Random.nextInt(words.size))

  private lazy val words = List("adventurous"
    , "courageous"
    , "extramundane"
    , "generous"
    , "intransigent"
    , "sympathetic"
    , "vagarious"
    , "witty")

}
