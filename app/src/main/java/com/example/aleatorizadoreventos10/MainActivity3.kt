package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var clase = intent.getStringExtra("selecC")
        var raza = intent.getStringExtra("selecR")

        if (clase == "guerrera")
            findViewById<ImageView>(R.id.imageC).setImageResource(R.drawable.guerrera)
        else if (clase == "ladrona")
            findViewById<ImageView>(R.id.imageC).setImageResource(R.drawable.ladrona)
        else if (clase == "maga")
            findViewById<ImageView>(R.id.imageC).setImageResource(R.drawable.maga)
        else if (clase == "berserker")
            findViewById<ImageView>(R.id.imageC).setImageResource(R.drawable.berserker)

        if (raza == "humana")
            findViewById<ImageView>(R.id.imageR).setImageResource(R.drawable.humana)
        else if (raza == "goblin")
            findViewById<ImageView>(R.id.imageR).setImageResource(R.drawable.goblin)
        else if (raza == "elfa")
            findViewById<ImageView>(R.id.imageR).setImageResource(R.drawable.elfa)
        else if(raza == "enana")
            findViewById<ImageView>(R.id.imageR).setImageResource(R.drawable.enana)

        findViewById<TextView>(R.id.numF).apply {
            text = (10..15).random().toString()
        }
        findViewById<TextView>(R.id.numD).apply {
            text = (1..5).random().toString()
        }
        findViewById<TextView>(R.id.tamM).apply {
            text = 100.toString()
        }
        findViewById<TextView>(R.id.numV).apply {
            text = 200.toString()
        }
        findViewById<TextView>(R.id.numM).apply {
            text = 0.toString()
        }

        findViewById<Button>(R.id.volver).setOnClickListener(){
            startActivity(Intent(this,MainActivity :: class.java))
        }
        findViewById<Button>(R.id.comenzar).setOnClickListener(){
            startActivity(Intent(this,MainActivity4 :: class.java))
        }
    }
}