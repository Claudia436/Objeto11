package com.example.aleatorizadoreventos10

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity10Vender : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity10_vender)

        val pesomochila = 100
        var mochila = Mochila(pesomochila)

        val articulo = Articulo("pocion",5,125,10)

        mochila.addArticulo(articulo, applicationContext)
        mochila.addArticulo(articulo, applicationContext)

        findViewById<Button>(R.id.aceptarVenta).setOnClickListener(){
            var venderInt = 0

            val editTextVender = findViewById<EditText>(R.id.vender)
            val vender = editTextVender.text.toString()
            try {
                venderInt = vender.toInt()
            } catch (e: NumberFormatException) {
                Log.e("MainActivity", "El String no es un número válido", e)
            }
            for (i in 0 until venderInt){
                mochila.vender(articulo,applicationContext)
            }
            startActivity(Intent(this,MainActivity7Mercader :: class.java))
        }
    }
}