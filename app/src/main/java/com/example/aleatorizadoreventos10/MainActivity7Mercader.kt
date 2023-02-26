package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity7Mercader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity7_mercader)

        findViewById<Button>(R.id.comerciar).setOnClickListener(){
            findViewById<Button>(R.id.comprar).visibility = View.VISIBLE
            findViewById<Button>(R.id.vender).visibility = View.VISIBLE
            findViewById<Button>(R.id.cancelar).visibility = View.VISIBLE

            findViewById<Button>(R.id.comerciar).visibility = View.GONE
            findViewById<Button>(R.id.continuarM).visibility = View.GONE
        }
        findViewById<Button>(R.id.continuarM).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
        findViewById<Button>(R.id.comprar).setOnClickListener(){
            var intent = Intent(this,MainActivity9Comprar :: class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.vender).setOnClickListener(){
            startActivity(Intent(this,MainActivity10Vender :: class.java))
        }
        findViewById<Button>(R.id.cancelar).setOnClickListener(){
            startActivity(Intent(this,MainActivity7Mercader :: class.java))
        }
    }
}