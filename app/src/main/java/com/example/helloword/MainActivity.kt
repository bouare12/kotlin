package com.example.helloword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import com.example.helloword.common.name
import com.example.helloword.common.personne

class MainActivity : AppCompatActivity() {

    val TAGS = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<TextView>(R.id.start_activity_green)
        button.setOnClickListener {
            val intent = Intent(this, GreenActivity::class.java)
            startActivity(intent)
        }
        Log.v(TAGS, "Verbose message")
        Log.d(TAGS, "Debug message")
        Log.i(TAGS, "Info message")
        Log.w(TAGS, "Warning message")
        Log.e(TAGS, "Error message")
        Log.println(Log.ASSERT, TAGS,"Assert message")
    }
}