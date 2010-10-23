package com.programmera.scalaland_immutable3

trait Professional extends Creature {

  // Returns climbed meters
  def climb = {
    println("This character can not climb.")
    0
  }

  // Will if successful reduce hitpoints on foe
  def magicAttack(foe: Creature): Int = {
    println("This character can not use magic to attack.")
    0
  }

  // Will if successful reduce hitpoints on foe
  def weaponAttack(foe: Creature): Int = {
    println("Default weaponAttack.")
    (this.strength - foe.strength)/3 + DieRoll.roll(1)
  }
}
  


