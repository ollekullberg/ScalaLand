package com.programmera.scalaland1a

abstract class Avatar(name: String){
  override def toString = "Avatar: " + name 
}

class Elf(name: String) extends Avatar(name){
  override def toString = super.toString + " is an elf."
}

class Dwarf(name: String) extends Avatar(name){
  override def toString = super.toString + " is a dwarf."
}
