package com.programmera.scalaland_func1

object CharacterFeature extends Enumeration{
   val Strength, Wisdom, Charisma = Value 
}

abstract class Avatar{
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
  override def toString = super.toString + "\n is a dwarf."
}

