package com.example.namo.Bottom.Todo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Todo.Todo
import com.example.namo.databinding.ItemTodoListBinding

class TodoDateRVAdapter(private val todoDList: ArrayList<Todo>) :  RecyclerView.Adapter<TodoDateRVAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemTodoListBinding = ItemTodoListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        binding.itemTodoListDayTv.visibility = View.GONE //아이템에서 디데이는 안 보이게

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todoDList[position])
    }

    override fun getItemCount(): Int = todoDList.size

    inner class ViewHolder(val binding: ItemTodoListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
//            binding.itemTodoListCategoryColorIv.setBackgroundResource(todo.categoryColor!!)
            binding.itemTodoListTopTv.text = "할 일"
            binding.itemTodoListContentTv.text = todo.name
        }
    }
}