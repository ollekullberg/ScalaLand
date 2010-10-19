package com.programmera.scalaland_generic

case class MagicalItem(
    description: String,
    modifiers: Map[CreatureFeature.Value,Int]){

  def getModifier(feature : CreatureFeature.Value) =
    modifiers.get(feature).getOrElse(0)

  override def toString = {
    val modStr = modifiers.map{ x => x._1 +" "+ x._2 }.mkString(", ")
    "%s (%s)".format(description, modStr)
  }
}

case class MagicalItemList(items: List[MagicalItem] = Nil){

  def add(item: MagicalItem) = MagicalItemList(item :: this.items)

  def calculateModifier(feature: CreatureFeature.Value): Int = {
    items.foldLeft(0) { (sum, item) => 
      sum + item.getModifier(feature)
    }
  }

  override def toString = {
    val itemsStr = if( items.length > 0 ) items.mkString("", "\n","")
    else ""
    """---- Magical Items ----
    |%s
    |-----------------------""".stripMargin.format(itemsStr)
  }
}




