package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.helloword.common.name
import com.example.helloword.common.personne

open class Vehicule(val nbrDeRoue: Int) {

    fun showNbrDeRoue () {
        println("Le nombre de roues est : $nbrDeRoue")
    }
}
class Voiture: Vehicule(4)
class Tricycle: Vehicule(3)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val voiture = Voiture()
        voiture.showNbrDeRoue()
        val triclycle = Tricycle()
        triclycle.showNbrDeRoue()
    }
}