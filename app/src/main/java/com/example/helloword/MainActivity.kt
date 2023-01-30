package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variable Mutable
        var age: Int = 8
        age = 4
        println(age)

        // Variable Immuable
        val age: Int = 8
        age = 4
        println(age)


    }
}
