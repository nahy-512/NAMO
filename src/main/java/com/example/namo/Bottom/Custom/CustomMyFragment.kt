package com.example.namo.Bottom.Custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Custom.Adapter.PaletteRVAdapter
import com.example.namo.Data.Custom.Palette
import com.example.namo.databinding.FragmentCustomFontBinding
import com.example.namo.databinding.FragmentCustomMyBinding

class CustomMyFragment : Fragment() {

    lateinit var binding : FragmentCustomMyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentCustomMyBinding.inflate(inflater, container, false)

        //더미데이터 냅다 집어 넣기
        var paletteDatas = arrayListOf<Palette>(
            Palette("기본 팔레트",
                arrayListOf("#EB5353", "#EC9B3B", "#FBCB0A", "#96BB7C", "#5A8F7B",
                    "#82C4C3", "#187498", "#8571BF", "#E36488", "#858585")),
        )

        //어댑터 연결
        binding.customMyPaletteRv.apply {
            adapter = PaletteRVAdapter().build(paletteDatas)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        return binding.root
    }
}