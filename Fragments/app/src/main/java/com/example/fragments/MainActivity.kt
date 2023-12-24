package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnFragment1: Button
    lateinit var btnFragment2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("-MainActivityLog", "onCreate")

        btnFragment1 = findViewById(R.id.buttonF1)
        btnFragment2 = findViewById(R.id.buttonF2)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val mainFragment = MainFragment()
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        fragmentTransaction.add(R.id.containerFragment, mainFragment)
        fragmentTransaction.commit()

        btnFragment1.setOnClickListener {
            Toast.makeText(this, "Fragment 1 presionado", Toast.LENGTH_SHORT).show()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.containerFragment, firstFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btnFragment2.setOnClickListener {
            Toast.makeText(this, "Fragment 2 presionado", Toast.LENGTH_SHORT).show()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.containerFragment, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("-MainActivityLog", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("-MainActivityLog", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("-MainActivityLog", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("-MainActivityLog", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("-MainActivityLog", "onDestroy")
    }
}