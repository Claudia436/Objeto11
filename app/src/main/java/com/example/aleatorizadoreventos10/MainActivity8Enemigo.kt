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
            var aleatorio = (1..2).random()

            when (aleatorio) {
                1 -> {
                    var intent1 = Intent(this, MainActivity12Complice::class.java)
                    startActivity(intent1)
                }
                2 -> {
                    var intent2 = Intent(this, MainActivity11Jefe::class.java)
                    startActivity(intent2)
                }
            }

        }
        findViewById<Button>(R.id.huir).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
    }
}