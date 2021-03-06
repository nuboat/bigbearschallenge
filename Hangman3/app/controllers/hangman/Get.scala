/**
  * © 2018 NORBOR.IN, All Rights Reserved.
  */

package controllers.hangman

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}

/**
  * @author Peerapat A on Oct 8, 2018
  */
class Get @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def run(id: String) = Action {
    Ok("{}")
  }

}
