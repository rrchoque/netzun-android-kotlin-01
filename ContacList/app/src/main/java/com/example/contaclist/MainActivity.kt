package com.example.contaclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = listOf<Contact>(
            Contact("Rafael", "73452343"),
            Contact("Alejandro", "69439032"),
            Contact("Ivan", "34634634")
        )

        recyclerView = findViewById(R.id.contact_recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactAdapter(contacts)
    }
}