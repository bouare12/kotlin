package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val names = Array<String>(4) {""}
        names.set(0, "Tom")
        println(names[0])

        val ages = arrayOf(4,6,3)
        println(ages.get(2))

    }
}