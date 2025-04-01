package com.norths.project.exchange

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import com.norths.project.exchange.databinding.ActivityMainBinding
import com.norths.project.exchange.ui.DealsFragment
import com.norths.project.exchange.ui.FavoritesFragment
import com.norths.project.exchange.ui.HomeFragment
import com.norths.project.exchange.ui.LoginFragment
import com.norths.project.exchange.ui.ExchangeFragment
import com.norths.project.exchange.ui.ItemFragment
import com.norths.project.exchange.ui.MyExchangeFragment
import com.norths.project.exchange.ui.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup SharedPreferences
        sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)

        // Initialize navigation
        drawerLayout = binding.drawerLayout

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.menu.findItem(R.id.nav_myitem).isVisible = false
        binding.navView.menu.findItem(R.id.nav_myexchange).isVisible = false
        binding.navView.menu.findItem(R.id.nav_profile).isVisible = false

        if (savedInstanceState == null) {
            if (LoginStuts()) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
                binding.navView.setCheckedItem(R.id.nav_profile)
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, LoginFragment())
                    .commit()
            }
        }

        // Handle NavigationView item clicks
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            if (LoginStuts()) {
                when (menuItem.itemId) {
                    R.id.nav_myaccount -> {
                        val myItem = binding.navView.menu.findItem(R.id.nav_myitem)
                        val myExchange = binding.navView.menu.findItem(R.id.nav_myexchange)
                        val profile = binding.navView.menu.findItem(R.id.nav_profile)

                        myItem.isVisible = !myItem.isVisible
                        myExchange.isVisible = !myExchange.isVisible
                        profile.isVisible = !profile.isVisible
                    }
                    R.id.nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, HomeFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_myitem -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, ItemFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_myexchange -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, MyExchangeFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_exchange -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, ExchangeFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_deals -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, DealsFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_profile -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, ProfileFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_favorites -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, FavoritesFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_logout -> {
                        logout()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, LoginFragment())
                            .commit()
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, LoginFragment())
                    .commit()
                Toast.makeText(this, "กรุณาเข้าสู่ระบบก่อน", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            true
        }


    }

    fun LoginStuts() : Boolean {
        val flag = sharedPreferences.getBoolean("isLoggedIn", false)
        binding.navView.menu.findItem(R.id.nav_logout).isVisible = flag
        return flag
    }

    fun logout(){
        sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
        LoginStuts()
        setupProfile()
    }

    fun setupProfile() {
        val headerView = binding.navView.getHeaderView(0)
        val usernameTextView = headerView.findViewById<TextView>(R.id.usernameHeader)
        val emailTextView = headerView.findViewById<TextView>(R.id.emailHeader)

        val username = sharedPreferences.getString("username", "Admin")
        val email = sharedPreferences.getString("email", "admin@example.com")

        usernameTextView.text = username
        emailTextView.text = email
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.navigation_home.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, HomeFragment())
//                .addToBackStack(null)
//                .commit()
//        }
//
//        binding.navigation_exchange.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, MyExchangeFragment())
//                .addToBackStack(null)
//                .commit()
//        }
//
//        binding.navigation_favorite.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, MyExchangeFragment())
//                .addToBackStack(null)
//                .commit()
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}

