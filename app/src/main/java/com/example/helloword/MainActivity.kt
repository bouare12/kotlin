package com.example.helloword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.example.helloword.common.name
import com.example.helloword.common.personne

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<TextView>(R.id.start_activity_green)
        button.setOnClickListener {
            val intent = Intent(this, GreenActivity::class.java)
            // Ajout des actions à intent
            intent.action = Intent.ACTION_VIEW
            startActivity(intent)
        }
    }
}