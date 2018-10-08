/**
  * © 2018 NORBOR.IN, All Rights Reserved.
  */

package controllers.hangman

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers.{route, status, _}

/**
  * @author Peerapat A on Oct 8, 2018
  */
class PostSpec extends PlaySpec with GuiceOneAppPerSuite {

  private lazy val (method, url) = (POST, "/hangman")

  s"$method $url" should {
    "create new game with result" in {
      val response = route(app, FakeRequest(method, url)).get

      status(response) mustBe OK

      val content = contentAsString(response)
      assert(content.contains("id"))

      println(content)
    }
  }

}