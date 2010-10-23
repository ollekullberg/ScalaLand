package com.programmera.scalaland_trait

trait Elf extends Creature {

  override protected def generateCreatureFeatures() {
    strength = DieRoll.roll(2)
    wisdom = DieRoll.roll(4)
    charisma = DieRoll.roll(4) 
    hitpoints = strength * 2
  }

  override def toString = super.toString + "\n is an elf."

}


