package com.programmera.scalaland_immutable3

// Just a copy for ( scalaland_immutable1 )

trait Dwarf extends Creature {
  override protected def generateCreatureFeatures(): CreatureFeatureSet = {
    val tmpStrength = DieRoll.roll(4)
    CreatureFeatureSet(
      strength = tmpStrength,
      wisdom = DieRoll.roll(3),
      charisma = DieRoll.roll(2),
      hitpoints = tmpStrength * 2)
  }
  override def toString = super.toString + "\n is a dwarf."
}


