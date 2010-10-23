package com.programmera.scalaland3

import scala.collection.mutable.ListBuffer

class MagicalItemList {

  private val items = ListBuffer[MagicalItem]()
  
  def add(item: MagicalItem) { 
    items += item
  }
  
  def strengthModifier: Int = {
    var sum = 0
    for (item <- items) {
      sum += item.strengthModifier  
    }
    sum
  }
  
  def wisdomModifier: Int = {
    var sum = 0
    for (item <- items) {
      sum += item.wisdomModifier 
    }
    sum
  }
  
  def charismaModifier: Int = {
    var sum = 0
    for (item <- items) {
      sum += item.charismaModifier 
    }
    sum
  }
  
  override def toString = {
    var ret= "---- Magical Items ----"
    for (item <- items) {
      ret+= "\n "+ item
    }
    ret += "\n-----------------------"
    ret 
  }
}


