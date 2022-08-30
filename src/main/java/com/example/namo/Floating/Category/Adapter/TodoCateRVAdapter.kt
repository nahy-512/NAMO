package com.example.namo.Floating.Category.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Category.TodoCategory
import com.example.namo.databinding.ItemFloatingCategoryBinding
import com.google.gson.Gson

class TodoCateRVAdapter (private val todoCate:ArrayList<TodoCategory>):RecyclerView.Adapter<TodoCateRVAdapter.ViewHolder>(){

    private var gson: Gson = Gson()

    interface MyItemClickListener{
        // click function
        fun onShowCategorytab(todoCategory: TodoCategory)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setsMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFloatingCategoryBinding= ItemFloatingCategoryBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todoCate[position])

        holder.binding.itemCategoryBackground.setOnClickListener {
            // 일정 누르면 카테고리 설정 나오게
            mItemClickListener.onShowCategorytab(todoCate[position])
        }
    }

    override fun getItemCount(): Int = todoCate.size

    inner class ViewHolder(val binding: ItemFloatingCategoryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(todoCategory: TodoCategory) {

            binding.itemCategoryNameTv.text = todoCategory.name

        }
    }

}