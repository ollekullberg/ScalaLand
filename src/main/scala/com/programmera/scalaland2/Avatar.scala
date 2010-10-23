package com.programmera.scalaland2

abstract class Avatar(
    val name: String, 
    var strength: Int, 
    var wisdom: Int, 
    var charisma: Int) {
  var hitpoints = strength * 2
  override def toString = "Avatar: " + name +
    "\n (strength: "+ strength + ", wisdom: "+ wisdom +
    ", charisma: "+ charisma + ")"
}

