package com.example.contaclist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactList: List<Contact>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var layoutInflater =LayoutInflater.from(parent.context)
        return ContactViewHolder(layoutInflater.inflate(R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contactList[position]
        holder.render(item)
    }

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        val phone = view.findViewById<TextView>(R.id.tv_phone)

        fun render(contact: Contact){
            name.text = contact.name
            phone.text = contact.phone
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, name.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}