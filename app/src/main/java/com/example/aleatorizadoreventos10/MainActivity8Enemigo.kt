package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity8Enemigo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity8_enemigo)

        findViewById<Button>(R.id.luchar).setOnClickListener(){
            startActivity(Intent(this,MainActivityBlanco :: class.java))
        }
        findViewById<Button>(R.id.huir).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
    }
}