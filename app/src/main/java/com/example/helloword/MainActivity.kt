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

        if ( age < 8 ) {
            println("${name.uppercase()}  est encore jeune")
        }

        if ( age >= 7 && height >= 1.40) {
            println("${name} peut faire du sky")
        } else{
            println("${name} ne peut pas encore faire du sky")
        }

        if (name == "Tom") {
            println("${name} est un garçon")
        }else if (name == "Fifi"){
            println("${name} est une fille")
        }else {
            println("On ne connait pas le sexe de cette ${name} là")
        }
    }
}
