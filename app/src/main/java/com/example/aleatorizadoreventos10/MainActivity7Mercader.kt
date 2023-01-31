package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity7Mercader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity7_mercader)

        findViewById<Button>(R.id.comerciar).setOnClickListener(){
            startActivity(Intent(this,MainActivity9 :: class.java))
        }
        findViewById<Button>(R.id.continuarM).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
    }
}