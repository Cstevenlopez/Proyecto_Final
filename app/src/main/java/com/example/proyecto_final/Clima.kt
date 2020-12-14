package com.example.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception
import kotlin.math.log

class Clima : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima)
        if(Network.hayRed(this))
        {
            Toast.makeText(this, "Hay red", Toast.LENGTH_SHORT).show()
            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id=3616253&appid=ed006f0d32b20db6da1aaf5008f20bcc&lang=es&units=metric")
        }else{
            Toast.makeText(this, "No hay red",Toast.LENGTH_SHORT).show()
        }
    }
    fun solicitudHTTPVolley(url:String)
    {
        val queve =Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET,url,Response.Listener<String>{
                response ->
            try{
                Log.d("ResultadoVolley",response)
                val gson = Gson()
                val ciudad = gson.fromJson(response,Ciudad::class.java)
                val tvGrados: TextView = findViewById(R.id.tvGrados)
                val tvCiudad: TextView = findViewById(R.id.tvCiudad)
                val tvDescripcion: TextView = findViewById(R.id.tvDescripcion)
                tvGrados.text = ciudad.main!!.temp.toString()
                tvCiudad.text = ciudad.name
                tvDescripcion.text = ciudad.weather!!.get(0).description



            } catch (e:Exception){

            }

        },Response.ErrorListener {
            Log.e("ErrorVolley","Error Extra;o")
        })
        queve.add(solicitud)
    }
}