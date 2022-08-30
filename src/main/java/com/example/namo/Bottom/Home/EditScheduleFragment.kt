package com.example.namo.Bottom.Home

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.namo.Bottom.Todo.CategoryScheduleFragment
import com.example.namo.Data.Schedule.*
import com.example.namo.Floating.Schedule.AddActivity
import com.example.namo.Floating.Schedule.NewScheduleFragment
import com.example.namo.Floating.Schedule.PlaceSearchActivity
import com.example.namo.R
import com.example.namo.databinding.FragmentEditScheduleBinding
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.kakao.sdk.auth.AuthApiClient
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import okhttp3.internal.lockAndWaitNanos
import java.text.SimpleDateFormat
import java.util.*
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter

class EditScheduleFragment(val schedule : GetScheduleRes) : Fragment(), HomeView {

    lateinit var binding : FragmentEditScheduleBinding
    lateinit var editSchedule : EditSchedule

    lateinit var mapView : MapView
    var mapViewContainer : RelativeLayout? = null

    private var x : Double = 0.0
    private var y : Double = 0.0
    private var place : String = ""

    private var isDateOpen : Boolean = false
    private var isStartTimeOpen : Boolean = false
    private var isEndTimeOpen : Boolean = false
    private var isStartDate : Boolean = true
    private var isDateWasOpen : Boolean = false

    private var access : String = ""

    private var categoryName : String = ""
    private var categoryColor : Int = Color.parseColor("#DE8989")

    private var scheduleIdx : Int = 0
    private var name : String = ""
    private var startDate : String = ""
    private var endDate : String = ""
    private var location : String = ""
    private var locationX : String = ""
    private var locationY : String = ""
    private var categoryIdx : Int = 103

    private var startLocalDate = LocalDate.now()
    private var endLocalDate = LocalDate.now()
    private var startLocalTime = LocalTime.now()
    private var endLocalTime = LocalTime.now()
    private var startDay : String = ""
    private var endDay : String = ""
    private var startTime : String = ""
    private var endTime : String = ""

