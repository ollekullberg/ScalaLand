package com.programmera.scalaland_func5

trait Profession extends Avatar {

  // Returns climbed meters
  def climb = {
    println("This Avatar can not climb.");
    0
  }

  // Will if successful reduce hitpoints on foe
  def magicAttack(foe: Profession): Option[Profession] = {
    println("This Avatar can not use magic to attack.");
    Some(foe)
  }

  // Will if successful reduce hitpoints on foe
  def weaponAttack(foe: Profession): Option[Profession] = {
    println("Default weaponAttack.");
    val partial = reduceFoeHitpoints(foe, this.strength, foe.strength) _
    unskilledAttack(partial)
  }

  // Helper method for reducing hitpoings on foe
  protected def reduceFoeHitpoints(foe: Profession, 
     attackFeature: Int, defenceFeature: Int)
     (calculateDamage: (Int, Int) => Int): Option[Profession] = {
    val damage = calculateDamage(attackFeature, defenceFeature)
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

  protected def unskilledAttack(
      reduceFoeHitpointsPartial: ((Int, Int) => Int) => Option[Profession]
  ): Option[Profession] = {
     reduceFoeHitpointsPartial{ (attack: Int, defence: Int) =>
       (attack -  defence) + Dice.roll(1)
     }
  }

  protected def skilledAttack(
      reduceFoeHitpointsPartial: ((Int, Int) => Int) => Option[Profession]
  ): Option[Profession] = {
     reduceFoeHitpointsPartial{ (attack: Int, defence: Int) =>
       (attack - defence) + Dice.roll(2)
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
  override def weaponAttack(foe: Profession): Option[Profession] = {
    println("Warrior using weaponAttack.");
    reduceFoeHitpoints(foe, this.strength, foe.strength){ (a: Int, d: Int) => 
      (a - d) + Dice.roll(2)
    }
  }
}  

trait Wizard extends Profession {
  override def toString = super.toString + "\n is a wizard."

  // Good with spells
  override def magicAttack(foe: Profession): Option[Profession] = {
    println("Wizard using magicAttack.");
    reduceFoeHitpoints(foe, this.wisdom, foe.wisdom){ (a: Int, d: Int) => 
      (a - d) + Dice.roll(2)
    }
  }
}  


