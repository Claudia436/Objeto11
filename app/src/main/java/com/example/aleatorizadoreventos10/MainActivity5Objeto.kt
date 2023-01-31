package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5Objeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity5_objeto)

        findViewById<Button>(R.id.recoger).setOnClickListener(){
            startActivity(Intent(this,MainActivity9 :: class.java))
        }
        findViewById<Button>(R.id.continuarO).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
    }
}