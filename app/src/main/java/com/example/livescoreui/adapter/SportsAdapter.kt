package com.example.livescoreui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreui.R
import com.example.livescoreui.pojo.SportsDash

class SportsAdapter(private val sportsList: ArrayList<SportsDash>)
    :RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {
    private var selectedItemPosition: Int = 0

    class SportsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.img_item_dash)
        val title: TextView = itemView.findViewById(R.id.tv_item_dash)
        val card:CardView = itemView.findViewById(R.id.card_item_dash)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_dashboard,parent,false)
        return SportsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }
 
    @SuppressLint("ResourceAsColor", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: SportsViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val sports = sportsList[position]
        holder.image.setImageResource(sports.image)
        holder.title.text = sports.sportName

        holder.itemView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
        }
        if(selectedItemPosition == position)
            holder.card.setCardBackgroundColor(R.color.orange)
        else
            holder.card.setCardBackgroundColor(R.color.black_1)


    }

}