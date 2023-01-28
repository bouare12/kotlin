package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var age: Int = 10
        var name: String = "tom"
        var heights: Float = 1.80f
        println("${name} a ${age} ans ")
        age = 30
        println("${name} a ${age} ans ")
        age /= 2
        println("${name} a ${age} ans ")

        println("String template simple: $name à $age ans")
        println("String template simple complexe : ${name.uppercase()} à ${age + 5} ans")

        println("Concatenation : " + "Nom " + name + "Age " + age)

        println("""Raw string : Nom : $name Age : $age ans """)

    }
}
