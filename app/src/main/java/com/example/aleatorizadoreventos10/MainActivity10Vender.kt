package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity10Vender : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity10_vender)

        findViewById<Button>(R.id.aceptar).setOnClickListener(){
            //falta quitar de la mochila el num de los objetos vendidos (no es necesario restar el dinero)...
            //si no hay objetos se muestra un mensaje
            startActivity(Intent(this,MainActivity7Mercader :: class.java))
        }
    }
}