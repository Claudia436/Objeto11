package com.example.aleatorizadoreventos10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlin.random.Random

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        findViewById<ImageButton>(R.id.dado).setOnClickListener {
            var tiradaDado = Random.nextInt(1, 5)

            when(tiradaDado) {
                1 -> {
                    var intent1 = Intent(this,MainActivity5Objeto :: class.java)
                    startActivity(intent1)
                }
                2 -> {
                    var intent2 = Intent(this,MainActivity6Ciudad :: class.java)
                    startActivity(intent2)
                }
                3 -> {
                    var intent3 = Intent(this,MainActivity7Mercader :: class.java)
                    startActivity(intent3)
                }
                4 -> {
                    var intent4 = Intent(this,MainActivity8Enemigo :: class.java)
                    startActivity(intent4)
                }
            }
        }
    }
}