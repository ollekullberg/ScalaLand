package com.programmera.scalaland_trait

trait Warrior extends Professional {

  override def toString = super.toString + "\n is a warrior."

  // Decent climber
  override def climb = {
    DieRoll.roll(1)
  }

  // Good fighter
  override def weaponAttack(foe: Creature) {
    println("Warrior using weaponAttack.")
    val damage =  (this.strength - foe.strength)/2 + DieRoll.roll(2)
    sufferDamage(foe, damage)
  }
}  

  


