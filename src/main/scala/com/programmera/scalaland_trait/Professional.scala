package com.programmera.scalaland_trait

trait Professional extends Creature {

  // Returns climbed meters
  def climb = {
    println("This character can not climb.")
    0
  }

  // Will if successful reduce hitpoints on foe
  def magicAttack(foe: Creature) {
    println("This character can not use magic to attack.")
  }

  // Will if successful reduce hitpoints on foe
  def weaponAttack(foe: Creature) {
    println("Default weaponAttack.")
    val damage = (this.strength - foe.strength)/3 + DieRoll.roll(1)
    sufferDamage(foe, damage)
  }

  protected def sufferDamage(foe: Creature, damage: Int) {
    println("Damage: "+ damage)
    if (damage > 0) foe.hitpoints -= damage
  }
}

