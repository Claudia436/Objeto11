package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var clase = intent.getStringExtra("selecC")
        var raza = ""

        findViewById<Button>(R.id.button1).setOnClickListener{
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.humana)
            raza = "humana"
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.goblin)
            raza = "goblin"
        }
        findViewById<Button>(R.id.button3).setOnClickListener{
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.elfa)
            raza = "elfa"
        }
        findViewById<Button>(R.id.button4).setOnClickListener{
            findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.enana)
            raza = "enana"
        }

        findViewById<Button>(R.id.button0).setOnClickListener{
            var intent = Intent(this,MainActivity3 :: class.java)
            intent.putExtra("selecC",clase)
            intent.putExtra("selecR",raza)
            startActivity(intent)
        }
    }
}