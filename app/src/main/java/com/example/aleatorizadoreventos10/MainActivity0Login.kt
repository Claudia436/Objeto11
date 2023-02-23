package com.example.aleatorizadoreventos10

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.properties.Delegates

class MainActivity0Login : AppCompatActivity() {

    private val TAG ="LoginActivity"
    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()
    private lateinit var correo: EditText
    private lateinit var contra: EditText
    private lateinit var error: String


    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity0_login)
        initialiese()

        findViewById<TextView>(R.id.registro).setOnClickListener(){
            val intent = Intent(this, MainActivityRegristro::class.java)
            startActivity(intent)
        }
    }
    private fun initialiese(){
        correo = findViewById(R.id.correo)
        contra = findViewById(R.id.contra)
        mAuth = FirebaseAuth.getInstance()
    }
    private fun loginUser(){
        email = correo.text.toString()
        password = contra.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){

            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = mAuth.currentUser
                        goHome()
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        error = task.exception.toString().substringAfter(":")
                        Toast.makeText(baseContext, error,
                            Toast.LENGTH_LONG).show()
                    }
                }
        }else{
            Toast.makeText(this,"Pon todo lo que piden",Toast.LENGTH_SHORT).show()
        }
    }
    private fun goHome(){
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    fun login(view: View){
        loginUser()
    }
    fun register(view: View){
        startActivity(Intent(this, MainActivityRegristro::class.java))
    }
}