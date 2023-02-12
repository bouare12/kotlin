package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_green)

        val action = intent.action
        Log.i("GreenActivity", "Action: $action")
    }
}