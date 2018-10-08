/**
  * © 2018 NORBOR.IN, All Rights Reserved.
  */

package controllers.hangman

import javax.inject.Singleton

import scala.collection.mutable

/**
  * @author Peerapat A on Oct 8, 2018
  */
@Singleton
class Db {

  private val data = mutable.Map[String, Game]()

  def read(key: String): Game = data(key)

  def upsert(key: String, value: Game): Unit = data += (key -> value)

} 
