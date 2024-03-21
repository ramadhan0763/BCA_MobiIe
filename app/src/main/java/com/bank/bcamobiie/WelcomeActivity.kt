package com.bank.bcamobiie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bank.bcamobiie.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private var _binding : ActivityWelcomeBinding? = null
    private val binding : ActivityWelcomeBinding get() =  _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

    }
}