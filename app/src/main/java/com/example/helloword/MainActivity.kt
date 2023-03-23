package com.example.helloword

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloword.utils.deleteNotePserist
import com.example.helloword.utils.loadNotes
import com.example.helloword.utils.persistNote
import com.google.android.material.floatingactionbutton.FloatingActionButton

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        findViewById<FloatingActionButton>(R.id.create_note_fab).setOnClickListener(this)

        notes = loadNotes(this)

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
        } else {
            when(view.id) {
                R.id.create_note_fab -> createNewNote()
            }
        }
    }

    private fun createNewNote() {
        showNoteDetail(-1)
    }

    private fun processEditNoteResult(data: Intent) {
        val noteIndex = data.getIntExtra(NoteDetailActivity.EXTRAT_NOTE_INDEX, 0)
        when (data.action) {
            NoteDetailActivity.ACTION_SAVE_NOTE -> {
                val note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRAT_NOTE)
                if (note != null) {
                    saveNote(note, noteIndex)
                }
            }
            NoteDetailActivity.ACTION_DELETE_NOTE -> {
                println("Index For Delete est $noteIndex")
                deleteNote(noteIndex)
            }
        }
        
    }


    private fun saveNote(note: Note, noteIndex: Int) {
        persistNote(this, note)
        if (noteIndex < 0) {
            notes.add(0,note)
        } else {
            notes[noteIndex] = note
        }
        adapter.notifyDataSetChanged()
    }

    private fun deleteNote(noteIndex: Int) {
        if (noteIndex < 0 ) {
            return
        }else{
            val note = notes.removeAt(noteIndex)
            deleteNotePserist(this, note)
        }
        adapter.notifyDataSetChanged()
    }

    fun showNoteDetail(noteIndex: Int) {
        val note = if (noteIndex < 0) Note() else notes[noteIndex]
        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRAT_NOTE, note as Parcelable)
        intent.putExtra(NoteDetailActivity.EXTRAT_NOTE_INDEX, note as Parcelable)
        startActivityForResult(intent, NoteDetailActivity.REQUES_EDIT_NOTE)
    }
}