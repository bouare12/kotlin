package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

fun persAge (age: Int) : Boolean {
    return age > 6
}

fun pers(name: String, age: Int, height: Float) {
    var canPlayFoot = when(persAge(age)) {
        true -> "Peut jouer au foot"
        false -> "Peur pas jouer au foot"
    }
    println("${name} à ${age}ans, mesure ${height}m et ${canPlayFoot}")
}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = "Tom"
        var age = 12
        var height = 1.5F

        pers(name, age, height)
    }
}
