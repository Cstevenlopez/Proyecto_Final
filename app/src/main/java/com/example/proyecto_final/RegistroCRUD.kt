package com.example.proyecto_final

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RegistroCRUD (context: Context)
{
    private var helper:DataBaseHelper? = null
    init
    {
        helper = DataBaseHelper(context)
    }
    fun  newRegistro(item:Registro)
    {
        //Abrir la base de datos
        val db: SQLiteDatabase = helper?.writableDatabase!!

        val values = ContentValues()
        //mapeo de las columnas
        values.put(RegistroContrac.Companion.Entrada.COLUMNA_ID, item.Id)
        values.put(RegistroContrac.Companion.Entrada.COLUMNA_ID, item.Comunidad)
        values.put(RegistroContrac.Companion.Entrada.COLUMNA_ID, item.Nombre)
        values.put(RegistroContrac.Companion.Entrada.COLUMNA_ID, item.Actividad)
        values.put(RegistroContrac.Companion.Entrada.COLUMNA_ID, item.Tema)
        values.put(RegistroContrac.Companion.Entrada.COLUMNA_ID, item.Objetivo)
        values.put(RegistroContrac.Companion.Entrada.COLUMNA_ID, item.Resumen)

        //Insertar una nueva fila en la tabla
        //Llamar a la funcion insertar y el nombre de la tabla donde se insertaran los datos
        val newRowID = db.insert(RegistroContrac.Companion.Entrada.NOMBRE_TABLA, null, values)
        db.close()

    }
}