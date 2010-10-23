package com.programmera.scalaland_immutable1

case class MagicalItem(
    description: String,
    modifiers: Map[CreatureFeature.Value,Int]) {

  def getModifier(feature : CreatureFeature.Value) =
    modifiers.get(feature).getOrElse(0)

  override def toString = {
    val modStr = modifiers.map { x => x._1 +" "+ x._2 }.mkString(", ")
    "%s (%s)".format(description, modStr)
  }
}






