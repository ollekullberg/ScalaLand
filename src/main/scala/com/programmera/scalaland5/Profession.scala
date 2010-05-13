package com.programmera.scalaland5

trait Profession extends Avatar {

  // Returns climbed meters
  def climb = {
    println("This Avatar can not climb.");
    0
  }

  // Will if successful reduce hitpoints on foe
  def magicAttack(foe: Avatar) {
    println("This Avatar can not use magic to attack.");
  }

  // Will if successful reduce hitpoints on foe
  def weaponAttack(foe: Avatar) {
    println("Default weaponAttack.");
    println("Foes hitpoints before attack: "+ foe.hitpoints);
    val damage = (this.strength - foe.strength) + Dice.roll(1)
    println("Damage: "+ damage);
    if( damage > 0)
      foe.hitpoints -= damage
  }
}

trait Thief extends Profession {
  override def toString = super.toString + "\n is a thief."

  // Good climber
  override def climb = {
    strength + Dice.roll(1)
  }
}

trait Warrior extends Profession {
  override def toString = super.toString + "\n is a warrior."

  // Decent climber
  override def climb = {
    Dice.roll(1)
  }

  // Good fighter
  override def weaponAttack(foe: Avatar) {
    println("Warrior using weaponAttack.");
    println("Foes hitpoints before attack: "+ foe.hitpoints);
    val damage =  (this.strength - foe.strength) + Dice.roll(2)
    println("Damage: "+ damage);
    if( damage > 0)
      foe.hitpoints -= damage
  }
}  

trait Wizard extends Profession {
  override def toString = super.toString + "\n is a wizard."

  // Good with spells
  override def magicAttack(foe: Avatar) {
    println("Wizard using magicAttack.");
    println("Foes hitpoints before attack: "+ foe.hitpoints);
    val damage = (this.wisdom - foe.wisdom) + Dice.roll(2)
    println("Damage: "+ damage);
    if( damage > 0)
      foe.hitpoints -= damage
  }
}  



