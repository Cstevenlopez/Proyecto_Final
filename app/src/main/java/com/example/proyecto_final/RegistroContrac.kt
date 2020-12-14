package com.example.proyecto_final

import android.provider.BaseColumns

class RegistroContrac {

    companion object
    {
        val VERSION = 1
        class Entrada: BaseColumns
        {
            companion object
            {
                val NOMBRE_TABLA = "RegistrarDatos"

                val COLUMNA_ID = "Id"
                val COMLUMNA_COMUNIDAD = "Comunidad"
                val COLUMNA_NOMBRE = "Nombre"
                val COLUMNA_ACTIVIDAD = "Actividad"
                val COLUMNA_TEMA = "Tema"
                val COLUMNA_OBJETIVO = "Objetivo"
                val COLUMNA_RESUMEN = "Resumen"
            }
        }
    }
}