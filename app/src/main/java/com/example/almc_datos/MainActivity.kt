package com.example.almc_datos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var campoUsuario: EditText?=null
    var campoContraseña: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCargar: Button =findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener{cargarDatos()}

    }

    private fun cargarDatos() {
        val campoUsuario:EditText?=findViewById(R.id.idCampoUser)
        val  campoContraseña:EditText?=findViewById(R.id.idCampoPass)

        var preferences:SharedPreferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var editor:SharedPreferences.Editor=preferences.edit()
        var usuario= campoUsuario?.text.toString()
        var pass= campoContraseña?.text.toString()

        editor.putString("user", usuario)
        editor.putString("pass", pass)

        editor.commit()

        var intent:Intent=Intent(this, mensaje_datos::class.java)
        startActivity(intent)

        Toast.makeText(this,"Se han registrado los datos",Toast.LENGTH_SHORT).show()

    }

}
