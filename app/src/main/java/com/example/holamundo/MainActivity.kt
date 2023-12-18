package com.example.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView1:TextView
    lateinit var textView2:TextView
    lateinit var textView3:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById<TextView>(R.id.textView1)
        textView2 = findViewById<TextView>(R.id.textView2)
        textView3 = findViewById<TextView>(R.id.textView3)

        textView1.text = "Reynaldo"
        textView2.text = "Choque"
        textView3.text = "2023"

        textView1.textSize = 26f
    }
}