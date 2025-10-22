package com.usj.onboardingapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.usj.onboardingapp.fragments.LibraryFragment
import com.usj.onboardingapp.fragments.MyListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val libraryButton: Button = findViewById(R.id.libraryListButton)
        val myListButton: Button = findViewById(R.id.myListButton)

        val fragmentManager = supportFragmentManager

        libraryButton.setOnClickListener {
            displayFragment(LibraryFragment.newInstance(), fragmentManager)
        }

        myListButton.setOnClickListener {
            displayFragment(MyListFragment(), fragmentManager)
        }
        displayFragment(LibraryFragment.newInstance(), fragmentManager)
        val toolBar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
    }

    fun displayFragment(fragment: Fragment, fragmentManager: FragmentManager){
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }


}