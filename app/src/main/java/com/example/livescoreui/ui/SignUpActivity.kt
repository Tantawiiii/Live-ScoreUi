package com.example.livescoreui.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.livescoreui.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set view Binding
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBackSignup.setOnClickListener{
            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        auth = Firebase.auth
        binding.btnSignupCreate.setOnClickListener{
            val email = binding.edtEmailSignup.text.toString()
            val password = binding.edtPasswordSignup.text.toString()
            if (checkAllField()){
              auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                  //if successful account is created , also signed In
                  if (it.isSuccessful){
                      val intent = Intent(this@SignUpActivity, DashBoardActivity::class.java)
                      startActivity(intent)
                      finish()
                      Toast.makeText(this@SignUpActivity,"Account Created successfully.",Toast.LENGTH_SHORT).show()
                  } else {
                      //if Unsuccessful account
                      Log.e("Error Account.",it.exception.toString())
                  }
              }
            }
        }
    }

    //Set checked for All Input data for validation
    private fun checkAllField():Boolean{
        val email = binding.edtEmailSignup.text.toString()
        if (binding.edtEmailSignup.text.toString() == ""){
            binding.edtEmailSignup.error = "this is required field."
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.edtEmailSignup.error = "Check Email Format."
            return false
        }

        if (binding.edtPasswordSignup.text.toString() == "" ){
            binding.edtPasswordSignup.error = "this is required field."
            return false
        }
        if (binding.edtPasswordSignup.length() <= 6 ){
            binding.edtPasswordSignup.error = "Password Should at least 6 Characters length."
            return false
        }

        if (binding.edtPasswordConfirmSignup.text.toString() == ""){
            binding.edtPasswordConfirmSignup.error = "this is required field."
            return false
        }
        if (binding.edtPasswordSignup.text.toString() != binding.edtPasswordConfirmSignup.text.toString()){
            binding.edtPasswordConfirmSignup.error = "Password don't match."
            return false
        }
        return true
    }

}