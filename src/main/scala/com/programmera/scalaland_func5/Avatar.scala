package com.programmera.scalaland_func5 

object CharacterFeature extends Enumeration{
   val Strength, Wisdom, Charisma = Value 
}

object AvatarRace extends Enumeration{
   val Elf, Dwarf = Value
}

object AvatarProfession extends Enumeration{
   val Thief, Warrior, Wizard = Value
}

object Avatar {

  def apply( profession: AvatarProfession.Value,
      race: AvatarRace.Value,
      name: String,
      strength: Int,
      wisdom: Int,
      charisma: Int,
      hitpoints: Int,
      items: MagicalItemList
  ): Profession = {
    race match {
      case AvatarRace.Dwarf => {
        profession match {
          case AvatarProfession.Thief => 
            new Dwarf(profession, name, strength, wisdom, 
              charisma, hitpoints, items) with Thief
          case AvatarProfession.Warrior=>
            new Dwarf(profession, name, strength, wisdom, 
              charisma, hitpoints, items) with Warrior
          case AvatarProfession.Wizard=>
            new Dwarf(profession, name, strength, wisdom, 
              charisma, hitpoints, items) with Wizard
        }
      }
      case AvatarRace.Elf => {
        profession match {
          case AvatarProfession.Thief =>
            new Elf(profession, name, strength, wisdom, 
              charisma, hitpoints, items) with Thief
          case AvatarProfession.Warrior=>
            new Elf(profession, name, strength, wisdom, 
              charisma, hitpoints, items) with Warrior
          case AvatarProfession.Wizard=>
            new Elf(profession, name, strength, wisdom, 
              charisma, hitpoints, items) with Wizard
        }
      }
    }
  }

  // Used to update a character feature
  def apply( oldAvatar: Avatar,
    feature: CharacterFeature.Value,
    newValue: Int
  ): Profession = {
    var tmpStr = oldAvatar.strength
    var tmpWis = oldAvatar.wisdom
    var tmpCha = oldAvatar.charisma
    feature match {
      case CharacterFeature.Strength => tmpStr = newValue
      case CharacterFeature.Wisdom => tmpWis = newValue
      case CharacterFeature.Charisma => tmpCha = newValue
    }
    Avatar( oldAvatar.profession,
      oldAvatar.race,
      oldAvatar.name,
      tmpStr,
      tmpWis,
      tmpCha,
      oldAvatar.hitpoints,
      oldAvatar.items);
  }

  // Used to update hitpoints or item list
  def apply( oldAvatar: Avatar,
      hitpoints: Int,
      items: MagicalItemList
  ): Profession = {
    Avatar( oldAvatar.profession,
      oldAvatar.race,
      oldAvatar.name,
      oldAvatar.m_strength,
      oldAvatar.m_wisdom,
      oldAvatar.m_charisma,
      hitpoints,
      items);
  }
}

abstract class Avatar{
  val profession: AvatarProfession.Value
  val race: AvatarRace.Value
  val name: String
  protected val m_strength: Int
  protected val m_wisdom: Int
  protected val m_charisma: Int
  val hitpoints: Int
  val items: MagicalItemList

  // Inspectors
  def strength = m_strength +
    items.calculateModifier(CharacterFeature.Strength)
  def wisdom = m_wisdom +
    items.calculateModifier(CharacterFeature.Wisdom)
  def charisma = m_charisma +
    items.calculateModifier(CharacterFeature.Charisma)

  // Builders
  def setStrength(newStrength: Int) = 
    Avatar(this, CharacterFeature.Strength, newStrength)
  def setWisdom(newWisdom: Int) = 
    Avatar(this, CharacterFeature.Wisdom, newWisdom)
  def setCharisma(newCharisma: Int) = 
    Avatar(this, CharacterFeature.Charisma, newCharisma)
  def setHitpoints(newHitpoints: Int) = {
    // An avatar can not exist with negative hitpoints
    require( newHitpoints > -1 )
    Avatar(this, newHitpoints, items)
  }
  def addItem(newItem: MagicalItem) = 
    Avatar(this, hitpoints, items.add(newItem))

  override def toString = "Avatar: " + name +
    "\n (strength: "+ m_strength + ", wisdom: "+ m_wisdom +
    ", charisma: "+ m_charisma + ")" +
    "\n hitpoints: "+ hitpoints +
    "\n"+ items
}

object Elf{
  def apply(profession: AvatarProfession.Value, name: String) = {
    val tmpStr = Dice.roll(2)
    Avatar(profession,
        AvatarRace.Elf,
        name,
        tmpStr,
        Dice.roll(4),
        Dice.roll(4),
        tmpStr * 2,
        new MagicalItemList()
    )
  }
}

class Elf(override val profession: AvatarProfession.Value,
    override val name: String,
    override protected val m_strength: Int,
    override protected val m_wisdom: Int,
    override protected val m_charisma: Int,
    override val hitpoints: Int,
    override val items: MagicalItemList = new 
      MagicalItemList(List[MagicalItem]())
 ) extends Avatar{
  override val race = AvatarRace.Elf
  override def toString = super.toString + "\n is an elf."
}

object Dwarf{
  def apply(profession: AvatarProfession.Value, name: String) = {
    val tmpStr = Dice.roll(4)
    Avatar(profession,
        AvatarRace.Dwarf,
        name,
        tmpStr,
        Dice.roll(3),
        Dice.roll(2),
        tmpStr * 2,
        new MagicalItemList()
    )
  }
}

class Dwarf(override val profession: AvatarProfession.Value,
    override val name: String,
    override protected val m_strength: Int,
    override protected val m_wisdom: Int,
    override protected val m_charisma: Int,
    override val hitpoints: Int,
    override val items: MagicalItemList = new 
      MagicalItemList(List[MagicalItem]())
 ) extends Avatar{
  override val race = AvatarRace.Dwarf
  override def toString = super.toString + "\n is a dwarf."
}


