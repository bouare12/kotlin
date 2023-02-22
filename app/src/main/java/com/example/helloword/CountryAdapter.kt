package com.example.helloword

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter (val countries: Array<String>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview) {
        val icon = itemview.findViewById(R.id.icon) as ImageView
        val name = itemview.findViewById(R.id.name) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val  viewItem = inflater.inflate(R.layout.country_item, parent, false)
        return  ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.icon.setImageResource(R.mipmap.ic_launcher_round)
        holder.name.text = country
    }
}