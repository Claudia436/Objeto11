package com.example.aleatorizadoreventos10

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity9Comprar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity9_comprar)

        findViewById<Button>(R.id.aceptar).setOnClickListener(){
            //falta añadir a la mochila el num de los objetos comprados y restar el dinero...
            startActivity(Intent(this,MainActivity7Mercader :: class.java))
        }
    }
}