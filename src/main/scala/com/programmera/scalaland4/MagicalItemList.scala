package com.programmera.scalaland4

import scala.collection.mutable.ListBuffer

class MagicalItemList {

  private val items = ListBuffer[MagicalItem]()

  def add(item: MagicalItem) {
    items += item
  }

  def calculateModifier(feature: CreatureFeature.Value): Int = {
    var sum = 0
    for (item <- items) {
      feature match {
        case CreatureFeature.Strength =>  sum += item.strengthModifier
        case CreatureFeature.Wisdom   =>  sum += item.wisdomModifier
        case CreatureFeature.Charisma =>  sum += item.charismaModifier
      }
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



