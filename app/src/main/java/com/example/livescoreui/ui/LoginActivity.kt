package com.example.livescoreui.ui

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.livescoreui.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set A viewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBackLogin.setOnClickListener{
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        mAuth = Firebase.auth
        binding.btnLoginCreate.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()
            if (checkLoginField()){
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    //if successful account is created , also signed In
                    if (it.isSuccessful){
                        Toast.makeText(this@LoginActivity," Successfully Login.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LoginActivity, DashBoardActivity::class.java)
                        startActivity(intent)
                        finish()
                        Log.d(TAG, "signInWithCredential:successful")

                    } else {
                        //if Unsuccessful account
                        Log.d(TAG, "signInWithCredential:Unsuccessful")
                        Log.e("Error Account.",it.exception.toString())
                    }
                }
            }
        }

    }

    //Set checked for All Input data for validation
    private fun checkLoginField(): Boolean {
        val email = binding.edtEmailLogin.text.toString()
        if (binding.edtEmailLogin.text.toString() == "") {
            binding.edtEmailLogin.error = "this is required field."
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmailLogin.error = "Check Email Format."
            return false
        }

        if (binding.edtPasswordLogin.text.toString() == "") {
            binding.edtPasswordLogin.error = "this is required field."
            return false
        }
        if (binding.edtPasswordLogin.length() <= 6) {
            binding.edtPasswordLogin.error = "Password Should at least 6 Characters length."
            return false
        }

        return true
    }
}