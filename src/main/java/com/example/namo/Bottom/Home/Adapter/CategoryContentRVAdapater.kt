package com.example.namo.Bottom.Home.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Category.InquiryCategoryInfo
import com.example.namo.databinding.ItemCategoryContentBinding

/* 새 일정에서 카테고리 선택하면 나오는 카테고리 리스트 */
class CategoryContentRVAdapater(val context: Context, val result : ArrayList<InquiryCategoryInfo>):RecyclerView.Adapter<CategoryContentRVAdapater.ViewHolder>() {


    //클릭 인터페이스 정의, 사용하고자 하는 함수 만들기
    interface MyItemClickListener{
        fun onItemClick(categoryContent: InquiryCategoryInfo, position: Int)

    }

    //외부에서 전달받는 함수랑 전달받은 리스너 객체를 어댑터에서 사용할 수 있도록 따로 저장할 변수 선언
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemCategoryContentBinding = ItemCategoryContentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (result[position].color == "" || result[position].color == null) {
        } else {
            holder.bind(result[position])
        }

        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick(result[position], position) }

        } //아이템 클릭 함수 호출

    override fun getItemCount(): Int = result.size

    inner class ViewHolder(val binding: ItemCategoryContentBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(categoryContent: InquiryCategoryInfo){
            binding.itemScheduleCategoryColorCv.setCardBackgroundColor(Color.parseColor(categoryContent.color!!))
            binding.itemScheduleCategoryNameTv.text = categoryContent.name
        }
    }
}