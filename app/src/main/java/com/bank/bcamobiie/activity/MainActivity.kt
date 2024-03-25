package com.bank.bcamobiie.activity

import android.os.Bundle
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bank.bcamobiie.R
import com.bank.bcamobiie.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val indexes = 2
            navView.menu.getItem(indexes).isEnabled = false

        navView.children.forEach { child ->
            val anim = ScaleAnimation(1f, 1f, 1f, 1f)
            anim.duration = 0
            child.startAnimation(anim)
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
        supportActionBar?.hide()
    }
}