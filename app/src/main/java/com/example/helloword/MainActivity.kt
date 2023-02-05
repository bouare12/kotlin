package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.helloword.common.name
import com.example.helloword.common.personne

class Pers( name : String,  age: Int, poids: Float) {

    val canPlayFoot = age > 6 && poids > 15.60f
    init {
        val footPlayer = when(canPlayFoot) {
            true -> "Joue au football"
            false -> "Ne peut pas jouer au foot"
        }
        println("Info personne : $name , $age, $footPlayer")
    }

    constructor(name: String): this(name, 5, 5.1f)
    fun danse() {
        println("La personne danse bien au Tango")
    }

}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personne = Pers("tom", 10, 20.70f)
        var personne1 = Pers("Jerry")
        println(personne1.danse())
    }
}