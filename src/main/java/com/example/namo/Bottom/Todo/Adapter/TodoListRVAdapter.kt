package com.example.namo.Bottom.Todo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Todo.Todo
import com.example.namo.databinding.ItemTodoListBinding

class TodoListRVAdapter(private val todoCList: ArrayList<Todo>) :  RecyclerView.Adapter<TodoListRVAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemTodoListBinding = ItemTodoListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todoCList[position])
    }

    override fun getItemCount(): Int = todoCList.size

    inner class ViewHolder(val binding: ItemTodoListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
//            binding.itemTodoListCategoryColorIv.setBackgroundResource(todo.categoryColor!!)
            binding.itemTodoListTopTv.text = todo.deadline
            binding.itemTodoListContentTv.text = todo.name
//            binding.itemTodoListDayTv.text = todo.tododDay
        }
    }
}