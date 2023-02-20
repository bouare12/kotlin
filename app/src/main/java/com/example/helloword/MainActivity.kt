package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.show_button).setOnClickListener {
          val fragment = ConfirmDelete()
            fragment.listener = object: ConfirmDelete.ConfirmDeletePop {
                override fun dialogPositiveClick() {
                    Log.i("MainActivity", "dialogPositiveClick()")
                }

                override fun dialogNegativeClick() {
                    Log.i("MainActivity", "dialogPositiveClick()")
                }

            }
          fragment.show(supportFragmentManager, "ConfirmDelete")
        }
    }
}