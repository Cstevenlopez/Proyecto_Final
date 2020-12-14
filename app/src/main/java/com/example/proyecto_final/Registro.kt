package com.example.proyecto_final

class Registro (Id:String, Comunidad:String, Nombre:String, Actividad:String, Tema:String,Objetivo:String,Resumen:String) {
    var Id:String? = null;
    var Comunidad:String? = null;
    var  Nombre:String? = null;
    var Actividad:String? = null;
    var Tema:String? = null;
    var Objetivo:String? = null;
    var Resumen:String? = null;

    init {
        this.Id = Id;
        this.Comunidad = Comunidad;
        this.Nombre = Nombre;
        this.Actividad = Actividad;
        this.Tema = Tema;
        this.Objetivo = Objetivo;
        this.Resumen = Resumen;
    }
}