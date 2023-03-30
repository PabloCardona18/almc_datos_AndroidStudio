package com.example.almc_datos

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class mensaje_datos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje_datos)

        val campoMensaje=findViewById<TextView>(R.id.txtMensaje)
        val campoMensaje1=findViewById<TextView>(R.id.txtMensaje1)

        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        var user: String? =preferences.getString("user","No existe la información")
        var pass: String? =preferences.getString("pass","No existe la información")

        campoMensaje?.text=user
        campoMensaje1?.text=pass

        val botonSalir: Button =findViewById(R.id.btnSalir)
        botonSalir.setOnClickListener{onClick()}
    }

    private fun onClick() {
        finish()
    }
}
