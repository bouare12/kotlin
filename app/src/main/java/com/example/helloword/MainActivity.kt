package com.example.helloword

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK || data == null) {
            return
        }
        when (requestCode) {
            NoteDetailActivity.REQUES_EDIT_NOTE -> processEditNoteResult(data)
        }
    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            showNoteDetail(view.tag as Int)
        }
    }

    private fun processEditNoteResult(data: Intent) {
        val noteIndex = data.getIntExtra(NoteDetailActivity.EXTRAT_NOTE_INDEX, -1)
        val note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRAT_NOTE)
        if (note != null) {
            saveNote(note, noteIndex)
        }
    }

    private fun saveNote(note: Note, noteIndex: Int) {
        notes[noteIndex] = note
        adapter.notifyDataSetChanged()
    }

    fun showNoteDetail(noteIndex: Int) {
        val note = notes[noteIndex]

        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRAT_NOTE, note)
        intent.putExtra(NoteDetailActivity.EXTRAT_NOTE_INDEX, note)
        startActivityForResult(intent, NoteDetailActivity.REQUES_EDIT_NOTE)
    }
}