package com.example.helloword

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.helloword.city.City

private const val DATABASE_NAME = "weather.bd"
private const val DATABASE_VERSION = 1

private const val CITY_TABLE_NAME = "city"
private const val CITY_KEY_ID = "id"
private const val CITY_KEY_NAME = "name"

private const val CITY_TABLE_CREATE = """
    CREATE TABLE $CITY_TABLE_NAME ($CITY_KEY_ID INTEGER PRIMARY KEY, $CITY_KEY_NAME TEXT)
"""

class Database(context: Context):  SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CITY_TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun createCity(city: City) : Boolean {
        val values = ContentValues()
        values.put(CITY_KEY_NAME, city.name)

        Log.d("Création Data","Creation city: $values")

        val id = writableDatabase.insert(CITY_TABLE_NAME, null, values)
        city.id = id

        return id > 0
    }


}