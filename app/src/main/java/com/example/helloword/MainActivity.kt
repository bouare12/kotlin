package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notes = mutableListOf<Note>()
        notes.add(Note("Note 1", "tototototatatat"))
        notes.add(Note("Memo Revision", "aaaeazeazrzarazr"))
        notes.add(Note("Mémo Sport", "zefzefezf"))
        notes.add(Note("Mémo Jeu", "fzefzefze"))
        notes.add(Note("Mémo Voyage", "ldlmeflef"))

        adapter = NoteAdapter(notes, this)

        val recyclerView = findViewById<RecyclerView>(R.id.notes_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            Log.i("NotesListActivity","Click sur une")
        }
    }
}