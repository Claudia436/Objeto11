package com.example.aleatorizadoreventos10

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity9Comprar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity9_comprar)

        val pesomochila = 100
        var mochila = Mochila(pesomochila)

        val articulo = Articulo("pocion",5,125,10)

        findViewById<Button>(R.id.aceptar).setOnClickListener(){
            var cantidadInt = 0

            val editTextCantidad = findViewById<EditText>(R.id.cantidad)
            val cantidad = editTextCantidad.text.toString()
            try {
                cantidadInt = cantidad.toInt()
            } catch (e: NumberFormatException) {
                Log.e("MainActivity", "El String no es un número válido", e)
            }
            for (i in 0 until cantidadInt){
                mochila.comprarArticulo(articulo,applicationContext)
            }
            startActivity(Intent(this,MainActivity7Mercader :: class.java))

        }
    }
}