    private val serverFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)")
    private val sendDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val timeFormatter = DateTimeFormatter.ofPattern("hh : mm a")
    private val sendTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    var selectStartDay : Calendar = Calendar.getInstance()
    var selectEndDay : Calendar = Calendar.getInstance()

    var selectStartHour : Int = 0
    var selectEndHour : Int = 0
    var selectStartMin : Int = 0
    var selectEndMin : Int = 0

    private var tempSchedule = TempSchedule()

    companion object {
        private const val KEY_PREFS = "tempSchedule"
        private const val KEY_DATA = "tempData"
    }

    init {
        scheduleIdx = schedule.scheduleIdx

        name = schedule.name

        categoryName = schedule.categoryName
        if (!schedule.categoryColor.isNullOrEmpty())
            categoryColor = Color.parseColor(schedule.categoryColor)
        categoryIdx = schedule.categoryIdx

        var startDate = LocalDateTime.parse(schedule.startDate, serverFormatter)
        startDay = startDate.format(sendDateFormatter)
        startTime = startDate.format(sendTimeFormatter)
        startLocalDate = LocalDate.parse(startDay, sendDateFormatter)
        startLocalTime = LocalTime.parse(startTime, sendTimeFormatter)
        selectStartHour = startLocalTime.hour
        selectStartMin = startLocalTime.minute
        var calendar = Calendar.getInstance()
        calendar.set(
            startLocalDate.year,
            startLocalDate.monthValue - 1,
            startLocalDate.dayOfMonth
        )
        selectStartDay = calendar

        var endDate = LocalDateTime.parse(schedule.endDate, serverFormatter)
        endDay = endDate.format(sendDateFormatter)
        endTime = endDate.format(sendTimeFormatter)
        endLocalDate = LocalDate.parse(endDay, sendDateFormatter)
        endLocalTime = LocalTime.parse(endTime, sendTimeFormatter)
        selectEndHour = endLocalTime.hour
        selectEndMin = endLocalTime.minute
        calendar.set(
            endLocalDate.year,
            endLocalDate.monthValue - 1,
            endLocalDate.dayOfMonth
        )
        selectEndDay = calendar

        if (!schedule.locationX.isNullOrEmpty())
            x = schedule.locationX.toDouble()
        if (!schedule.locationY.isNullOrEmpty())
            y = schedule.locationY.toDouble()
        place = schedule.location
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("EDIT_SCHEDULE_FRAGMENT_LIFE","에딧스케줄프래그먼트 온크리에이트뷰")
        binding = FragmentEditScheduleBinding.inflate(inflater, container, false)

        initText()
        editText()

        initMapView()
        binding.editMapView.visibility = View.GONE
        mapViewContainer?.visibility = View.GONE


        clickEvent()

        getToken()


        //spf 초기화
        val spf = requireActivity().getSharedPreferences("ScheduleEdit", Context.MODE_PRIVATE)
        val editor = spf.edit()

        var editSchecule = spf.getInt("edit", 0)
        Log.d("spf-EditScheduleFrag", "edit(T/F) = ${editSchecule}")
        editor.clear().commit()

        editor.putInt("edit", 1) // 화면 넘어가면 edit & delete 가능
        Log.d("spf-EditScheduleFrag", "edit(T/F) = ${spf.getInt("edit", 0)}")

        return binding.root
    }

    private fun clickEvent(){
        binding.editPlaceLayout.setOnClickListener {
            activity?.let {
                mapViewContainer?.removeView(mapView)

                val intent = Intent(context, PlaceSearchActivity::class.java)
                startActivityForResult(intent, 2)
            }
        }

        //카맵 길찾기 클릭 주석처리
//        binding.editMapOpenKakaomapBtn.setOnClickListener {
////
////            x = String.format("%.7f", x).toDouble()
////            y = String.format("%.7f", y).toDouble()
//
//            activity?.let {
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://route?sp=${x},${y}&ep=37.4979502,127.0276368&by=PUBLICTRANSIT"))
//                Log.d("WGS84", "kakaomap://route?sp=${x},${y}&ep=37.4979502,127.0276368&by=PUBLICTRANSIT")
//                startActivity(intent)
//            }
//        }

        binding.editCategoryLayout.setOnClickListener {
            putPref()
            (context as EditScheduleActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.edit_frm, CategoryScheduleFragment(1, schedule, tempSchedule))
                .commitAllowingStateLoss()
        }

        binding.editStartDateTv.setOnClickListener {
            if (!isStartDate){
                if (isDateOpen) datePicker()
                else isStartDate = true
            }
            datePicker()
        }
        binding.editEndDateTv.setOnClickListener {
            if (isStartDate){
                if (isDateOpen) datePicker()
                else isStartDate = false
            }
            datePicker()
        }

        binding.editStartTimeTv.setOnClickListener {
            startTimePicker()
        }
        binding.editEndTimeTv.setOnClickListener {
            endTimePicker()
        }


        binding.editSaveTv.setOnClickListener {
            getSendDate()

            if (binding.editTitleEt.text.toString().isEmpty()){
                Toast.makeText(context as EditScheduleActivity, "일정 이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else if (startLocalDate.isAfter(endLocalDate)){
                Toast.makeText(context as EditScheduleActivity, "시작일이 종료일보다 이후로 지정될 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
            else if (startLocalDate.isEqual(endLocalDate) && startLocalTime.isAfter(endLocalTime)){
                Toast.makeText(context as EditScheduleActivity, "시작일과 종료일이 같을 때 시작시간이 종료시간보다 이후로 지정될 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                editSchedule = EditSchedule(scheduleIdx, name, startDate, endDate, location, locationX, locationY, categoryIdx)
                editScheduleData()
            }
        }

        binding.editCloseTv.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onResume() {
        super.onResume()
        loadPref()
    }

    private fun setDataFromTempSchedule(){
        //제목
        if (!tempSchedule.name.isNullOrEmpty()) {
            name = tempSchedule.name
            binding.editTitleEt.setText(name)
        }
        //카테고리
        isDateWasOpen = tempSchedule.isDateWasOpen
        if (!tempSchedule.categoryName.isNullOrEmpty()){
            categoryName = tempSchedule.categoryName
            categoryColor = tempSchedule.categoryColor
            categoryIdx = tempSchedule.categoryIdx
            binding.editCategoryContentNameTv.setText(categoryName)
            binding.editCategoryContentColorCv.setCardBackgroundColor(categoryColor)
        }
        //날짜
        if (!tempSchedule.startDay.isNullOrEmpty()) {
            startDay = tempSchedule.startDay
            startLocalDate = LocalDate.parse(startDay, sendDateFormatter)
            binding.editStartDateTv.text = startLocalDate.format(dateFormatter)
            var calendar = Calendar.getInstance()
            calendar.set(
                startLocalDate.year,
                startLocalDate.monthValue - 1,
                startLocalDate.dayOfMonth
            )
            selectStartDay = calendar
        }
        if (!tempSchedule.endDay.isNullOrEmpty()){
            endDay = tempSchedule.endDay
            endLocalDate = LocalDate.parse(endDay, sendDateFormatter)
            binding.editEndDateTv.text = endLocalDate.format(dateFormatter)
            var calendar = Calendar.getInstance()
            calendar.set(endLocalDate.year, endLocalDate.monthValue-1, endLocalDate.dayOfMonth)
            selectEndDay = calendar
        }
        //시간
        if (!tempSchedule.startTime.isNullOrEmpty()){
            startTime = tempSchedule.startTime
            startLocalTime = LocalTime.parse(startTime, sendTimeFormatter)
            binding.editStartTimeTv.text = startLocalTime.format(timeFormatter)
            selectStartHour = startLocalTime.hour
            selectStartMin = startLocalTime.minute
        }
        if (!tempSchedule.endTime.isNullOrEmpty()){
            endTime = tempSchedule.endTime
            endLocalTime = LocalTime.parse(endTime, sendTimeFormatter)
            binding.editEndTimeTv.text = endLocalTime.format(timeFormatter)
            selectEndHour = endLocalTime.hour
            selectEndMin = endLocalTime.minute
        }
        if (tempSchedule.x != 0.0){
            x = tempSchedule.x
            y = tempSchedule.y
            place = tempSchedule.place
            showingMapContent()
        }
    }

    private fun putPref(){
        storeTemp()

        val sharedPreferences = requireActivity().getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(tempSchedule)
        editor.putString(KEY_DATA, json)
        editor.apply()
        Log.d("EDIT_PREF", "put finish" +  tempSchedule.toString())
    }

    private fun loadPref(){
        val sharedPreferences = requireActivity().getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        if (sharedPreferences.contains(KEY_DATA)){
            val gson = Gson()
            val json = sharedPreferences.getString(KEY_DATA, "")
            try {
                val typeToken = object : TypeToken<TempSchedule>(){}.type
                tempSchedule = gson.fromJson(json, typeToken)
                setDataFromTempSchedule()
            } catch (e : JsonParseException){
                e.printStackTrace()
            }
            Log.d("EDIT_PREF", tempSchedule.toString())
        }
        else Log.d("EDIT_PREF", "clear already")
    }

    private fun storeTemp(){
        tempSchedule = TempSchedule(name, categoryName, categoryColor, categoryIdx, isDateWasOpen, startDay, endDay, startTime, endTime, x, y, place)
    }

    override fun onStop() {
        super.onStop()
        putPref()
    }

    private fun editText(){
        val editText = binding.editTitleEt
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                Log.e(ContentValues.TAG, "beforeTextChanged() - charSequence : $charSequence")
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                Log.e(ContentValues.TAG, "onTextChanged() - charSequence : $charSequence")
            }

            override fun afterTextChanged(editable: Editable) {
                Log.e(ContentValues.TAG, "afterTextChanged() - editable : $editable")
                name = editText.text.toString()
            }
        })
    }

    private fun initMapView(){
        mapView = MapView(context as EditScheduleActivity).also {
            mapViewContainer = RelativeLayout(context as EditScheduleActivity)
            mapViewContainer?.layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
            binding.editMapView.addView(mapViewContainer)
            mapViewContainer?.addView(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        initMapView()

        if (resultCode == RESULT_OK){
            x = data?.getDoubleExtra("x", 0.0)!!
            y = data?.getDoubleExtra("y", 0.0)!!
            place = data?.getStringExtra("name")!!

            location = place
            locationX = x.toString()
            locationY = y.toString()
        }

        if (!(x == 0.0) || !(y == 0.0)){
            showingMapContent()
        }
    }

    private fun showingMapContent(){
        binding.editMapView.visibility = View.VISIBLE
        mapViewContainer?.visibility = View.VISIBLE

        var mapPoint = MapPoint.mapPointWithGeoCoord(y,x)
        mapView.setMapCenterPointAndZoomLevel(mapPoint, 1, true)

        binding.editPlaceContentTv.text = place

        var marker = MapPOIItem()
        marker.itemName = place
        marker.tag = 0
        marker.mapPoint = mapPoint
        marker.markerType = MapPOIItem.MarkerType.BluePin
        marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin

        mapView.addPOIItem(marker)

        binding.editMapOpenKakaomapBtn.visibility = View.VISIBLE
    }

    private fun getToken(){

        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)
        
        access = spf!!.getString("access","")!!

        Log.d("TOKEN-ACC",access)

    }

    private fun initText(){
        binding.editTitleEt.setText(name)
        binding.editCategoryContentNameTv.setText(categoryName)
        binding.editCategoryContentColorCv.setCardBackgroundColor(categoryColor)
        binding.editStartDateTv.setText(startLocalDate.format(dateFormatter))
        binding.editStartTimeTv.setText(startLocalTime.format(timeFormatter))
        binding.editEndDateTv.setText(endLocalDate.format(dateFormatter))
        binding.editEndTimeTv.setText(endLocalTime.format(timeFormatter))
        binding.editPlaceContentTv.setText(location)
    }


    private fun startTimePicker(){
        if(isDateOpen){
            binding.editDatepickerDp.visibility = View.GONE
            isDateOpen = !isDateOpen
            //bg
            if (isStartDate){
                binding.editStartDateBg.visibility = View.GONE
                binding.editStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.editEndDateBg.visibility = View.GONE
                binding.editEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
        }
        if(isEndTimeOpen){
            binding.editEndTimepickerTp.visibility = View.GONE
            isEndTimeOpen = !isEndTimeOpen

            //bg
            binding.editEndTimeBg.visibility = View.GONE
            binding.editEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //타임피커가 열려있으면 닫아야 함
        if(isStartTimeOpen){
            binding.editStartTimepickerTp.visibility = View.GONE

            //bg
            binding.editStartTimeBg.visibility = View.GONE
            binding.editStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //닫혀있으면 열어야 함
        else{
            binding.editStartTimepickerTp.visibility = View.VISIBLE
            startTimeData()

            //bg
            binding.editStartTimeBg.visibility = View.VISIBLE
            binding.editStartTimeTv.setTextColor(resources.getColor(R.color.white))
        }
        isStartTimeOpen = !isStartTimeOpen
    }

    private fun endTimePicker(){
        if(isDateOpen){
            binding.editDatepickerDp.visibility = View.GONE
            isDateOpen = !isDateOpen
            //bg
            if (isStartDate){
                binding.editStartDateBg.visibility = View.GONE
                binding.editStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.editEndDateBg.visibility = View.GONE
                binding.editEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
        }
        if(isStartTimeOpen){
            binding.editStartTimepickerTp.visibility = View.GONE
            isStartTimeOpen = !isStartTimeOpen
            //bg
            binding.editStartTimeBg.visibility = View.GONE
            binding.editStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //타임피커가 열려있으면 닫아야 함
        if(isEndTimeOpen){
            binding.editEndTimepickerTp.visibility = View.GONE
            //bg
            binding.editEndTimeBg.visibility = View.GONE
            binding.editEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //닫혀있으면 열어야 함
        else{
            binding.editEndTimepickerTp.visibility = View.VISIBLE
            endTimeData()
            //bg
            binding.editEndTimeBg.visibility = View.VISIBLE
            binding.editEndTimeTv.setTextColor(resources.getColor(R.color.white))
        }
        isEndTimeOpen = !isEndTimeOpen
    }

    private fun datePicker(){
        if(isStartTimeOpen){
            binding.editStartTimepickerTp.visibility = View.GONE
            isStartTimeOpen = !isStartTimeOpen
            //bg
            binding.editStartTimeBg.visibility = View.GONE
            binding.editStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        if(isEndTimeOpen){
            binding.editEndTimepickerTp.visibility = View.GONE
            isEndTimeOpen = !isEndTimeOpen

            //bg
            binding.editEndTimeBg.visibility = View.GONE
            binding.editEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //데이트피커 열려있으면 닫기
        if(isDateOpen){
            if (isStartDate){
                binding.editStartDateBg.visibility = View.GONE
                binding.editStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.editEndDateBg.visibility = View.GONE
                binding.editEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
            isStartDate = !isStartDate
            if (isDateWasOpen){
                isDateWasOpen = true
            }
            Log.d("DateData","close isDateWasOpen : $isDateWasOpen")
            binding.editDatepickerDp.visibility = View.GONE
        }
        //데이트피커 닫혀있으면 열기
        else{
            binding.editDatepickerDp.visibility = View.VISIBLE
            Log.d("DateData","open isDateWasOpen : $isDateWasOpen")
            if (isStartDate){
                startDateData()
                //bg
                binding.editStartDateBg.visibility = View.VISIBLE
                binding.editStartDateTv.setTextColor(resources.getColor(R.color.white))
            } else {
                if (!isDateWasOpen) {
                    isDateWasOpen = true
                }
                endDateData()
                //bg
                binding.editEndDateBg.visibility = View.VISIBLE
                binding.editEndDateTv.setTextColor(resources.getColor(R.color.white))
            }
        }

        isDateOpen = !isDateOpen
    }

    private fun startDateData(){
        val datePicker = binding.editDatepickerDp
        Log.d("DateData","startDateData")

        datePicker.init(
            selectStartDay.get(Calendar.YEAR), selectStartDay.get(Calendar.MONTH), selectStartDay.get(Calendar.DAY_OF_MONTH)
        ){
                view, year, month, date ->

            selectStartDay.set(year, month, date)

            var day = LocalDate.of(year, month + 1, date)
            startLocalDate = day //저장 시 일 구분에 사용
            val select = day.format(dateFormatter)

            //서버에 보낼 데이터
            startDay = day.format(sendDateFormatter)

            binding.editStartDateTv.text = select
            if(!isDateWasOpen){
                selectEndDay.set(year, month, date)
                binding.editEndDateTv.text = select
                endDay = day.format(sendDateFormatter)
                endLocalDate = day
            }
            Log.d("DateData","startDateData isDateWasOpen : $isDateWasOpen")
            Log.d("DateData","startDateData endStartDate : $selectEndDay")
        }
    }

    private fun endDateData(){
        Log.d("DateData","endDateData")
        val datePicker = binding.editDatepickerDp

        datePicker.init(
            selectEndDay.get(Calendar.YEAR), selectEndDay.get(Calendar.MONTH), selectEndDay.get(Calendar.DAY_OF_MONTH)
        ){
                view, year, month, date ->

            selectEndDay.set(year, month, date)

            var day = LocalDate.of(year, month + 1, date)
            endLocalDate = day
            val select = day.format(dateFormatter)

            //서버에 보낼 데이터
            endDay = day.format(sendDateFormatter)

            binding.editEndDateTv.text = select
        }
    }

    private fun startTimeData(){
        val timePicker = binding.editStartTimepickerTp
        timePicker.hour = selectStartHour
        timePicker.minute = selectStartMin

        timePicker.setOnTimeChangedListener{ _, hour, minute ->
            selectStartHour = hour
            selectStartMin = minute

            var time = LocalTime.of(hour, minute)
            startLocalTime = time
            var select = time.format(timeFormatter)

            //서버에 보낼 데이터
            startTime = time.format(sendTimeFormatter)

            binding.editStartTimeTv.text = select
        }
    }

    private fun endTimeData(){
        val timePicker = binding.editEndTimepickerTp
        timePicker.hour = selectEndHour
        timePicker.minute = selectEndMin

        timePicker.setOnTimeChangedListener{ _, hour, minute -> var hour = hour
            selectEndHour = hour
            selectEndMin = minute

            var time = LocalTime.of(hour, minute)
            endLocalTime = time
            var select = time.format(timeFormatter)

            //서버에 보낼 데이터
            endTime = time.format(sendTimeFormatter)

            binding.editEndTimeTv.text = select
        }
    }

    private fun editScheduleData(){
        val scheduleService = ScheduleService()
        scheduleService.setHomeView(this)

        Log.d("EDIT", editSchedule.toString())

        scheduleService.editSchedule(access, editSchedule)
    }

    private fun getSendDate(){

        startDate = startDay + " " + startTime
        endDate = endDay + " " + endTime

        Log.d("SEND_DATE", "startDate : " + startDate)
        Log.d("SEND_DATE", "endDate : " + endDate)
    }

    override fun onInputScheduleSuccess(code: Int, result: ScheduleResult) {
        TODO("Not yet implemented")
    }

    override fun onEditScheduleSuccess(code: Int, result: String) {
        when(code){
            1000 -> {
                Log.d("ONEDIT_SCHEDULE_SUCCESS", "SUCCESS, result : ${result}")
                Toast.makeText(context as EditScheduleActivity, "일정이 수정되었습니다.", Toast.LENGTH_SHORT).show()
                finishActivity()
            }
        }
    }

    override fun onDeleteScheduleSuccess(code: Int, result: String) {
        TODO("Not yet implemented")
    }

    private fun finishActivity() {
        activity?.finish()
    }
}