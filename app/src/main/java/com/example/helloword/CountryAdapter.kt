package com.example.helloword

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter (val countries: Array<String>, val itemClickListner : View.OnClickListener)
    : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview) {
        val cardView = itemview.findViewById(R.id.card_view) as CardView
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
        holder.cardView.tag = position
        holder.cardView.setOnClickListener(itemClickListner)
    }
}