package com.example.namo.Floating.Schedule


import android.app.Activity
import com.example.namo.Data.Schedule.ScheduleService
import android.app.Activity.MODE_PRIVATE
import android.app.Activity.RESULT_OK
import android.content.ContentValues.TAG
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
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.namo.Bottom.Home.HomeView
import com.example.namo.Bottom.Todo.CategoryScheduleFragment
import com.example.namo.Data.Category.todo.CategoryContent
import com.example.namo.Data.Login.GlobalApplication
import com.example.namo.Data.Schedule.*
import com.example.namo.R
import com.example.namo.databinding.FragmentNewScheduleBinding
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.kakao.sdk.auth.AuthApiClient
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.text.SimpleDateFormat
import java.util.*
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter



class NewScheduleFragment : Fragment(), HomeView {

    lateinit var contextActivity : Context

    lateinit var binding: FragmentNewScheduleBinding

    private var isDateOpen : Boolean = false
    private var isStartTimeOpen : Boolean = false
    private var isEndTimeOpen : Boolean = false
    private var isStartDate : Boolean = true
    private var isDateWasOpen : Boolean = false

    lateinit var schedule : Schedule

    private var access : String = ""

    private var categoryName : String = ""
    private var categoryColor : Int = Color.parseColor("#DE8989")

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

