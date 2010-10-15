package com.programmera.scalaland5

class Avatar( val name: String ) extends Professional {

  // Fields
  private var m_strength = 0
  private var m_wisdom = 0
  private var m_charisma = 0
  private var m_hitpoints = 0
  val items = new MagicalItemList()

  // Initialize class
  generateCreatureFeatures()
 
  // Setters and getters 
  def strength = m_strength + 
    items.calculateModifier(CreatureFeature.Strength)
  def strength_=(s: Int) { m_strength = s}
  def wisdom = m_wisdom + 
    items.calculateModifier(CreatureFeature.Wisdom)
  def wisdom_=(w: Int) { m_wisdom = w}
  def charisma = m_charisma + 
    items.calculateModifier(CreatureFeature.Charisma)
  def charisma_=(c: Int) { m_charisma = c}
  def hitpoints= m_hitpoints 
  def hitpoints_=(h: Int) { 
    println("Hitpoints, old value: " + hitpoints + ", new value: " + h)
    if(h > 0)
      m_hitpoints = h
    else
      throw new DeathException(name + " died!")
  }

  // super will call toString in Creature
  override def toString = super.toString + """
    |(strength: %d, wisdom: %d, charisma: %d)
    |%s """.stripMargin.
    format(m_strength, m_wisdom, m_charisma, items.toString )

}



