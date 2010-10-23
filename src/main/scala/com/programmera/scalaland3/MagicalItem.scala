package com.programmera.scalaland3

case class MagicalItem(
    description: String,
    strengthModifier: Int = 0,
    wisdomModifier: Int = 0,
    charismaModifier: Int = 0) { 

  override def toString = {
    var ret: String = description + " ("
    if (strengthModifier != 0) ret += " str "+ strengthModifier
    if (wisdomModifier != 0) ret += " wis "+ wisdomModifier
    if (charismaModifier != 0) ret += " cha "+ charismaModifier
    ret += " )"
    ret
  }
}

