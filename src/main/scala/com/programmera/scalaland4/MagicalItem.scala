package com.programmera.scalaland4

import scala.collection.mutable.ListBuffer

class MagicalItemList{
  private val items = ListBuffer[MagicalItem]()

  def add(item: MagicalItem) {
    items += item
  }

  def calculateModifier(feature: CharacterFeature.Value): Int = {
    var sum = 0
    for(item <- items){
      feature match{
        case CharacterFeature.Strength =>  sum += item.strengthModifier
        case CharacterFeature.Wisdom   =>  sum += item.wisdomModifier
        case CharacterFeature.Charisma =>  sum += item.charismaModifier
      }
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

