package com.programmera.scalaland_func1

class MagicalItemList(
  items: List[MagicalItem] = List[MagicalItem]()){

  def add(item: MagicalItem): MagicalItemList = {
    return new MagicalItemList(item :: items)
  }

  def calculateModifier(feature: CharacterFeature.Value): Int = {
    items.map{ item =>
      item.extractItemBonusFromFeature(feature) 
    }.foldLeft(0)(_ + _)
  }

  override def toString = {
    val ret: String = if(items.length > 0){
      items.map("\n "+ _).mkString
    }else{
      ""
    }
    "---- Magical Items ----" + ret +
    "\n-----------------------"
  }
}

class MagicalItem(val description: String,
    val strengthModifier: Int = 0,
    val wisdomModifier: Int = 0,
    val charismaModifier: Int = 0){

  def extractItemBonusFromFeature(feature: CharacterFeature.Value): Int = {
    feature match{
      case CharacterFeature.Strength =>  strengthModifier
      case CharacterFeature.Wisdom   =>  wisdomModifier
      case CharacterFeature.Charisma =>  charismaModifier
    }
  }

  override def toString = {
    val str = if(strengthModifier != 0)  " str "+strengthModifier
    else ""
    val wis = if(wisdomModifier != 0)  " wis "+ wisdomModifier
    else ""
    val cha = if(charismaModifier != 0)  " cha "+ charismaModifier
    else ""
    description + " (" + str + wis + cha + " )"
  }
}

