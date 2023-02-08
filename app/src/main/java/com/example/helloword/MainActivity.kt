package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.helloword.common.name
import com.example.helloword.common.personne

data class Personne (val  name: String, val age: Int) {

}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fonction tostring Ex
        val tom = Personne("Tom", 7)
        println("toString info sur $tom")

        val jerry = Personne("Jerry", 4)
        println("mtoString info sur $jerry")

        // fonction copy
        val mario = tom.copy("Mario")
        println("mtoString info sur $mario")

        //fonction equal
        if (tom == mario) {
            println("ils sont pareills")
        } else {
            println("ils sont differents")
        }
    }
}