    private var alert : String? = null

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)")
    private val sendDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val timeFormatter = DateTimeFormatter.ofPattern("hh : mm a")
    private val sendTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    lateinit var mapView: MapView
    var mapViewContainer: RelativeLayout? = null

    private var x:Double = 0.0
    private var y:Double = 0.0
    private var id : String = ""
    private var place:String = ""

    var selectStartDay : Calendar = Calendar.getInstance()
    var selectEndDay : Calendar = Calendar.getInstance()

    var selectStartHour : Int = 0
    var selectEndHour : Int = 0
    var selectStartMin : Int = 0
    var selectEndMin : Int = 0

    var tempSchedule = TempSchedule()

    companion object {
        private const val KEY_PREFS = "tempSchedule"
        private const val KEY_DATA = "tempData"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextActivity = context
//        Log.d("NEW_LIFE","뉴스케줄 온어태치")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
//        Log.d("NEW_LIFE","뉴스케줄 온크리에이트뷰")
        binding = FragmentNewScheduleBinding.inflate(inflater, container, false)

        initText()
        editText()

        //여기 맵 주석처리 3줄
        initMapView()
        binding.addMapView.visibility = View.GONE
        mapViewContainer?.visibility = View.GONE

        getToken()

        setAlert() //알람 설정

        clickEvent()

        return binding.root
    }

    private fun clickEvent(){

        //여기 맵 주석처리 한 블록
        binding.addPlaceLayout.setOnClickListener {
            putPref()
            activity?.let {
                mapViewContainer?.removeView(mapView)
                val intent = Intent(context, PlaceSearchActivity::class.java)
                startActivityForResult(intent, 2)
            }
        }

        binding.addMapOpenKakaomapBtn.setOnClickListener {

            activity?.let {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://place?id=" + id))
                startActivity(intent)
            }
        }

        binding.addCategoryLayout.setOnClickListener {
            putPref()
            (context as AddActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.add_frm, CategoryScheduleFragment(0, GetScheduleRes(), tempSchedule))
                .commitAllowingStateLoss()
        }

        binding.addCloseTv.setOnClickListener {
            activity?.finish()
        }

        binding.addStartDateTv.setOnClickListener {
            if (!isStartDate){
                if (isDateOpen) datePicker()
                else isStartDate = true
            }
            datePicker()
        }
        binding.addEndDateTv.setOnClickListener {
            if (isStartDate){
                if (isDateOpen) datePicker()
                else isStartDate = false
            }
            datePicker()
        }

        binding.addStartTimeTv.setOnClickListener {
            startTimePicker()
        }
        binding.addEndTimeTv.setOnClickListener {
            endTimePicker()
        }

        binding.addSaveTv.setOnClickListener {
            getSendDate()

            if(binding.addTitleEt.text.toString().isEmpty()){
                Toast.makeText(context as AddActivity, "일정 이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else if (startLocalDate.isAfter(endLocalDate)){
                Toast.makeText(context as AddActivity, "시작일이 종료일보다 이후로 지정될 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
            else if (startLocalDate.isEqual(endLocalDate) && startLocalTime.isAfter(endLocalTime)){
                Toast.makeText(context as AddActivity, "시작일과 종료일이 같을 때 시작시간이 종료시간보다 이후로 지정될 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                schedule = Schedule(name, startDate, endDate, location, locationX, locationY, categoryIdx)
                getScheduleData()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadPref()

//        Log.d("NEW_LIFE","뉴스케줄 온리줌")
    }

    private fun setDataFromTempSchedule(){
        //제목
        if (!tempSchedule.name.isNullOrEmpty()) {
            name = tempSchedule.name
            binding.addTitleEt.setText(name)
        }
        //카테고리
        isDateWasOpen = tempSchedule.isDateWasOpen
        if (!tempSchedule.categoryName.isNullOrEmpty()){
            categoryName = tempSchedule.categoryName
            categoryColor = tempSchedule.categoryColor
            categoryIdx = tempSchedule.categoryIdx
            binding.addCategoryContentNameTv.setText(categoryName)
            binding.addCategoryContentColorCv.setCardBackgroundColor(categoryColor)
        }
        //날짜
        if (!tempSchedule.startDay.isNullOrEmpty()) {
            startDay = tempSchedule.startDay
            startLocalDate = LocalDate.parse(startDay, sendDateFormatter)
            binding.addStartDateTv.text = startLocalDate.format(dateFormatter)
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
            binding.addEndDateTv.text = endLocalDate.format(dateFormatter)
            var calendar = Calendar.getInstance()
            calendar.set(endLocalDate.year, endLocalDate.monthValue-1, endLocalDate.dayOfMonth)
            selectEndDay = calendar
        }
        //시간
        if (!tempSchedule.startTime.isNullOrEmpty()){
            startTime = tempSchedule.startTime
            startLocalTime = LocalTime.parse(startTime, sendTimeFormatter)
            binding.addStartTimeTv.text = startLocalTime.format(timeFormatter)
            selectStartHour = startLocalTime.hour
            selectStartMin = startLocalTime.minute
        }
        if (!tempSchedule.endTime.isNullOrEmpty()){
            endTime = tempSchedule.endTime
            endLocalTime = LocalTime.parse(endTime, sendTimeFormatter)
            binding.addEndTimeTv.text = endLocalTime.format(timeFormatter)
            selectEndHour = endLocalTime.hour
            selectEndMin = endLocalTime.minute
        }
        if (tempSchedule.x != 0.0){
            x = tempSchedule.x
            y = tempSchedule.y
            place = tempSchedule.place
            locationX = x.toString()
            locationY = y.toString()
            location = place
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
        Log.d("SCHEDULE_PREF", "put finish" +  tempSchedule.toString())
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
            Log.d("SCHEDULE_PREF", tempSchedule.toString())
        }
        else Log.d("SCHEDULE_PREF", "clear already")
    }

    private fun storeTemp(){
        tempSchedule = TempSchedule(name, categoryName, categoryColor, categoryIdx, isDateWasOpen, startDay, endDay, startTime, endTime, x, y, place)
    }

    override fun onStop() {
        super.onStop()
//        Log.d("NEW_LIFE","뉴스케줄 온스탑")
        putPref()
    }


    //여기 맵 주석처리 : 이닛맵뷰, 온 액티비티 리줄트
    private fun initMapView(){
        mapView = MapView(context as AddActivity).also {
            mapViewContainer = RelativeLayout(context as AddActivity)
            mapViewContainer?.layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
            binding.addMapView.addView(mapViewContainer)
            mapViewContainer?.addView(it)
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("ONACTIVITYRESULT","onresult")

        initMapView()

        if(resultCode == RESULT_OK){
            x = data?.getDoubleExtra("x",0.0)!!
            y = data?.getDoubleExtra("y",0.0)!!
            place = data?.getStringExtra("name")!!
            id = data?.getStringExtra("id")!!

            location = place
            locationX = x.toString()
            locationY = y.toString()
            Log.d("LOCATION","X : ${x} ans string : ${locationX} and to DOUBLE : ${locationX.toDouble()}")
            Log.d("LOCATION","X : ${y} ans string : ${locationY} and to DOUBLE : ${locationY.toDouble()}")
        }

        if(!(x == 0.0) || !(y == 0.0)){
            showingMapContent()
        }
    }

    private fun showingMapContent(){
        binding.addMapView.visibility = View.VISIBLE
        mapViewContainer?.visibility = View.VISIBLE

        var mapPoint = MapPoint.mapPointWithGeoCoord(y,x)
        mapView.setMapCenterPointAndZoomLevel(mapPoint, 1, true)

        binding.addPlaceContentTv.text = place

        var marker = MapPOIItem()
        marker.itemName = place
        marker.tag = 0
        marker.mapPoint = mapPoint
        marker.markerType = MapPOIItem.MarkerType.BluePin
        marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin

        mapView.addPOIItem(marker)

        binding.addMapOpenKakaomapBtn.visibility = View.VISIBLE
    }

    private fun editText(){
        val editText = binding.addTitleEt
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                Log.e(TAG, "beforeTextChanged() - charSequence : $charSequence")
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                Log.e(TAG, "onTextChanged() - charSequence : $charSequence")
            }

            override fun afterTextChanged(editable: Editable) {
                Log.e(TAG, "afterTextChanged() - editable : $editable")
                name = editText.text.toString()
            }
        })
    }

    private fun getScheduleData(){
        val scheduleService = ScheduleService()
        scheduleService.setHomeView(this)

        scheduleService.getSchedule(access, schedule)
        Log.d("GET_SCHEDULE_DATA",access)
        Log.d("GET_SCHEDULE_DATA",schedule.toString())
    }

    private fun getToken(){
        val spf = activity?.getSharedPreferences("token", MODE_PRIVATE)
        access = spf!!.getString("access","")!!

        Log.d("TOKEN-ACC",access)
    }

    private fun setAlert(){
        binding.addAlarmContentTv.setOnClickListener {
            var popupMenu = PopupMenu(context, it)
            popupMenu.menuInflater.inflate(R.menu.alert_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                if (menuItem.itemId === R.id.alert_5_min_ago) {
                    Toast.makeText(activity, "5분 전", Toast.LENGTH_SHORT).show()
                    alert = "5분 전"
//                    startActivity(Intent(activity, AddfriendActivity::class.java))
                } else if (menuItem.itemId === R.id.alert_10_min_ago) {
                    Toast.makeText(activity, "10분 전", Toast.LENGTH_SHORT).show()
                    alert = "10분 전"
                } else if (menuItem.itemId === R.id.alert_15_min_ago) {
                    Toast.makeText(activity, "15분 전", Toast.LENGTH_SHORT).show()
                    alert = "15분 전"
                } else if (menuItem.itemId === R.id.alert_30_min_ago) {
                    Toast.makeText(activity, "30분 전", Toast.LENGTH_SHORT).show()
                    alert = "30분 전"
                } else if (menuItem.itemId === R.id.alert_1_hour_ago) {
                    Toast.makeText(activity, "1시간 전", Toast.LENGTH_SHORT).show()
                    alert = "1시간 전"
                } else if (menuItem.itemId === R.id.alert_3_hour_ago) {
                    Toast.makeText(activity, "3시간 전", Toast.LENGTH_SHORT).show()
                    alert = "3시간 전"
                }
                binding.addAlarmContentTv.text = "$alert"
                false
            }
            popupMenu.show()
        }
    }

    override fun onInputScheduleSuccess(code: Int, result: ScheduleResult) {
        when(code){
            1000 ->{
                Log.d("ONINPUT_SCHEDULE_SUCCESS","SUCCESS, result : ${result.scheduleIdx}")
                Toast.makeText(contextActivity, "일정이 추가되었습니다", Toast.LENGTH_SHORT).show()
//                Toast.makeText(context as AddActivity, "일정이 추가되었습니다.", Toast.LENGTH_SHORT).show() 이건 에러남!
                finishActivity()
            }
        }
    }

    override fun onEditScheduleSuccess(code: Int, result: String) {
        when(code){
            1000 -> {
                Log.d("ONEDIT_SCHEDULE_SUCCESS", "SUCCESS, result : ${result}")
            }
        }
    }

    override fun onDeleteScheduleSuccess(code: Int, result: String) {
        when(code){
            1000 -> {
                Log.d("ONDELETE_SCHEDULE_SUCCESS","SUCCESS, result : ${result}")
            }
        }
    }

    private fun initText(){
        //날짜 설정
        var current = LocalDate.now()
        var today = current.format(dateFormatter)
        binding.addStartDateTv.text = today
        binding.addEndDateTv.text = today

        //서버에 보낼 데이터 준비
        var sendDay = current.format(sendDateFormatter)
        startDay = sendDay
        endDay = sendDay

        initTime()
    }

    private fun initTime(){
        var current = LocalTime.now()
        var time = current.format(timeFormatter)
        binding.addStartTimeTv.text = time
        selectStartHour = current.hour
        selectStartMin = current.minute
        //서버에 보낼 시작시간
        startTime = current.format(sendTimeFormatter)

        //종료시간
        current = current.plusHours(1)
        time = current.format(timeFormatter)
        binding.addEndTimeTv.text = time
        endLocalTime = current // 나중에 저장 시 시간 파악에 활용

        selectEndHour = current.hour
        selectEndMin = current.minute
        //서버에 보낼 종료시간
        endTime = current.format(sendTimeFormatter)
    }

    private fun startTimePicker(){
        if(isDateOpen){
            binding.addDatepickerDp.visibility = View.GONE
            isDateOpen = !isDateOpen
            //bg
            if (isStartDate){
                binding.addStartDateBg.visibility = View.GONE
                binding.addStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.addEndDateBg.visibility = View.GONE
                binding.addEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
        }
        if(isEndTimeOpen){
            binding.addEndTimepickerTp.visibility = View.GONE
            isEndTimeOpen = !isEndTimeOpen

            //bg
            binding.addEndTimeBg.visibility = View.GONE
            binding.addEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //타임피커가 열려있으면 닫아야 함
        if(isStartTimeOpen){
            binding.addStartTimepickerTp.visibility = View.GONE

            //bg
            binding.addStartTimeBg.visibility = View.GONE
            binding.addStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //닫혀있으면 열어야 함
        else{
            binding.addStartTimepickerTp.visibility = View.VISIBLE
            startTimeData()

            //bg
            binding.addStartTimeBg.visibility = View.VISIBLE
            binding.addStartTimeTv.setTextColor(resources.getColor(R.color.white))
        }
        isStartTimeOpen = !isStartTimeOpen
    }

    private fun endTimePicker(){
        if(isDateOpen){
            binding.addDatepickerDp.visibility = View.GONE
            isDateOpen = !isDateOpen
            //bg
            if (isStartDate){
                binding.addStartDateBg.visibility = View.GONE
                binding.addStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.addEndDateBg.visibility = View.GONE
                binding.addEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
        }
        if(isStartTimeOpen){
            binding.addStartTimepickerTp.visibility = View.GONE
            isStartTimeOpen = !isStartTimeOpen
            //bg
            binding.addStartTimeBg.visibility = View.GONE
            binding.addStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //타임피커가 열려있으면 닫아야 함
        if(isEndTimeOpen){
            binding.addEndTimepickerTp.visibility = View.GONE
            //bg
            binding.addEndTimeBg.visibility = View.GONE
            binding.addEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //닫혀있으면 열어야 함
        else{
            binding.addEndTimepickerTp.visibility = View.VISIBLE
            endTimeData()
            //bg
            binding.addEndTimeBg.visibility = View.VISIBLE
            binding.addEndTimeTv.setTextColor(resources.getColor(R.color.white))
        }
        isEndTimeOpen = !isEndTimeOpen
    }

    private fun datePicker(){
        if(isStartTimeOpen){
            binding.addStartTimepickerTp.visibility = View.GONE
            isStartTimeOpen = !isStartTimeOpen
            //bg
            binding.addStartTimeBg.visibility = View.GONE
            binding.addStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        if(isEndTimeOpen){
            binding.addEndTimepickerTp.visibility = View.GONE
            isEndTimeOpen = !isEndTimeOpen

            //bg
            binding.addEndTimeBg.visibility = View.GONE
            binding.addEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //데이트피커 열려있으면 닫기
        if(isDateOpen){
            if (isStartDate){
                binding.addStartDateBg.visibility = View.GONE
                binding.addStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.addEndDateBg.visibility = View.GONE
                binding.addEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
            isStartDate = !isStartDate
            if (isDateWasOpen){
                isDateWasOpen = true
            }
            Log.d("DateData","close isDateWasOpen : $isDateWasOpen")
            binding.addDatepickerDp.visibility = View.GONE
        }
        //데이트피커 닫혀있으면 열기
        else{
            binding.addDatepickerDp.visibility = View.VISIBLE
            Log.d("DateData","open isDateWasOpen : $isDateWasOpen")
            if (isStartDate){
                startDateData()
                //bg
                binding.addStartDateBg.visibility = View.VISIBLE
                binding.addStartDateTv.setTextColor(resources.getColor(R.color.white))
            } else {
                if (!isDateWasOpen) {
                    isDateWasOpen = true
                }
                endDateData()
                //bg
                binding.addEndDateBg.visibility = View.VISIBLE
                binding.addEndDateTv.setTextColor(resources.getColor(R.color.white))
            }
        }

        isDateOpen = !isDateOpen
    }

    private fun startDateData(){
        val datePicker = binding.addDatepickerDp
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

            binding.addStartDateTv.text = select
            if(!isDateWasOpen){
                selectEndDay.set(year, month, date)
                binding.addEndDateTv.text = select
                endDay = day.format(sendDateFormatter)
                endLocalDate = day
            }
            Log.d("DateData","startDateData isDateWasOpen : $isDateWasOpen")
            Log.d("DateData","startDateData endStartDate : $selectEndDay")
        }
    }

    private fun endDateData(){
        Log.d("DateData","endDateData")
        val datePicker = binding.addDatepickerDp

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

            binding.addEndDateTv.text = select
        }
    }

    private fun startTimeData(){
        val timePicker = binding.addStartTimepickerTp
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

            binding.addStartTimeTv.text = select
        }
    }

    private fun endTimeData(){
        val timePicker = binding.addEndTimepickerTp
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

            binding.addEndTimeTv.text = select
        }
    }

    private fun getSendDate(){

        startDate = startDay + " " + startTime
        endDate = endDay + " " + endTime

        Log.d("SEND_DATE", "startDate : " + startDate)
        Log.d("SEND_DATE", "endDate : " + endDate)
    }

    private fun finishActivity() {
        activity?.finish()
    }
}

