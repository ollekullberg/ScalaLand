package com.programmera.scalaland_func3

trait Profession extends Avatar {

  // Returns climbed meters
  def climb = {
    println("This Avatar can not climb.");
    0
  }

  // Will if successful reduce hitpoints on foe
  def magicAttack(foe: Avatar): Option[Avatar] = {
    println("This Avatar can not use magic to attack.");
    Some(foe)
  }

  // Will if successful reduce hitpoints on foe
  def weaponAttack(foe: Avatar): Option[Avatar] = {
    println("Default weaponAttack.");
    val damage = (this.strength - foe.strength) + Dice.roll(1)
    reduceFoeHitpoints(foe, damage)
  }

  // Helper method for reducing hitpoings on foe
  protected def reduceFoeHitpoints(foe: Avatar, 
      damage: Int): Option[Avatar] = {
    println("Damage: "+ damage);
    if(damage > 0){
      val remainingHitpoints = foe.hitpoints - damage
      if (remainingHitpoints > 0){
        Some(foe.setHitpoints(remainingHitpoints))
      }else{
        println("Foe died!");
        None 
      }
    }else{
      Some(foe)
    }
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
  override def weaponAttack(foe: Avatar): Option[Avatar] = {
    println("Warrior using weaponAttack.");
    val damage =  (this.strength - foe.strength) + Dice.roll(2)
    reduceFoeHitpoints(foe, damage)
  }
}  

trait Wizard extends Profession {
  override def toString = super.toString + "\n is a wizard."

  // Good with spells
  override def magicAttack(foe: Avatar): Option[Avatar] = {
    println("Wizard using magicAttack.");
    val damage = (this.wisdom - foe.wisdom) + Dice.roll(2)
    reduceFoeHitpoints(foe, damage)
  }
}  


