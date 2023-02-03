package com.example.helloword.common

var name = "Tom"
private set // Rend la modification privée

private val age = 8

fun personne() {
    name = "Jerry"
    println("La personne à le nom $name et est agée de $age ans")
}