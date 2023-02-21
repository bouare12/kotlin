package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> {
                Toast.makeText(this, "Ajouter", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_delete -> {
                Toast.makeText(this, "Supprimer", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_save -> {
                Toast.makeText(this, "Enregister", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_help -> {
                Toast.makeText(this, "Aide", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}