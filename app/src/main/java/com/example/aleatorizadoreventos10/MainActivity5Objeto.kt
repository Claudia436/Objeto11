package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity5Objeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity5_objeto)

        var pesomochila = 100

        findViewById<Button>(R.id.recoger).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
            val articulo = Articulo("objeto",5,10,20)
            var mochila = Mochila(pesomochila)

            mochila.addArticulo(articulo, applicationContext)

        }
        findViewById<Button>(R.id.continuarO).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
    }
}