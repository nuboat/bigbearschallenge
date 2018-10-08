/**
  * © 2018 NORBOR.IN, All Rights Reserved.
  */

package controllers.hangman

import javax.inject.Inject
import play.api.mvc.{BaseController, ControllerComponents}

abstract class CController extends BaseController {

  @Inject
  private var cc: ControllerComponents = _

  @Inject
  protected var json: Json = _

  @Inject
  protected var db: Db = _

  @Inject
  protected var facade: Facade = _

  override def controllerComponents: ControllerComponents = cc

}
