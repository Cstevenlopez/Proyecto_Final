package com.example.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore

class Bitacora : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitacora)
    }
    idguardar.setOnc
    lickListener{
     db.collection("users").document(email).set(
         hashMapOf("provider" to provider,
         "comunidad"to comunidadtextView.text.toString(),
         "nombrep"to NombreptextView.text.toString(),
             "nombrea"to nombreatextView.text.toString()),
     )
    }
}
