package com.programmera.scalaland_func2

object CharacterFeature extends Enumeration{
   val Strength, Wisdom, Charisma = Value 
}

object AvatarRace extends Enumeration{
   val Elf, Dwarf = Value
}

object Avatar {

  def apply( race: AvatarRace.Value,
      name: String,
      strength: Int,
      wisdom: Int,
      charisma: Int,
      hitpoints: Int,
      items: MagicalItemList
  ): Avatar = {
    race match {
      case AvatarRace.Dwarf => 
        new Dwarf(name, strength, wisdom, charisma, hitpoints, items)
      case AvatarRace.Elf =>
        new Elf(name, strength, wisdom, charisma, hitpoints, items)
    }
  }

  // Used to update a character feature
  def apply( oldAvatar: Avatar,
    feature: CharacterFeature.Value,
    newValue: Int
  ): Avatar = {
    var tmpStr = oldAvatar.strength
    var tmpWis = oldAvatar.wisdom
    var tmpCha = oldAvatar.charisma
    feature match {
      case CharacterFeature.Strength => tmpStr = newValue
      case CharacterFeature.Wisdom => tmpWis = newValue
      case CharacterFeature.Charisma => tmpCha = newValue
    }
    Avatar( oldAvatar.race,
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
  ): Avatar = {
    Avatar( oldAvatar.race,
      oldAvatar.name,
      oldAvatar.m_strength,
      oldAvatar.m_wisdom,
      oldAvatar.m_charisma,
      hitpoints,
      items);
  }
}

abstract class Avatar{
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
  def apply(name: String) = {
    val tmpStr = Dice.roll(2)
    new Elf(name,
        m_strength = tmpStr,
        m_wisdom = Dice.roll(4),
        m_charisma = Dice.roll(4),
        hitpoints = tmpStr * 2,
        new MagicalItemList()
    )
  }
}

class Elf(override val name: String,
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
  def apply(name: String) = {
    val tmpStr = Dice.roll(4)
    new Dwarf(name,
        m_strength = tmpStr,
        m_wisdom = Dice.roll(3),
        m_charisma = Dice.roll(2),
        hitpoints = tmpStr * 2,
        new MagicalItemList()
    )
  }
}

class Dwarf(override val name: String,
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


