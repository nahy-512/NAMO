package com.example.namo.Bottom.Custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.namo.databinding.FragmentCustomFontBinding
import com.example.namo.databinding.FragmentCustomStickerBinding

class CustomStickerFragment : Fragment() {

    lateinit var binding : FragmentCustomStickerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentCustomStickerBinding.inflate(inflater, container, false)

        return binding.root
    }
}