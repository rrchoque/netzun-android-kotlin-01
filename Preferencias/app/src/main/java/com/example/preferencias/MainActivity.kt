package com.example.preferencias

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etName: TextView
    lateinit var swAge: Switch
    lateinit var swBuy: Switch
    lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.et_name)
        swAge = findViewById(R.id.sw_age)
        swBuy = findViewById(R.id.sw_buy)
        btnSave = findViewById(R.id.btn_save)

        var prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        etName.text = prefs.getString("name", "")
        swAge.isChecked = prefs.getBoolean("age", false)
        swBuy.isChecked = prefs.getBoolean("buy", false)

        btnSave.setOnClickListener {
            var prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
            var editor = prefs.edit()
            editor.putString("name", etName.text.toString())
            editor.putBoolean("age", swAge.isChecked)
            editor.putBoolean("buy", swBuy.isChecked)
            editor.commit()

            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
        }
    }
}