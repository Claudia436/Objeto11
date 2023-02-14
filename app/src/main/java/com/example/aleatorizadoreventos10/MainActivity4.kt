package com.example.aleatorizadoreventos10

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlin.random.Random

class MainActivity4 : AppCompatActivity() {

    lateinit var mp: MediaPlayer
    lateinit var runnable: Runnable
    var handler: Handler = Handler()
    var pause: Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        findViewById<ImageButton>(R.id.dado).setOnClickListener {
            var tiradaDado = (1..4).random()

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

        findViewById<Button>(R.id.play).setOnClickListener{
            if(pause){
                mp.seekTo(mp.currentPosition)
                mp.start()
                Toast.makeText(this,"MediaPlayer",Toast.LENGTH_SHORT).show()
            }else{
                mp = MediaPlayer.create(applicationContext,R.raw.epicmusic)
                mp.start()
                Toast.makeText(this,"MediaPlayer",Toast.LENGTH_SHORT).show()
            }
            initializeSeekBar()
        }
    }
    //MIRAR PQ ESA MIERDA NO VA
    private fun initializeSeekBar() {
        barra.max = mp.seconds

        runnable = Runnable {
            barra.progress = mp.currentSeconds
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }
}

val MediaPlayer.seconds:Int
    get() {
        return this.duration / 1000
    }

val MediaPlayer.currentSeconds:Int
    get() {
        return this.currentPosition/1000
    }