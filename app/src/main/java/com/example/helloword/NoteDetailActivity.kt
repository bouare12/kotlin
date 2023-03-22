package com.example.helloword

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class NoteDetailActivity : AppCompatActivity() {

    companion object {
        val REQUES_EDIT_NOTE = 1
        val EXTRAT_NOTE = "note"
        val EXTRAT_NOTE_INDEX = "noteIndex"

        val ACTION_SAVE_NOTE = "com.example.helloword.actions.ACTION_SAVE_NOTE"
        val ACTION_DELETE_NOTE = "com.example.helloword.actions.ACTION_DELETE_NOTE"
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
        noteIndex = intent.getIntExtra(EXTRAT_NOTE_INDEX, noteIndex)

        titleView = findViewById(R.id.title)
        textView = findViewById(R.id.text)

        titleView.text = note.title
        textView.text = note.text
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_note_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_save -> {
                saveNote()
                true
            }
            R.id.action_delete -> {
                showConfirmDelteDialog()
                 return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showConfirmDelteDialog() {

        val confirmFragment = ConfirmDeleteNoteDialog(note.title)
        confirmFragment.listener = object :ConfirmDeleteNoteDialog.ConfirmDeleteDialogListener {
            override fun onDialogPositiveClick() {
                deleteNote ()
            }
            override fun onDialogNegativeClick() {}
        }
        confirmFragment.show(supportFragmentManager,"ConfirmDeleteDialog")
    }

    fun deleteNote () {
        intent = Intent(ACTION_DELETE_NOTE)
        intent.putExtra(EXTRAT_NOTE_INDEX, noteIndex)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun saveNote() {
        note.title = titleView.text.toString()
        note.text = textView.text.toString()

        intent = Intent(ACTION_SAVE_NOTE)
        intent.putExtra(EXTRAT_NOTE, note)
        intent.putExtra(EXTRAT_NOTE_INDEX, noteIndex)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}