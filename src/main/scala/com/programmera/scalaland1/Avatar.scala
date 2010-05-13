package com.programmera.scalaland1

class Avatar(val name: String){
  override def toString = "Avatar: " + name 
}

class Elf(override val name: String) extends Avatar(name){
  override def toString = super.toString + " is an elf."
}

class Dwarf(override val name: String) extends Avatar(name){
  override def toString = super.toString + " is a dwarf."
}
