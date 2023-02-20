package com.example.helloword

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class FileListDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val inflater = activity?.layoutInflater

        builder.setView(inflater?.inflate(R.layout.dialog_list, null))
            .setPositiveButton("Supprimer", null)
            .setNegativeButton("Annuler", null)
            .setTitle("contenu à Suprimé")

        return builder.create()
    }
}