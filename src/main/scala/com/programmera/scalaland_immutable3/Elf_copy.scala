package com.programmera.scalaland_immutable3

// Just a copy for ( scalaland_immutable1 )

trait Elf extends Creature {
  override protected def generateCreatureFeatures(): CreatureFeatureSet = {
    val tmpStrength = DieRoll.roll(2)
    CreatureFeatureSet(
      strength = tmpStrength,
      wisdom = DieRoll.roll(4),
      charisma = DieRoll.roll(4),
      hitpoints = tmpStrength * 2)
  }
  override def toString = super.toString + "\n is an elf."
}


