package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var age: Int = 7
        var name: String = "Tom"
        var height: Float = 1.50F

        when (name) {
            "Tom" -> println("${name} est un chat");
            "Chien" -> println("${name} est un chien")
            else -> println("On ne connait pas le type de l'animal")
        }

        // Utilisation de when avec les intervalles

        when (age) {
            in 1..4 -> println("${name} est trop jeune")
            in 6..9 -> println("${name} peut jouer au foot")
            !in 1..18 -> println("${name} ne peut pas jouer avec les enfants")
            else -> println("Condition non gérée")
        }
    }
}
