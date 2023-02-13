package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        //Récuperation du User parcelable dans UserDetailActivity
        val user = intent.getParcelableExtra<User>("User")

        //récupération des champs
        val nameTextView = findViewById<TextView>(R.id.name) as TextView
        val ageTextView = findViewById<TextView>(R.id.age) as TextView

        // On set les values
        nameTextView.setText("Nom:  ${user?.name}")
        ageTextView.setText("Age:  ${user?.age}")
    }
}