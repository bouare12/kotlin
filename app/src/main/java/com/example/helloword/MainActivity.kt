package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animaux: Array<String> = arrayOf("Chat", "Chien", "vache", "cheval")

        for ((index, animal) in animaux.withIndex()) {
           println("$animal est à l'index $index")
        }

        for (animal in animaux) {
            if (animal == "vache") {
                println("${animal} animal est present n'est pas present")
                continue
            }
            println("${animal} animal est present")
        }

    }
}