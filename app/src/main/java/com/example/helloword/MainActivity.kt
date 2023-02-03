package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.helloword.common.name
import com.example.helloword.common.personne

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // name = "Jerry"
        println("Name importer est $name")
        personne()
    }
}