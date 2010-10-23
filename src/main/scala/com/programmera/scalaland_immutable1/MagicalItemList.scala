package com.programmera.scalaland_immutable1

case class MagicalItemList(items: List[MagicalItem] = Nil) {

  def add(item: MagicalItem) = MagicalItemList(item :: this.items)

  def calculateModifier(feature: CreatureFeature.Value): Int = {
    items.foldLeft(0) { (sum, item) => 
      sum + item.getModifier(feature)
    }
  }

  override def toString = {
    val itemsStr = if (items.length > 0) items.mkString("\n", "\n", "")
    else ""
    """---- Magical Items ---- %s
    |-----------------------""".stripMargin.format(itemsStr)
  }
}




