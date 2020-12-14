package com.example.proyecto_final

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RegistroCRUD (context: Context) {
    private var helper: DataBaseHelper? = null

    init {
        helper = DataBaseHelper(context)
    }

    fun newRegistro(item: Registro) {
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
        val newRowId = db.insert(RegistroContrac.Companion.Entrada.NOMBRE_TABLA, null, values)
        db.close()
    }

    fun getRegistros(): ArrayList<Registro> {
        val items: ArrayList<Registro> = ArrayList()

        //Abrir base de datos en modo lectura
        val db: SQLiteDatabase = helper?.readableDatabase!!


        // Especificar las columnas que se van a consultar
        val columnas = arrayOf(RegistroContrac.Companion.Entrada.COLUMNA_ID, RegistroContrac.Companion.Entrada.COMLUMNA_COMUNIDAD, RegistroContrac.Companion.Entrada.COLUMNA_NOMBRE, RegistroContrac.Companion.Entrada.COLUMNA_ACTIVIDAD, RegistroContrac.Companion.Entrada.COLUMNA_TEMA, RegistroContrac.Companion.Entrada.COLUMNA_OBJETIVO, RegistroContrac.Companion.Entrada.COLUMNA_RESUMEN)

        //Crear un cursor para recorrer la tabla

        val c: Cursor = db.query(
                RegistroContrac.Companion.Entrada.NOMBRE_TABLA,
                columnas,
                null,
                null,
                null,
                null,
                null
        )
        while (c.moveToNext()) {
            items.add(Registro(
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_ID)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COMLUMNA_COMUNIDAD)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_NOMBRE)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_ACTIVIDAD)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_TEMA)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_OBJETIVO)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_RESUMEN)),
            ))
        }
        //CerrarDB
        db.close()

        return items
    }

    fun getRegistro(Id: String): Registro {
        var item: Registro? = null

        val db: SQLiteDatabase = helper?.readableDatabase!!
        val columnas = arrayOf(RegistroContrac.Companion.Entrada.COLUMNA_ID, RegistroContrac.Companion.Entrada.COMLUMNA_COMUNIDAD, RegistroContrac.Companion.Entrada.COLUMNA_NOMBRE, RegistroContrac.Companion.Entrada.COLUMNA_ACTIVIDAD, RegistroContrac.Companion.Entrada.COLUMNA_TEMA, RegistroContrac.Companion.Entrada.COLUMNA_OBJETIVO, RegistroContrac.Companion.Entrada.COLUMNA_RESUMEN)

        val c: Cursor = db.query(
                RegistroContrac.Companion.Entrada.NOMBRE_TABLA,
                columnas,
                "Id = ?",
                arrayOf(Id),
                null,
                null,
                null
        )
        while (c.moveToNext()) {
            item = Registro(c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_ID)),
                            c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COMLUMNA_COMUNIDAD)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_NOMBRE)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_ACTIVIDAD)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_TEMA)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_OBJETIVO)),
                    c.getString(c.getColumnIndexOrThrow(RegistroContrac.Companion.Entrada.COLUMNA_RESUMEN)))
        }
        c.close()
        return item!!;
    }
}