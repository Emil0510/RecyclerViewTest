package com.emilabdurahmanli.recyclerviewtask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emilabdurahmanli.recyclerviewtask.R
import com.emilabdurahmanli.recyclerviewtask.model.Country

class RecyclerViewVerticalAdapter(list : MutableList<Country>) : RecyclerView.Adapter<RecyclerViewVerticalAdapter.ViewHolder>() {


    var list : MutableList<Country>

    init {
        this.list=list
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val countryName = itemView.findViewById<TextView>(R.id.countryNameText)
        val stateName = itemView.findViewById<TextView>(R.id.stateNameText)
        val flagImage = itemView.findViewById<ImageView>(R.id.flagImageView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_vertical_row,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.countryName.setText(list.get(position).countryName)
        holder.stateName.setText(list.get(position).countryCapital)
        holder.flagImage.setImageResource(list.get(position).flagResource)

    }




}