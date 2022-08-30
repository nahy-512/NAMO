package com.example.namo.Bottom.Todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.namo.databinding.FragmentScheduleTodoTabBinding

//날짜 클릭하면 나오는 To-do 탭

class ScheduleTodoTabFragment : Fragment() {
    lateinit var binding: FragmentScheduleTodoTabBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentScheduleTodoTabBinding.inflate(inflater,container,false)
        return binding.root
    }
}