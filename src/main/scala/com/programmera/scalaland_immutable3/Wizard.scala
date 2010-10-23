package com.programmera.scalaland_immutable3

trait Wizard extends Professional {
  override def toString = super.toString + "\n is a wizard."

  // Good with spells
  override def magicAttack(foe: Creature): Int = {
    println("Wizard using magicAttack.")
    (this.wisdom - foe.wisdom)/2 + DieRoll.roll(2)
  }
}  


