package com.example.namo.Bottom.Todo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Todo.Todo
import com.example.namo.R
import com.example.namo.databinding.ItemTodoCategoryBinding

class TodoCategoryRVAdapter(private val todocategoryList: ArrayList<Todo>) :  RecyclerView.Adapter<TodoCategoryRVAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemTodoCategoryBinding = ItemTodoCategoryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todocategoryList[position])
    }

    override fun getItemCount(): Int = todocategoryList.size

    inner class ViewHolder(val binding: ItemTodoCategoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.itemTodoCategoryBackground.setBackgroundResource(R.drawable.ic_todo_categorybox_no_select)
            binding.itemTodoCategoryNameTv.text = todo.name
            binding.itemTodoCategoryItemsizeTv.text = "4개 항목"
        }
    }
}