package com.programmera.scalaland_immutable3

object CreatureType extends Enumeration{
   val Elf, Dwarf = Value
}

object ProfessionalType extends Enumeration{
   val Thief, Warrior, Wizard = Value
}

class Avatar(
    val name: String, 
    optionalFeatures: Option[CreatureFeatureSet],
    optionalItems: Option[MagicalItemList]
    ) extends Professional {

  // Fields
  val items = optionalItems.getOrElse(new MagicalItemList())

  // Initialize class
  lazy val features: CreatureFeatureSet =
    optionalFeatures.getOrElse(generateCreatureFeatures())

  // Override getters
  override def strength = super.strength +
    items.calculateModifier(CreatureFeature.Strength)
  override def wisdom = super.wisdom +
    items.calculateModifier(CreatureFeature.Wisdom)
  override def charisma = super.charisma +
    items.calculateModifier(CreatureFeature.Charisma)

  // Private helper method used to update a feature 
  private def updateCreatureFeature( newFeatures: CreatureFeatureSet
      ): Avatar = 
    Avatar(this.items, newFeatures, this)

  // Setters
  def updateStrength(s: Int): Avatar =
    updateCreatureFeature(features.copy(strength = s))
  def updateWisdom(w: Int): Avatar =
    updateCreatureFeature(features.copy(wisdom = w))
  def updateCharisma(c: Int): Avatar =
    updateCreatureFeature(features.copy(charisma = c))
  def updateHitpoints(h: Int): Avatar = {
    println("setHitpoints() old value: " + hitpoints + ", new value: " + h)
    if(h > 0)
      updateCreatureFeature(features.copy(hitpoints = h))
    else
      throw new DeathException(name + " died!")
  }

  // Suffer damage
  def sufferDamage(damage: Int): Avatar = {
    println("Hitpoints before attack: "+ hitpoints)
    println("Damage: "+ damage)
    if( damage > 0 ) {
      val newHitpoints = hitpoints - damage
      updateHitpoints(newHitpoints)
    }else{
      this
    }
  }

  // Handy method
  def addItem(newItem: MagicalItem): Avatar = 
    Avatar(this.items.add(newItem), this.features, this)

  // super will call toString in Creature
  override def toString = super.toString + """
    |%s """.stripMargin.format(items.toString)

}

object Avatar {

  // Used first time an avatar is created
  def apply(
      name: String, 
      creature: CreatureType.Value, 
      profession: ProfessionalType.Value
      ): Avatar = {
    constructor(name, None, None, creature, profession)
  }

  // Used when the avatar already exists
  def apply(
      newItems: MagicalItemList,
      newFeatures: CreatureFeatureSet,
      avatar: Avatar
      ): Avatar = {

    val creatureType = avatar match {
      case e: Elf     => CreatureType.Elf
      case d: Dwarf   => CreatureType.Dwarf
    }

    val professionalType = avatar match {
      case t: Thief   => ProfessionalType.Thief
      case w: Warrior => ProfessionalType.Warrior
      case m: Wizard  => ProfessionalType.Wizard
    }

    constructor(avatar.name, Some(newFeatures), Some(newItems), creatureType,
      professionalType)
  }

  // Avatar main factory method
  private def constructor(
      name: String, 
      optFeats: Option[CreatureFeatureSet],
      optItems: Option[MagicalItemList],
      creature: CreatureType.Value, 
      profession: ProfessionalType.Value
      ): Avatar = {

    creature match {
      case CreatureType.Dwarf => {
        profession match {
          case ProfessionalType.Thief => 
            new Avatar(name, optFeats, optItems) with Dwarf with Thief
          case ProfessionalType.Warrior => 
            new Avatar(name, optFeats, optItems) with Dwarf with Warrior
          case ProfessionalType.Wizard => 
            new Avatar(name, optFeats, optItems) with Dwarf with Wizard
        }
      }
      case CreatureType.Elf => {
        profession match {
          case ProfessionalType.Thief => 
            new Avatar(name, optFeats, optItems) with Elf with Thief
          case ProfessionalType.Warrior => 
            new Avatar(name, optFeats, optItems) with Elf with Warrior
          case ProfessionalType.Wizard => 
            new Avatar(name, optFeats, optItems) with Elf with Wizard
        }
      }
    }
  }
}




