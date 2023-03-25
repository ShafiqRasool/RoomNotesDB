package com.example.roomnotesdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost=supportFragmentManager.findFragmentById(R.id.nav_host) as? NavHostFragment
        val navController=navHost?.navController
        val bottomNavigation:BottomNavigationView=findViewById(R.id.bottom_navigation)

        if (navController != null) {
            bottomNavigation.setupWithNavController(navController)
        }

    }
}