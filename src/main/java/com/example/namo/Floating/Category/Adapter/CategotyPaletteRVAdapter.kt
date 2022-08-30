package com.example.namo.Floating.Category.Adapter


import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.databinding.ItemCategoryColorBinding


//카테고리 색 설정할 때 팔레트 색상 10칸
class CategotyPaletteRVAdapter(private var items: ArrayList<String>):  RecyclerView.Adapter<CategotyPaletteRVAdapter.ViewHolder>(){

//    lateinit var items: ArrayList<String>
    private var pos : Int = 0 //이전 위치

    fun build(i: ArrayList<String>): CategotyPaletteRVAdapter {
        items = i
        return this
    }

    private lateinit var mItemClickListener: MyPaletteItemClickListener //전달받은 리스너 객체를 저장할 변수
    fun setMyItemClickListener(itemClickListener: MyPaletteItemClickListener) {
        mItemClickListener = itemClickListener
    } //외부에서 전달받을 수 있는 함수

    interface MyPaletteItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCategoryColorBinding= ItemCategoryColorBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        //아이템 클릭시
        holder.itemView.setOnClickListener{

            mItemClickListener.onItemClick(position)
            Log.d("CategoryPaletteRVAdapter", "click-position = $position")

            holder.binding.itemCategoryColorSelectIv.visibility = View.VISIBLE

        }

//        holder.binding.itemCategoryColorSelectIv.visibility = View.GONE
    }


    class ViewHolder(val binding: ItemCategoryColorBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(colors : String) {
//            var click = 0 //클릭 초기화
            binding.itemCategoryColorCv.setCardBackgroundColor(Color.parseColor(colors))

//            binding.itemCategoryColorCv.setOnClickListener {
//                binding.itemCategoryColorSelectIv.visibility = View.VISIBLE
////                if (click == 0) {
////                    binding.itemCategoryColorSelectIv.visibility = View.VISIBLE
////                    click = 1
////                } else {
////                    binding.itemCategoryColorSelectIv.visibility = View.GONE
////                    click = 0
////                }
//            }

        }
    }

    override fun getItemCount(): Int = 10


}
