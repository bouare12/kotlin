package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class NoteDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRAT_NOTE = "note"
        val EXTRAT_NOTE_INDEX = "noteIndex"
    }

    lateinit var note: Note
    var noteIndex: Int = 1

    lateinit var titleView: TextView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // val user = intent.getParcelableExtra<User>("User")
        note = intent.getParcelableExtra<Note>(EXTRAT_NOTE)!!
        noteIndex = intent.getIntExtra(EXTRAT_NOTE_INDEX, -1)

        titleView = findViewById(R.id.title)
        textView = findViewById(R.id.text)

        titleView.text = note.title
        textView.text = note.text
    }
}