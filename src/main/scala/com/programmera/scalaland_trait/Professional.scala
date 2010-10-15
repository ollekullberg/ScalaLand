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
    if( damage > 0 ) foe.hitpoints -= damage
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
  override def weaponAttack(foe: Creature) {
    println("Warrior using weaponAttack.")
    val damage =  (this.strength - foe.strength)/2 + DieRoll.roll(2)
    sufferDamage(foe, damage)
  }
}  

trait Wizard extends Professional {
  override def toString = super.toString + "\n is a wizard."

  // Good with spells
  override def magicAttack(foe: Creature) {
    println("Wizard using magicAttack.")
    val damage = (this.wisdom - foe.wisdom)/2 + DieRoll.roll(2)
    sufferDamage(foe, damage)
  }
}  


