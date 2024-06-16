package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.booksystem.booksystemapp.databinding.EntrarLayoutBinding

class LoginActivity : AppCompatActivity(){

    private lateinit var binding : EntrarLayoutBinding
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = EntrarLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtCadastrese.setOnClickListener{
            val intent = Intent(this, CadastrarActivity::class.java)
            startActivity(intent)
        }
    }

}