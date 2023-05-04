package com.emilabdurahmanli.recyclerviewtask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emilabdurahmanli.recyclerviewtask.R
import com.emilabdurahmanli.recyclerviewtask.model.Person

class RecyclerViewHorizontalAdapter(list : MutableList<Person>) : RecyclerView.Adapter<RecyclerViewHorizontalAdapter.ViewHolder>() {

    var list : MutableList<Person>
    init {
        this.list=list
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val nameText = itemView.findViewById<TextView>(R.id.nameText)
        val surnameText = itemView.findViewById<TextView>(R.id.surnameText)
        val ageText = itemView.findViewById<TextView>(R.id.ageText)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.recycler_view_horizontal_row, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val age = list.get(position).age
        holder.ageText.setText(age.toString())
        holder.nameText.setText(list.get(position).name)
        holder.surnameText.setText(list.get(position).surname)


    }

    fun updateList(){
        list.clear()


        
    }

}