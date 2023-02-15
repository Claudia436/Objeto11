package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity6Ciudad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity6_ciudad)

        findViewById<Button>(R.id.entrar).setOnClickListener(){
            startActivity(Intent(this,MainActivityBlanco :: class.java))
        }
        findViewById<Button>(R.id.continuarC).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
    }
}