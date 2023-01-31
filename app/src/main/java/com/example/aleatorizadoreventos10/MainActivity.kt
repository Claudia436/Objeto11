package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clase = ""

        findViewById<Button>(R.id.button1).setOnClickListener(){
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.guerrera)
            clase = "guerrera"
        }
        findViewById<Button>(R.id.button2).setOnClickListener(){
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.ladrona)
            clase = "ladrona"
        }
        findViewById<Button>(R.id.button3).setOnClickListener(){
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.maga)
            clase = "maga"
        }
        findViewById<Button>(R.id.button4).setOnClickListener(){
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.berserker)
            clase = "berserker"
        }

        findViewById<Button>(R.id.button0).setOnClickListener(){
            var intent = Intent(this,MainActivity2 :: class.java)
            intent.putExtra("selecC",clase)
            startActivity(intent)
        }
    }
}