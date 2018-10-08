/**
  * © 2018 NORBOR.IN, All Rights Reserved.
  */

package controllers.hangman

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import javax.inject.Singleton

/**
  * @author Peerapat A on Oct 8, 2018
  */
@Singleton
class Json {

  private val mapper = new ObjectMapper with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)

  def toString(obj: Any): String = mapper.writeValueAsString(obj)

  def toClass[T: Manifest](str: String): T = mapper.readValue[T](str)

}
