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

trait Thief extends Professional {
  override def toString = super.toString + "\n is a thief."

  // Good climber
  override def climb = {
    strength + DieRoll.roll(1)
  }
}

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

trait Wizard extends Professional {
  override def toString = super.toString + "\n is a wizard."

  // Good with spells
  override def magicAttack(foe: Creature): Int = {
    println("Wizard using magicAttack.")
    (this.wisdom - foe.wisdom)/2 + DieRoll.roll(2)
  }
}  


