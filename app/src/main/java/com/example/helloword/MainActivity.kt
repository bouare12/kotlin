package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..6) {
           println("Affichage de i ${i}")
        }

        for (i in 1..6 step 2) {
            println("affiche de i par step de 2 ${i}")
        }

        for (i in 6 downTo 1) {
            println("Affiche i de façon decroissante ${i}")
        }

        val animaux: Array<String> = arrayOf("Chat", "Chien", "vache", "cheval")

        for(i in 0..animaux.size) {
            println("Affichage des animaux avec for ${animaux[i]}")
        }

        for (animal in animaux) {
            println("Affichage des animaux avec foreach ${animal}")
        }

    }
}