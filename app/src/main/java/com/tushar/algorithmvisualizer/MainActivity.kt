package com.tushar.algorithmvisualizer

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout

import androidx.appcompat.widget.Toolbar

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable


import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.collection.LLRBNode
import com.tushar.algorithmvisualizer.Activity.Login_Activity

import com.tushar.algorithmvisualizer.Fragments.DashboarFragment
import com.tushar.algorithmvisualizer.Fragments.faqFragment
import com.tushar.algorithmvisualizer.Fragments.mcqFragment
import com.tushar.algorithmvisualizer.Fragments.profileFragment



class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    lateinit var actionBarDrawerToggle:ActionBarDrawerToggle
        lateinit var toolbar: Toolbar
        lateinit var navigationview:NavigationView
        lateinit var drawerLayout:DrawerLayout
        lateinit var frame:FrameLayout




    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        toolbar=findViewById(R.id.toolbar)
        navigationview=findViewById(R.id.navigationView)
        drawerLayout=findViewById(R.id.drawerLayout)
        frame=findViewById(R.id.frame)
        sharedPreferences =
            getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)
        actionBarDrawerToggle= ActionBarDrawerToggle(this@MainActivity,drawerLayout,
            R.string.open_drawer,R.string.close_drawer
        )
        actionBarDrawerToggle.drawerArrowDrawable = CustomHamburgerDrawable(this)


        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        setUpToolbar()
        openDashboard()


        navigationview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itmDashboard ->{
                    openDashboard()

                    drawerLayout.closeDrawer(GravityCompat.START)
                    navigationview.setCheckedItem(R.id.itmDashboard)

                }
                R.id.itmMcq->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,mcqFragment()).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    supportActionBar?.title="MCQ"
                    navigationview.setCheckedItem(R.id.itmMcq)
                }
                R.id.itmFAQ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,faqFragment()).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    supportActionBar?.title="FAQ"
                    navigationview.setCheckedItem(R.id.itmFAQ)
                }


                R.id.itmProfile->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,profileFragment()).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    supportActionBar?.title="Profile"
                    navigationview.setCheckedItem(R.id.itmProfile)
                }
                R.id.itmlogout->{
                    val intent= Intent(this@MainActivity, Login_Activity::class.java)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    startActivity(intent)
                    sharedPreferences.edit().putBoolean("hasLoggedIn",false).commit()
                    onDestroy()
                }

            }
            return@setNavigationItemSelectedListener true
        }



    }
    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Dashboard"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    fun openDashboard(){
        supportFragmentManager.beginTransaction().replace(R.id.frame,DashboarFragment()).commit()
        supportActionBar?.title="Dashboard"

    }


    class CustomHamburgerDrawable(context: Context) : DrawerArrowDrawable(context) {
        init {
            color = context.resources.getColor(R.color.hamburger_color)
            progress = 1.0f // Set the progress to fully display the hamburger icon
        }
    }

}

