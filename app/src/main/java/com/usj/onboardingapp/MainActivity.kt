package com.usj.onboardingapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLogAndToast("On Create")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        printLogAndToast("On Start")
    }

    override fun onResume() {
        super.onResume()
        printLogAndToast("On Resume")
    }

    override fun onPause() {
        super.onPause()
        printLogAndToast("On Pause")
    }

    override fun onStop() {
        super.onStop()
        printLogAndToast("On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLogAndToast("On Destroy")
    }

    fun printLogAndToast(event: String){
        Toast.makeText(this, "$event was called!", Toast.LENGTH_SHORT).show()
        Log.d("lifecycle","$event was called")
    }


}