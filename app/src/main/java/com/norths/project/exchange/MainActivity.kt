package com.norths.project.exchange

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.norths.project.exchange.databinding.ActivityMainBinding
import com.norths.project.exchange.databinding.ActivityBottomViewBinding
import com.norths.project.exchange.ui.DealsFragment
import com.norths.project.exchange.ui.FavoritesFragment
import com.norths.project.exchange.ui.HomeFragment
import com.norths.project.exchange.ui.LoginFragment
import com.norths.project.exchange.ui.ExchangeFragment
import com.norths.project.exchange.ui.ItemFragment
import com.norths.project.exchange.ui.MyExchangeFragment
import com.norths.project.exchange.ui.ProfileFragment
import com.norths.project.exchange.ui.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomViewBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup SharedPreferences
        sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

        // แสดงหน้าเริ่มต้นครั้งแรกเท่านั้น (เช่น Home)
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // ตั้ง listener ให้ BottomNavigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.navigation_add -> {
                    replaceFragment(ExchangeFragment())
                    true
                }
                R.id.navigation_notification -> {
                    replaceFragment(DealsFragment())
                    true
                }
                R.id.navigation_Account -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

