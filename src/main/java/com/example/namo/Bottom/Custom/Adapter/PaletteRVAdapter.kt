package com.example.namo.Bottom.Custom.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Home.ScheduleFragment
import com.example.namo.Data.Custom.Palette
import com.example.namo.R
import com.example.namo.databinding.ItemCustomPaletteBinding
import java.util.*
import kotlin.collections.ArrayList

class PaletteRVAdapter :  RecyclerView.Adapter<PaletteRVAdapter.ViewHolder>(){
    lateinit var items: ArrayList<Palette>

    fun build(i: ArrayList<Palette>): PaletteRVAdapter {
        items = i
        return this
    }

    class ViewHolder(val binding: ItemCustomPaletteBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Palette) {
            with(binding)
            {
                itemPaletteNameTv.text = item.name
                itemPaletteColorRv.apply {
                    adapter = PaletteColorRVAdapter().build(item.colors) //컬러 어댑터 연결
                    layoutManager = GridLayoutManager(context, 5, GridLayoutManager.VERTICAL, false)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemCustomPaletteBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.context
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}

//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        val binding: ItemCustomPaletteBinding = ItemCustomPaletteBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
//
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(paletteList[position])
//
//        val paletteColorManager = GridLayoutManager(holder.layout.context, 5)
//        val paletteColorAdapter = PaletteColorRVAdapter(colorList) //contextMain, tempMonth, dayList, monthEvent
//
//        holder.layout.item_home_calendar_month_day_rv.apply {
//            layoutManager = dayListManager
//            adapter = dayListAdapter
//        }
//
//        paletteColorAdapter.setMyItemClickListener(object :
//            HomeCalendarDayRVAdapter.MyItemClickListener {
//            override fun onItemClick(date: Date) {
//                (contextMain).supportFragmentManager.beginTransaction()
//                    .replace(R.id.main_frm, ScheduleFragment(date))
//                    .commitAllowingStateLoss()
//            }
//        })
//    }
//
//    override fun getItemCount(): Int = paletteList.size
//
//    inner class ViewHolder(val binding: ItemCustomPaletteBinding): RecyclerView.ViewHolder(binding.root) {
//        fun bind(palette: Palette) {
//            binding.itemPaletteNameTv.text = palette.name
////            binding.itemAlbumSingerTv.text = album.singer
////            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)
//        }
//    }