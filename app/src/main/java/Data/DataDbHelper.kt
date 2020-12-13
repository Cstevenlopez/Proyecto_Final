package Data

import android.app.Person
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataDbHelper (context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null,
DATABASE_VERSION) {

    private val db: SQLiteDatabase
        private val values:ContentValues
        companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "DBRegis"
    }
    init {
        db = this.writableDatabase
        values = ContentValues()
    }
    override fun onCreate(db: SQLiteDatabase?)
    {
        db!!.execSQL("CREATE TABLE" +Tables.Registrar.TABLE_NAME+"(" +
          Tables.Registrar._ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
        + Tables.Registrar.COLUMN_COMUNIDAD+ "TEXT NOT NULL,"
        + Tables.Registrar.COLUMN_NOMBRE + "TEXT NOT NULL,"
        + Tables.Registrar.COLUMN_ACTIVIDAD + "TEXT NOT NULL,"
        + Tables.Registrar.COLUMN_OBJETIVO+ "TEXT NOT NULL,"
        + Tables.Registrar.COLUMN_TEMAS + "TEXT NOT NULL"
        + Tables.Registrar.COLUMN_RESUMEN  + "TEXT NOT NULL,"
        + Tables.Registrar.COLUM_TYPE + "TEXT NOT NULL)");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
     fun insert (registrar: List<Person>)
     {

     }
    }
}