package com.programmera.scalaland_immutable3

trait Warrior extends Professional {
  override def toString = super.toString + "\n is a warrior."

  // Decent climber
  override def climb = {
    DieRoll.roll(1)
  }

  // Good fighter
  override def weaponAttack(foe: Creature): Int = {
    println("Warrior using weaponAttack.")
    (this.strength - foe.strength)/2 + DieRoll.roll(2)
  }
}  


