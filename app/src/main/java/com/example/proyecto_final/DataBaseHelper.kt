package com.example.proyecto_final

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context): SQLiteOpenHelper(context, RegistroContrac.Companion.Entrada.NOMBRE_TABLA, null, RegistroContrac.Companion.VERSION)
{
    companion object
    {
        val CREATE_REGISTRO_TABLA = "CREATE TABLE" + RegistroContrac.Companion.Entrada.NOMBRE_TABLA +
                "(" + RegistroContrac.Companion.Entrada.COLUMNA_ID   + "TEXT PRIMARY KEY ," +
                RegistroContrac.Companion.Entrada.COMLUMNA_COMUNIDAD + "TEXT " +
                RegistroContrac.Companion.Entrada.COLUMNA_NOMBRE     + "TEXT " +
                RegistroContrac.Companion.Entrada.COLUMNA_ACTIVIDAD  + "TEXT " +
                RegistroContrac.Companion.Entrada.COLUMNA_TEMA       + "TEXT " +
                RegistroContrac.Companion.Entrada.COLUMNA_OBJETIVO   + "TEXT " +
                RegistroContrac.Companion.Entrada.COLUMNA_RESUMEN    + "TEXT )"

                val REMOVE_DATOS_TABLA = "DROP TABLE IF EXISTS" + RegistroContrac.Companion.Entrada.NOMBRE_TABLA
    }
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL(CREATE_REGISTRO_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, i: Int, i2: Int)
    {
         db?.execSQL(REMOVE_DATOS_TABLA)
        onCreate(db)
    }

}