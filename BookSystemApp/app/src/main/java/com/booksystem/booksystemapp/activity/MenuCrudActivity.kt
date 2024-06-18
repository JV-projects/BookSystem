package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.booksystem.booksystemapp.databinding.MenuCrudLayoutBinding


class MenuCrudActivity : AppCompatActivity(){
    private lateinit var binding: MenuCrudLayoutBinding
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = MenuCrudLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBooksystem.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnListaTarefas.setOnClickListener{
            val intent = Intent(this, TarefaActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAgenda.setOnClickListener{
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
        }

        binding.btnCrud.setOnClickListener{
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
        }

    }


}