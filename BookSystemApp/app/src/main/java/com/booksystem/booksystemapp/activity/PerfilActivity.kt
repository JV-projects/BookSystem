package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

import com.booksystem.booksystemapp.databinding.PerfilLayoutBinding

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: PerfilLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = PerfilLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditar.setOnClickListener{
            val intent = Intent(this, EditarPerfilActivity::class.java)
            startActivity(intent)
        }


    }

}