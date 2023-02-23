package com.example.aleatorizadoreventos10

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.properties.Delegates

class MainActivityRegristro : AppCompatActivity() {
    private lateinit var correo: EditText
    private lateinit var contra: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var error: String

    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_regristro)
        initialise()
    }
    private fun initialise() {
        correo = findViewById(R.id.correo)
        contra = findViewById(R.id.contra)

        auth = FirebaseAuth.getInstance()
    }
    private fun createNewAccount() {

        email = correo.text.toString()
        password = contra.text.toString()

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")

                        val user:FirebaseUser = auth.currentUser!!
                        verifyEmail(user);

                        Toast.makeText(baseContext, "User registrado correctamente",
                            Toast.LENGTH_LONG).show()
                        updateUserInfoAndGoHome()
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        error = task.exception.toString().substringAfter(":")
                        Toast.makeText(baseContext, error,
                            Toast.LENGTH_LONG).show()
                    }
                }

        } else {
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
    fun register(view: View){
        createNewAccount()
    }
    private fun updateUserInfoAndGoHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    private fun verifyEmail(user: FirebaseUser) {
        user.sendEmailVerification()
            .addOnCompleteListener(this) {
                    task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,
                        "Email " + user.getEmail(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,
                        "Error al verificar el correo ",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}