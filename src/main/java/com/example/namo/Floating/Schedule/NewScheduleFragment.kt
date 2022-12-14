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
//        Log.d("NEW_LIFE","???????????? ????????????")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
//        Log.d("NEW_LIFE","???????????? ?????????????????????")
        binding = FragmentNewScheduleBinding.inflate(inflater, container, false)

        initText()
        editText()

        //?????? ??? ???????????? 3???
        initMapView()
        binding.addMapView.visibility = View.GONE
        mapViewContainer?.visibility = View.GONE

        getToken()

        setAlert() //?????? ??????

        clickEvent()

        return binding.root
    }

    private fun clickEvent(){

        //?????? ??? ???????????? ??? ??????
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
                Toast.makeText(context as AddActivity, "?????? ????????? ??????????????????", Toast.LENGTH_SHORT).show()
            }
            else if (startLocalDate.isAfter(endLocalDate)){
                Toast.makeText(context as AddActivity, "???????????? ??????????????? ????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show()
            }
            else if (startLocalDate.isEqual(endLocalDate) && startLocalTime.isAfter(endLocalTime)){
                Toast.makeText(context as AddActivity, "???????????? ???????????? ?????? ??? ??????????????? ?????????????????? ????????? ????????? ??? ????????????.", Toast.LENGTH_SHORT).show()
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

//        Log.d("NEW_LIFE","???????????? ?????????")
    }

    private fun setDataFromTempSchedule(){
        //??????
        if (!tempSchedule.name.isNullOrEmpty()) {
            name = tempSchedule.name
            binding.addTitleEt.setText(name)
        }
        //????????????
        isDateWasOpen = tempSchedule.isDateWasOpen
        if (!tempSchedule.categoryName.isNullOrEmpty()){
            categoryName = tempSchedule.categoryName
            categoryColor = tempSchedule.categoryColor
            categoryIdx = tempSchedule.categoryIdx
            binding.addCategoryContentNameTv.setText(categoryName)
            binding.addCategoryContentColorCv.setCardBackgroundColor(categoryColor)
        }
        //??????
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
        //??????
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
//        Log.d("NEW_LIFE","???????????? ?????????")
        putPref()
    }


    //?????? ??? ???????????? : ????????????, ??? ???????????? ?????????
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
                    Toast.makeText(activity, "5??? ???", Toast.LENGTH_SHORT).show()
                    alert = "5??? ???"
//                    startActivity(Intent(activity, AddfriendActivity::class.java))
                } else if (menuItem.itemId === R.id.alert_10_min_ago) {
                    Toast.makeText(activity, "10??? ???", Toast.LENGTH_SHORT).show()
                    alert = "10??? ???"
                } else if (menuItem.itemId === R.id.alert_15_min_ago) {
                    Toast.makeText(activity, "15??? ???", Toast.LENGTH_SHORT).show()
                    alert = "15??? ???"
                } else if (menuItem.itemId === R.id.alert_30_min_ago) {
                    Toast.makeText(activity, "30??? ???", Toast.LENGTH_SHORT).show()
                    alert = "30??? ???"
                } else if (menuItem.itemId === R.id.alert_1_hour_ago) {
                    Toast.makeText(activity, "1?????? ???", Toast.LENGTH_SHORT).show()
                    alert = "1?????? ???"
                } else if (menuItem.itemId === R.id.alert_3_hour_ago) {
                    Toast.makeText(activity, "3?????? ???", Toast.LENGTH_SHORT).show()
                    alert = "3?????? ???"
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
                Toast.makeText(contextActivity, "????????? ?????????????????????", Toast.LENGTH_SHORT).show()
//                Toast.makeText(context as AddActivity, "????????? ?????????????????????.", Toast.LENGTH_SHORT).show() ?????? ?????????!
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
        //?????? ??????
        var current = LocalDate.now()
        var today = current.format(dateFormatter)
        binding.addStartDateTv.text = today
        binding.addEndDateTv.text = today

        //????????? ?????? ????????? ??????
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
        //????????? ?????? ????????????
        startTime = current.format(sendTimeFormatter)

        //????????????
        current = current.plusHours(1)
        time = current.format(timeFormatter)
        binding.addEndTimeTv.text = time
        endLocalTime = current // ????????? ?????? ??? ?????? ????????? ??????

        selectEndHour = current.hour
        selectEndMin = current.minute
        //????????? ?????? ????????????
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

        //??????????????? ??????????????? ????????? ???
        if(isStartTimeOpen){
            binding.addStartTimepickerTp.visibility = View.GONE

            //bg
            binding.addStartTimeBg.visibility = View.GONE
            binding.addStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //??????????????? ????????? ???
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

        //??????????????? ??????????????? ????????? ???
        if(isEndTimeOpen){
            binding.addEndTimepickerTp.visibility = View.GONE
            //bg
            binding.addEndTimeBg.visibility = View.GONE
            binding.addEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //??????????????? ????????? ???
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

        //??????????????? ??????????????? ??????
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
        //??????????????? ??????????????? ??????
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
            startLocalDate = day //?????? ??? ??? ????????? ??????
            val select = day.format(dateFormatter)

            //????????? ?????? ?????????
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

            //????????? ?????? ?????????
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

            //????????? ?????? ?????????
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

            //????????? ?????? ?????????
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

