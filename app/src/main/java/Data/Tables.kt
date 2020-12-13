package Data

class Tables {
    abstract  class Registrar
    {
        companion object
        {

            val ID = "_id"
            val TABLE_NAME = "Registro_bitacora"
            val COLUM_NAME = "name"
            val COLUM_TYPE = "type"
            var registrar: MutableList<Registrar> = ArrayList()

        }
    }
}