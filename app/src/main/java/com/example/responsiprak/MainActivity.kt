package com.example.responsiprak

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.invoke.ConstantCallSite
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val user = username.text.toString()
//        val mail = email.text.toString()
//        val pwd = pass.text.toString()
        button.setOnClickListener{
            if (username.text.toString().isEmpty()){
                username.error = "Username harus diisi"
                return@setOnClickListener
            }
            if (email.text.toString().isEmpty()){
                email.error = "Email harus diisi"
                return@setOnClickListener
            }
            if (pass.text.toString().isEmpty()){
                pass.error = "Password harus diisi"
                return@setOnClickListener
            }
            if (username.text.toString().length < 8){
                username.error = "Username minimal menggunakan 8 karakter"
                return@setOnClickListener
            }
            fun String.isEmailValid(): Boolean{
                val emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
//                    "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$"
                val pattern = Pattern.compile(emailRegex,  Pattern.CASE_INSENSITIVE)
                val matcher = pattern.matcher(this)
                return matcher.matches()
            }
            if (!email.text.toString().isEmailValid()){
                email.error = "Email ini tidak Valid"
                return@setOnClickListener
            }
            fun String.isPasswordValid(): Boolean{
                val passRegex = "^.*(?=.*[0-9]).*$"
                val pattern = Pattern.compile(passRegex, Pattern.CASE_INSENSITIVE)
                val matcher = pattern.matcher(this)
                return matcher.matches()
            }
            if (!pass.text.toString().isPasswordValid()){
                pass.error = "Password setidaknya mengandung satu angka"
                return@setOnClickListener
            }

//            Toast.makeText(this, "Anda Berhasil Login", Toast.LENGTH_SHORT).show()

            val user = username.text.toString()
            val psd = pass.text.toString()
//            if (user.isEmpty()|| psd.isEmpty()){
//                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
            if (user == "admin123" && psd == "admin123"){
                val intent = Intent(this,welcome::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Username atau Password Salah",Toast.LENGTH_SHORT).show()
            }
        }
    }
}