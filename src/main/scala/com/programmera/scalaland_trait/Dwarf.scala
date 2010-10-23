package com.programmera.scalaland_trait

trait Dwarf extends Creature {

  override protected def generateCreatureFeatures() {
    strength = DieRoll.roll(4)
    wisdom = DieRoll.roll(3)
    charisma = DieRoll.roll(2) 
    hitpoints = strength * 2
  }

  override def toString = super.toString + "\n is a dwarf."

}



