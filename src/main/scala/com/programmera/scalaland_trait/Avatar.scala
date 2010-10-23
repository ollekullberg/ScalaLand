package com.programmera.scalaland_trait

case class Avatar(name: String) extends Professional {

  // Fields
  val items = new MagicalItemList()

  // Initialize class
  generateCreatureFeatures()
 
  // Override getters
  override def strength = super.strength + 
    items.calculateModifier(CreatureFeature.Strength)
  override def wisdom = super.wisdom + 
    items.calculateModifier(CreatureFeature.Wisdom)
  override def charisma = super.charisma + 
    items.calculateModifier(CreatureFeature.Charisma)

  // super will call toString in Professional
  override def toString = super.toString + "\n" + items.toString 

}



