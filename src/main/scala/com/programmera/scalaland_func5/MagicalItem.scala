package com.programmera.scalaland_func5

case class MagicalItemList(items : List[MagicalItem] = Nil){

  def add(item: MagicalItem) = copy(items = item :: this.items)

  def calculateModifier(feature: CharacterFeature.Value): Int = {
    items.foldLeft(0) {
      (sum,item) => sum + item.getModifier(feature)
    }
  }

  override def toString = items.mkString("---- Magical Items ----\n",
    "\n","\n-----------------------")
}

class MagicalItem(val description: String, 
    val modifiers : Map[CharacterFeature.Value,Int]){

  def getModifier(feature : CharacterFeature.Value) = 
    modifiers.get(feature).getOrElse(0)

  override def toString = { 
    val modStr = modifiers.view map( x => x._1 +" "+ x._2 ) mkString(", ")
    "%s (%s)".format(description, modStr)
  }
}


