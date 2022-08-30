package com.example.namo.Bottom.Home

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.namo.Bottom.Home.Record.RecordEditActivity
import com.example.namo.Bottom.Home.Record.RecordWriteActivity
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.TempSchedule
import com.example.namo.Floating.Schedule.AddActivity
import com.example.namo.R
import com.example.namo.databinding.FragmentSeeScheduleBinding
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.text.SimpleDateFormat
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter

class SeeScheduleFragment(val schedule : GetScheduleRes) : Fragment() {
    lateinit var binding : FragmentSeeScheduleBinding
    private var color : Int = R.color.MainOrange

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)")
    private val sendDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    private val timeFormatter = DateTimeFormatter.ofPattern("hh : mm a")

    lateinit var mapView: MapView
    var mapViewContainer: RelativeLayout? = null

    private var x:Double = 0.0
    private var y:Double = 0.0
    private var place:String = ""
    private var id : String = ""
    private var isMapView = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SEE_SCHEDULE_FRAGMENT_LIFE","씨스케줄프래그먼트 온크리에이트뷰")

        binding = FragmentSeeScheduleBinding.inflate(inflater, container, false)
//        Log.d("DOUBLE","X : string : ${schedule.locationX} and to DOUBLE : ${schedule.locationX.toDouble()}")
//        Log.d("DOUBLE","Y : string : ${schedule.locationY} and to DOUBLE : ${schedule.locationX.toDouble()}")

        if ((!schedule.locationX.isNullOrEmpty()) && (!schedule.locationY.isNullOrEmpty())){
            x = schedule.locationX.trim().toDouble()
            y = schedule.locationY.trim().toDouble()
            place = schedule.location

            binding.seePlaceContentTv.setText(place)

            //여기 맵 주석처리 3줄
            initMapView()
            binding.seeMapView.visibility = View.VISIBLE
            mapViewContainer?.visibility = View.VISIBLE
            isMapView = true
        }

        initView()


        binding.seeCloseTv.setOnClickListener {
            activity?.finish()
        }

        //카맵 길찾기 클릭
//        binding.seeMapOpenKakaomapBtn.setOnClickListener{
//            activity?.let {
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://place?id=" + id))
//                startActivity(intent)
//            }
//        }

        binding.seeEditTv.setOnClickListener {
            if (isMapView){
                mapViewContainer?.removeView(mapView)
            }
            (context as EditScheduleActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.edit_frm, EditScheduleFragment(schedule))
                .commitAllowingStateLoss()
        }

        //일정 기록 화면

        if(schedule.moimIdx==0) {
            binding.recordText.setOnClickListener {
                mapViewContainer?.removeView(mapView)
                var intent = Intent(context, RecordWriteActivity::class.java)
                intent.putExtra("schedule", schedule)
                startActivity(intent)
            }
        }
        else{
            binding.recordImg.visibility=GONE
            binding.recordText.visibility=GONE
        }

        //spf 초기화
        val spf = requireActivity().getSharedPreferences("ScheduleEdit", Context.MODE_PRIVATE)
        val editor = spf.edit()

        spf.edit().clear().commit()

        editor.putInt("edit", 0) // 화면 넘어가면 edit & delete 불가능 (post만)
        Log.d("spf-SeeScheduleFrag", "edit(T/F) = ${spf.getInt("edit", 0)}")

        return binding.root
    }

    fun findColor(inputColor : String){
        when(inputColor){
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette1)).substring(2).toUpperCase() -> {
                color = R.color.palette1
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette2)).substring(2).toUpperCase() -> {
                color = R.color.palette2
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette3)).substring(2).toUpperCase() -> {
                color = R.color.palette3
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette4)).substring(2).toUpperCase() -> {
                color = R.color.palette4
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette5)).substring(2).toUpperCase() -> {
                color = R.color.palette5
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette6)).substring(2).toUpperCase() -> {
                color = R.color.palette6
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette7)).substring(2).toUpperCase() -> {
                color = R.color.palette7
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette8)).substring(2).toUpperCase() -> {
                color = R.color.palette8
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette9)).substring(2).toUpperCase() -> {
                color = R.color.palette9
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.palette10)).substring(2).toUpperCase() -> {
                color = R.color.palette10
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.schedule)).substring(2).toUpperCase() -> {
                color = R.color.schedule
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.schedule_plan)).substring(2).toUpperCase() -> {
                color = R.color.schedule_plan
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.schedule_parttime)).substring(2).toUpperCase() -> {
                color = R.color.schedule_parttime
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.schedule_special)).substring(2).toUpperCase() -> {
                color = R.color.schedule_special
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context as EditScheduleActivity, R.color.schedule_group)).substring(2).toUpperCase() -> {
                color = R.color.schedule_group
            }
            else -> color = R.color.MainOrange
        }
    }


    private fun initView(){
        binding.seeTitleTv.setText(schedule.name)
        binding.seeCategoryContentNameTv.setText(schedule.categoryName)
        findColor(schedule.categoryColor)
        binding.seeCategoryContentColorCiv.setImageResource(color)

        setTimeText()
        binding.seePlaceContentTv.setText(schedule.location)
        //카카오맵도 보여줘야 됨

    }

    private fun setTimeText(){
        var startDate = LocalDateTime.parse(schedule.startDate, sendDateFormatter)
        var endDate = LocalDateTime.parse(schedule.endDate, sendDateFormatter)
        var startDay = startDate.format(dateFormatter)
        var endDay = endDate.format(dateFormatter)
        var startTime = startDate.format(timeFormatter)
        var endTime = endDate.format(timeFormatter)

        binding.seeStartDateTv.setText(startDay)
        binding.seeEndDateTv.setText(endDay)
        binding.seeStartTimeTv.setText(startTime)
        binding.seeEndTimeTv.setText(endTime)
    }

    private fun initMapView(){
        mapView = MapView(context as EditScheduleActivity).also {
            mapViewContainer = RelativeLayout(context as EditScheduleActivity)
            mapViewContainer?.layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
            binding.seeMapView.addView(mapViewContainer)
            mapViewContainer?.addView(it)
        }

        if(!(x == 0.0) || !(y == 0.0)){
            showingMapContent()
        }
    }

    private fun showingMapContent(){
        binding.seeMapView.visibility = View.VISIBLE
        mapViewContainer?.visibility = View.VISIBLE

        var mapPoint = MapPoint.mapPointWithGeoCoord(y,x)
        mapView.setMapCenterPointAndZoomLevel(mapPoint, 1, true)

        binding.seePlaceContentTv.text = place

        var marker = MapPOIItem()
        marker.itemName = place
        marker.tag = 0
        marker.mapPoint = mapPoint
        marker.markerType = MapPOIItem.MarkerType.BluePin
        marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin

        mapView.addPOIItem(marker)

        binding.seeMapOpenKakaomapBtn.visibility = View.VISIBLE
    }

}