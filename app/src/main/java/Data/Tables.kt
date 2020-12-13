package Data

import android.app.Person


class Tables {
    abstract  class Registrar
    {
        companion object
        {
            val _ID = "_id"
            val COLUMN_COMUNIDAD = "comunidad"
            val COLUMN_NOMBRE = "nombre_productor"
            val COLUMN_ACTIVIDAD = "nombre_de_la_actividad"
            val COLUMN_OBJETIVO = "objetivo"
            val COLUMN_TEMAS = "temas"
            val COLUMN_RESUMEN = "resumen"
            val TABLE_NAME = "DBRegis"
            val COLUM_TYPE = "type"
            var person: MutableList<Person> = ArrayList()
        }
    }
}