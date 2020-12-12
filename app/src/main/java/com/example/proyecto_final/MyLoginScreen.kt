package com.example.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class MyLoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_login_screen)
        //Setup
        setup()
    }

        private fun setup() {
            title = "Autenticacion"
            signUpButton.setOnClickListener {
                if (emailEditText.text.isNotEmpy() && passwordEditText.text.isNotEmpy()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        emailEditText.text.toString(),
                        passwordEditText.texttoString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                        } else {
                        showAlert()
                        }

                    }
                }
            }
        }
private fun showAlert(){
    val builder= AlertDialog.Builder(this)
    builder.setTitle("Error")
    builder.setMessage("Se ha produciodo un error autenticando al usuario")
    builder.setPositiveButton("Aceptar",null)
    val dialog: AlertDialog = builder.create()
    dialog.show()
}
}