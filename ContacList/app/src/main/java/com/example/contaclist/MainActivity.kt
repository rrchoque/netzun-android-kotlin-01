package com.example.contaclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var dataModelArrayList: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = listOf<Contact>(
            Contact("Rafael", "73452343"),
            Contact("Alejandro", "69439032"),
            Contact("Ivan", "34634634")
        )

        dataModelArrayList = ArrayList()
        recyclerView = findViewById(R.id.contact_recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactAdapter(contacts)

        // consultas a internet
        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/users"
        val jsonArrayRequest = JsonArrayRequest(url,
            {
                response -> Log.i("Volley", "response: $response")
                for (i in 0 until response.length()){
                    val item = response.getJSONObject(i)
                    Log.i("Volley", "item: $item")
                    dataModelArrayList.add(Contact(item.get("name").toString(), item.get("phone").toString()))
                }
                recyclerView.adapter = ContactAdapter(dataModelArrayList)
                recyclerView.layoutManager = LinearLayoutManager(this)
            },
            {
                error -> error.printStackTrace()
            })

        queue.add(jsonArrayRequest)

    }
}