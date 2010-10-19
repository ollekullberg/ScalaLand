package com.programmera.scalaland_generic

trait Professional extends Creature {

  // Returns climbed meters
  def climb = {
    println("This character can not climb.");
    0
  }

  // Will if successful reduce hitpoints on foe
  def magicAttack[T <: Creature](foe: T): T = {
    println("This character can not use magic to attack.");
    foe
  }

  // Will if successful reduce hitpoints on foe
  def weaponAttack[T <: Creature](foe: T): T = {
    println("Default weaponAttack.");
    val damage = (this.strength - foe.strength)/3 + DieRoll.roll(1)
    sufferDamage(foe, damage)
  }

  protected def sufferDamage[T <: Creature](foe: T, damage: Int): T = {
    println("Foes hitpoints before attack: "+ foe.hitpoints);
    println("Damage: "+ damage);
    if( damage > 0 ) {
      val newHitpoints = foe.hitpoints - damage
      val newFoe = foe.updateHitpoints(newHitpoints)
      newFoe match {
        case f: T => f
        case _ => throw new Exception("updateHitpoints returns wrong type")
      }
    }else{
      foe
    }
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
  override def weaponAttack[T <: Creature](foe: T): T = {
    println("Warrior using weaponAttack.");
    val damage =  (this.strength - foe.strength)/2 + DieRoll.roll(2)
    sufferDamage(foe, damage)
  }
}  

trait Wizard extends Professional {
  override def toString = super.toString + "\n is a wizard."

  // Good with spells
  override def magicAttack[T <: Creature](foe: T): T = {
    println("Wizard using magicAttack.");
    val damage = (this.wisdom - foe.wisdom)/2 + DieRoll.roll(2)
    sufferDamage(foe, damage)
  }
}  


