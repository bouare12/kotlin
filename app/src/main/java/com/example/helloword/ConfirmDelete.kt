package com.example.helloword

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class ConfirmDelete : DialogFragment () {

    val TAGS = ConfirmDelete::class.java.simpleName

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Voulez tout supprimer?")
            .setPositiveButton("Oui Oui", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, id: Int) {
                    Log.i(TAGS, "C'est supprimer maintenant !")
                }
            })
            .setNegativeButton("Non Non", DialogInterface.OnClickListener { dialog, id ->
                Log.i(TAGS, "Non ça sera pour une prochaine fois !")
            })
        return builder.create()
    }
}