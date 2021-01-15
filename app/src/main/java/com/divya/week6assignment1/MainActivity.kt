package com.divya.week6assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.divya.week6assignment1.fragments.AboutFragment
import com.divya.week6assignment1.fragments.AddFragment
import com.divya.week6assignment1.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigationView)
         val first = HomeFragment()
        val second = AddFragment()
        val third = AboutFragment()
        setCurrentFragment(first)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_home -> setCurrentFragment(first)
                R.id.navigation_AddStudent-> setCurrentFragment(second)
                R.id.navigation_AboutUs -> setCurrentFragment(third)
            }
            true
        }

    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linearContainer,fragment)
            commit()
        }
}