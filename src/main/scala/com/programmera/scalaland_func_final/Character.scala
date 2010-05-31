package com.programmera.scalaland_func_final

trait Character extends Race {

  // Returns climbed meters if successful
  def climb: Option[Int] = {
    println("This character can not climb.");
    None 
  }

  // Returns function to calculate hitpoints reduction
  def physicalAttack(): Option[(Int, Int) => Int] = {
    println("Default physicalAttack.");
    Some{
      (foeStrength: Int, foeWisdom: Int) => 
        val damage = (strength - foeStrength)/3 + Dice.roll(1)
        if(damage > 0) damage else 0
    }
  }

  // Returns function to calculate hitpoints reduction
  def magicalAttack(): Option[(Int, Int) => Int] = {
    println("This character can not use magic to attack.");
    None
  }
}

trait Thief extends Character{
  override def toString = super.toString + "\n is a thief"

  // Good climber
  override def climb = Some(strength + Dice.roll(1))
}

trait Warrior extends Character {
  override def toString = super.toString + "\n is a warrior"

  // Decent climber
  override def climb = Some(Dice.roll(1))

  // Good fighter
  override def physicalAttack(): Option[(Int, Int) => Int] = {
    println("Warrior using physicalAttack.");
    Some{
      (foeStrength: Int, foeWisdom: Int) => 
        val damage = (strength - foeStrength)/3 + Dice.roll(2)
        if(damage > 0) damage else 0
    }
  }
}  

trait Wizard extends Character {
  override def toString = super.toString + "\n is a wizard"

  // Good with spells
  override def magicalAttack(): Option[(Int, Int) => Int]  = {
    println("Wizard using magicalAttack.");
    Some{
      (foeStrength: Int, foeWisdom: Int) => 
        val damage = (wisdom- foeWisdom)/3 + Dice.roll(2)
        if(damage > 0) damage else 0
    }
  }
}  


