package com.example.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //setup
        val bundle: bundle? = itent.extras
        val email?.getString("email")
        val provider?.getString("provider")
        setup(email ?:"",provider ?:"")
    }
    private fun setup(email:String,provider: String){
        title="Inicio"
        emailTextView.text= email
        providerTextView.text=provider
    }
}