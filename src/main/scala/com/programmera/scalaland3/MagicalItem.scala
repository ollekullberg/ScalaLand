package com.programmera.scalaland3

import scala.collection.mutable.ListBuffer

class MagicalItemList{
  private val items = ListBuffer[MagicalItem]()
  
  def add(item: MagicalItem) { 
    items += item
  }
  
  def strengthModifier: Int = {
    var sum = 0
    for(item <- items){
      sum += item.strengthModifier  
    }
    sum
  }
  
  def wisdomModifier: Int = {
    var sum = 0
    for(item <- items){
      sum += item.wisdomModifier 
    }
    sum
  }
  
  def charismaModifier: Int = {
    var sum = 0
    for(item <- items){
      sum += item.charismaModifier 
    }
    sum
  }
  
  override def toString = {
    var ret= "---- Magical Items ----"
    for(item <- items){
      ret+= "\n "+ item
    }
    ret += "\n-----------------------"
    ret 
  }
}

class MagicalItem(val description: String, 
    val strengthModifier: Int = 0,
    val wisdomModifier: Int = 0, 
    val charismaModifier: Int = 0){
  override def toString = {
    var ret: String = description + " ("
    if(strengthModifier != 0) ret += " str "+strengthModifier
    if(wisdomModifier != 0) ret += " wis "+ wisdomModifier
    if(charismaModifier != 0) ret += " cha "+ charismaModifier
    ret += " )"
    ret
  }
}

