package com.programmera.scalaland4

abstract class Avatar(
    val name: String, 
    private var _strength: Int, 
    private var _wisdom: Int, 
    private var _charisma: Int) {

  var hitpoints = _strength * 2
  val items = new MagicalItemList()
  
  // Setters and getters 
  def strength = _strength + 
    items.calculateModifier(CreatureFeature.Strength)
  def strength_=(s: Int) { _strength = s }
  def wisdom = _wisdom + 
    items.calculateModifier(CreatureFeature.Wisdom)
  def wisdom_=(w: Int) { _wisdom = w }
  def charisma = _charisma + 
    items.calculateModifier(CreatureFeature.Charisma)
  def charisma_=(c: Int) { _charisma = c }
  
  override def toString = "Avatar: " + name +
    "\n (strength: "+ _strength + ", wisdom: "+ _wisdom +
    ", charisma: "+ _charisma + ")" +
    "\n"+ items
}

