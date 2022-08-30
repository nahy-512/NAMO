package com.example.namo.Floating.Schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Map.PlaceList
import com.example.namo.R

class PlaceSearchRVAdapter(val itemList:ArrayList<PlaceList>):RecyclerView.Adapter<PlaceSearchRVAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place_search_rv,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.road.text = itemList[position].road
        holder.address.text = itemList[position].address

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.item_place_search_name_tv)
        val road: TextView = itemView.findViewById(R.id.item_place_search_road_tv)
        val address: TextView = itemView.findViewById(R.id.item_place_search_address_tv)
    }

    interface OnItemClickListener{
        fun onClick(v:View, position:Int)
    }

    fun setItemClickListener(onItemClickListener : OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener : OnItemClickListener

}