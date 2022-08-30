package com.example.namo.Bottom.Diary

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.Memo.GetMemoRes
import com.example.namo.Data.Schedule.Memo.MonthMemoDto
import com.example.namo.databinding.ItemDiaryListBinding
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class DiaryListRVAdapter( private var items: ArrayList<MonthMemoDto>)
    :  RecyclerView.Adapter<DiaryListRVAdapter.ViewHolder>() {

    private lateinit var diaryItemClickListeners: DiaryItemClickListener  //스케줄 메모
    private lateinit var groupItemClickListeners: GroupItemClickListener  //그룹 메모

    interface DiaryItemClickListener {

        fun onDiaryClick(monthMemoDto: MonthMemoDto)

    }
    fun setItemsClickListener(diaryItemClickListener:DiaryItemClickListener) {
        diaryItemClickListeners=diaryItemClickListener
    }

    interface GroupItemClickListener {
        fun onGroupClick(monthMemoDto: MonthMemoDto)
    }
    fun setItemssClickListener(groupItemClickListener: GroupItemClickListener) {
        groupItemClickListeners=groupItemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemDiaryListBinding =
            ItemDiaryListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(items[position])

//        if(items[position].group==0) {
//            holder.binding.diaryAllEditTv.setOnClickListener {
//                diaryItemClickListeners.onDiaryClick(items[position],items[position].memoIdx)
//            }
//        }
//        else{
//            holder.binding.diaryAllEditIv.visibility= GONE
//            holder.binding.diaryAllEditTv.visibility=GONE
//        }

//        holder.binding.diaryAllEditTv.setOnClickListener {
//            groupItemClickListeners.onGroupClick(items[position])
//        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ItemDiaryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var view = binding.root.context

        @RequiresApi(Build.VERSION_CODES.O)
        @SuppressLint("ResourceType")
        fun bind(data: MonthMemoDto) {

            val string =data.date
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val date: LocalDate = LocalDate.parse(string, formatter)

            if(data.group==0) { //스케줄 메모

                data.memoIdx
                binding.diaryDayTv.text = date.toString()
                binding.itemDiaryTitleTv.text=data.name
                binding.itemDiartContentTv.text=data.content
                binding.itemDiaryCategoryColorIv.backgroundTintList = ColorStateList.valueOf(Color.parseColor(data.color))
                binding.diaryAllRv.adapter=DiaryGalleryRVAdapter(data.urls.filterNotNull(),view)
                binding.diaryAllRv.layoutManager =
                    LinearLayoutManager(view, LinearLayoutManager.HORIZONTAL, false)
            }

            else{  //그룹 메모

                data.memoIdx
                binding.diaryDayTv.text = date.toString()
                binding.itemDiaryTitleTv.text=data.name
                binding.itemDiartContentTv.text="작성된 글이 없습니다."
                binding.itemDiaryCategoryColorIv.backgroundTintList = ColorStateList.valueOf(Color.parseColor(data.color))
                binding.diaryAllRv.adapter=DiaryGalleryRVAdapter(data.urls.filterNotNull(),view)
                binding.diaryAllRv.layoutManager =
                    LinearLayoutManager(view, LinearLayoutManager.HORIZONTAL, false)

                val jsn= Gson().toJson(data.urls)
                val sharedPreference = view.getSharedPreferences("getMemoRes",
                    AppCompatActivity.MODE_PRIVATE
                )
                val editor = sharedPreference.edit()
                editor.putString("urls",jsn) //이미지 idx
                editor.apply()

            }

        }
    }


}

