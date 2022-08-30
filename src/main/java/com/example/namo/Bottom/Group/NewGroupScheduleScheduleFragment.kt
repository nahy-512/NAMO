package com.example.namo.Bottom.Group

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
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
import com.example.namo.Data.Group.*
import com.example.namo.Data.Schedule.*
import com.example.namo.Floating.Schedule.PlaceSearchActivity
import com.example.namo.R
import com.example.namo.databinding.FragmentNewGroupScheduleBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.android.synthetic.main.item_diary_list.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import okhttp3.internal.format
import org.threeten.bp.Duration
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter

class NewGroupScheduleScheduleFragment : Fragment(), GroupScheduleView {

    lateinit var binding : FragmentNewGroupScheduleBinding

    private var gson : Gson = Gson()
    lateinit var contextActivity : Context

    private var isDateOpen : Boolean = false
    private var isStartTimeOpen : Boolean = false
    private var isEndTimeOpen : Boolean = false
    private var isStartDate : Boolean = true
    private var isDateWasOpen : Boolean = false

    lateinit var schedule : NewGroupSchedule

    private var access : String = ""
    private var refresh : String = ""

    private var memberNames : ArrayList<String> = arrayListOf()

    private var alert : String? = null

    private var startDay : String = ""
    private var endDay : String = ""
    private var startTime : String = ""
    private var endTime : String = ""

    lateinit var mapView: MapView
    var mapViewContainer: RelativeLayout? = null

    private var members : ArrayList<Int> = arrayListOf()
    private var name : String = ""
    private var startDate : String = ""
    private var endDate : String = ""
    private var location : String = ""
    private var locationX : String = ""
    private var locationY : String = ""
    private var moimIdx : Int = -1

    private var x:Double = 0.0
    private var y:Double = 0.0
    private var place:String = ""
    private var id : String = ""

    private var moimPeople = ArrayList<moimAttendences>()

    var selectStartDay : Calendar = Calendar.getInstance()
    var selectEndDay : Calendar = Calendar.getInstance()

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)")
    private val sendDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val timeFormatter = DateTimeFormatter.ofPattern("hh : mm a")
    private val sendTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    var startHourWasSelected : Boolean = false
    var endHourWasSelected : Boolean = false
    var selectStartHour : Int = 0
    var selectEndHour : Int = 0
    var selectStartMin : Int = 0
    var selectEndMin : Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewGroupScheduleBinding.inflate(inflater, container, false)

        initText()
        editText()

        initMapView()
        binding.newGroupMapView.visibility = View.GONE
        mapViewContainer?.visibility = View.GONE

        getToken()
        getGroupInfo()

        clickEvent()

        setAlert()

        finishActivity()

        return binding.root

    }

    private fun clickEvent(){
        binding.newGroupPlaceLayout.setOnClickListener {
            activity?.let {
                mapViewContainer?.removeView(mapView)
                val intent = Intent(context, PlaceSearchActivity::class.java)
                startActivityForResult(intent, 2)
            }
        }
//
//        binding.newGroupMapOpenKakaomapBtn.setOnClickListener {
//            activity?.let {
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://route?sp=${x},${y}&ep=37.4979502,127.0276368&by=PUBLICTRANSIT"))
//                Log.d("WGS84", "kakaomap://route?sp=${x},${y}&ep=37.4979502,127.0276368&by=PUBLICTRANSIT")
//                startActivity(intent)
//            }
//        }



        val multiItems : Array<String> = Array(memberNames.size){i -> memberNames.get(i)}
        val checkedItems : BooleanArray = BooleanArray(memberNames.size){i -> false}
        var list = ArrayList<String>()

        binding.newGroupPersonLayout.setOnClickListener {
            MaterialAlertDialogBuilder(context as GroupScheduleActivity, R.style.ThemeOverlay_App_MaterialAlertDialog)
                .setTitle("참석자")
                .setNeutralButton("CANCEL"){
                        dialog, which -> Log.d("CHECK_ALERT","$dialog and $which")
                    Log.d("CHECK_ALERT_LIST",members.toString())
                }
                .setPositiveButton("OK"){
                        dialog,which ->
                    Log.d("CHECK_POSITIVE","$dialog and $which")
                    list.clear()
                    var personText : String = ""
                    for (i in 0..(memberNames.size - 1)){
                        if (checkedItems.get(i)) {
                            list.add("${memberNames.get(i)}")
                            personText = personText + memberNames.get(i) + ", "
                            members.add(moimPeople.get(i).userIdx) //memberIdx 추가
                        }
                    }
                    personText = personText.substring(0, personText.length - 2)

                    Log.d("CHECK_LIST", list.toString())
                    Log.d("CHECK_LIST_MEMBERS", members.toString())
                    binding.newGroupPersonContentTv.setText(personText)
                }
                .setMultiChoiceItems(multiItems, checkedItems){
                    dialog, which, checked ->
                    Log.d("CHECK_MULTI","$dialog and $which and $checked")

                }

                .show()
        }

        binding.newGroupStartDateTv.setOnClickListener {
            if (!isStartDate){
                if (isDateOpen) datePicker()
                else isStartDate = true
            }
            datePicker()
        }
        binding.newGroupEndDateTv.setOnClickListener {
            if (isStartDate){
                if (isDateOpen) datePicker()
                else isStartDate = false
            }
            datePicker()
        }

        binding.newGroupStartTimeTv.setOnClickListener {
            startTimePicker()
        }
        binding.newGroupEndTimeTv.setOnClickListener {
            endTimePicker()
        }

        binding.newGroupNewTv.setOnClickListener {
            val intent = Intent(context as GroupScheduleActivity, GroupPayActivity::class.java)
            startActivity(intent)
        }

        binding.newGroupSaveTv.setOnClickListener {
            getSendDate()
            schedule = NewGroupSchedule(members, name, startDate, endDate, location, locationX, location, moimIdx)
            Log.d("GROUP_SCHEDULE", schedule.toString())

            inputGroupScheduleData()
        }

    }

//    여기 맵 주석처리 : 이닛맵뷰, 온 액티비티 리줄트
    private fun initMapView(){
        mapView = MapView(context as GroupScheduleActivity).also {
            mapViewContainer = RelativeLayout(context as GroupScheduleActivity)
            mapViewContainer?.layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
            binding.newGroupMapView.addView(mapViewContainer)
            mapViewContainer?.addView(it)
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("ONACTIVITYRESULT","onresult")

        initMapView()

        if(resultCode == Activity.RESULT_OK){
            x = data?.getDoubleExtra("x",0.0)!!
            y = data?.getDoubleExtra("y",0.0)!!
            place = data?.getStringExtra("name")!!
            id = data?.getStringExtra("id")!!

            location = place
            locationX = x.toString()
            locationY = y.toString()

        }

        if(!(x == 0.0) || !(y == 0.0)){

            binding.newGroupMapView.visibility = View.VISIBLE
            mapViewContainer?.visibility = View.VISIBLE

            var mapPoint = MapPoint.mapPointWithGeoCoord(y,x)
            mapView.setMapCenterPointAndZoomLevel(mapPoint, 1, true)

            binding.newGroupPlaceContentTv.text = place

            var marker = MapPOIItem()
            marker.itemName = place
            marker.tag = 0
            marker.mapPoint = mapPoint
            marker.markerType = MapPOIItem.MarkerType.BluePin
            marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin

            mapView.addPOIItem(marker)

            binding.newGroupMapOpenKakaomapBtn.visibility = View.VISIBLE
        }
    }

    private fun inputGroupScheduleData(){
        val groupService = GroupService()
        groupService.setGroupScheduleView(this)

        groupService.inputGroupSchedule(access, schedule)
        Log.d("INPUT_SCHEDULE_DATA",access)
        Log.d("INPUT_SCHEDULE_DATA",schedule.toString())
    }


    private fun editText(){
        val editText = binding.newGroupTitleEt
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

    private fun getToken(){

        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!

        Log.d("TOKEN-ACC",access)

    }

    private fun getGroupInfo(){
        val spf = requireActivity().getSharedPreferences("Moim", Context.MODE_PRIVATE)
        val editor = spf.edit()

        val groupJson : String = spf.getString("moimAttendences", "")!!
        val listType: Type = object : TypeToken<ArrayList<moimAttendences>>() {}.type
        moimPeople = gson.fromJson(groupJson, listType)

        moimIdx = spf.getInt("moimIdx",-1)

        Log.d("MOIM_INFO", moimPeople.toString())
        Log.d("MOIM_INFO", moimIdx.toString())

        memberNames.clear()
        memberNames.apply {
            for (i in 0..(moimPeople.size-1)){
                add(moimPeople.get(i).username)
            }
        }
        Log.d("MOIM_INFO", "멤버네임 : ${memberNames}")

    }

    private fun setAlert(){
        binding.newGroupAlarmContentTv.setOnClickListener {
            var popupMenu = PopupMenu(context, it)
            popupMenu.menuInflater.inflate(R.menu.alert_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                if (menuItem.itemId === R.id.alert_5_min_ago) {
                    Toast.makeText(activity, "5분 전", Toast.LENGTH_SHORT).show()
                    alert = "5분 전"
//                    startActivity(Intent(activity, newGroupfriendActivity::class.java))
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
                binding.newGroupAlarmContentTv.text = "$alert"
                false
            }
            popupMenu.show()
        }
    }

    private fun initText(){
        //날짜 설정
        var current = LocalDate.now()
        var today = current.format(dateFormatter)
        binding.newGroupStartDateTv.text = today
        binding.newGroupEndDateTv.text = today

        //서버에 보낼 데이터 준비
        var sendDay = current.format(sendDateFormatter)
        startDay = sendDay
        endDay = sendDay

        initTime()
    }

    private fun initTime(){
        //시작시간
        var current = LocalTime.now()
        var time = current.format(timeFormatter)
        binding.newGroupStartTimeTv.text = time
        selectStartHour = current.hour
        selectStartMin = current.minute
        //서버에 보낼 시작시간
        startTime = current.format(sendTimeFormatter)

        //종료시간
        current = current.plusHours(1)
        time = current.format(timeFormatter)
        binding.newGroupEndTimeTv.text = time
        selectEndHour = current.hour
        selectEndMin = current.minute
        //서버에 보낼 종료시간
        endTime = current.format(sendTimeFormatter)
    }

    private fun startTimePicker(){
        if(isDateOpen){
            binding.newGroupDatepickerDp.visibility = View.GONE
            isDateOpen = !isDateOpen
            //bg
            if (isStartDate){
                binding.newGroupStartDateBg.visibility = View.GONE
                binding.newGroupStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.newGroupEndDateBg.visibility = View.GONE
                binding.newGroupEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
        }
        else if(isEndTimeOpen){
            binding.newGroupEndTimepickerTp.visibility = View.GONE
            isEndTimeOpen = !isEndTimeOpen

            //bg
            binding.newGroupEndTimeBg.visibility = View.GONE
            binding.newGroupEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //타임피커가 열려있으면 닫아야 함
        if(isStartTimeOpen){
            binding.newGroupStartTimepickerTp.visibility = View.GONE

            //bg
            binding.newGroupStartTimeBg.visibility = View.GONE
            binding.newGroupStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //닫혀있으면 열어야 함
        else{
            binding.newGroupStartTimepickerTp.visibility = View.VISIBLE
            startTimeData()

            //bg
            binding.newGroupStartTimeBg.visibility = View.VISIBLE
            binding.newGroupStartTimeTv.setTextColor(resources.getColor(R.color.white))
        }
        isStartTimeOpen = !isStartTimeOpen
    }

    private fun endTimePicker(){
        if(isDateOpen){
            binding.newGroupDatepickerDp.visibility = View.GONE
            isDateOpen = !isDateOpen
            //bg
            if (isStartDate){
                binding.newGroupStartDateBg.visibility = View.GONE
                binding.newGroupStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.newGroupEndDateBg.visibility = View.GONE
                binding.newGroupEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
        }
        else if(isStartTimeOpen){
            binding.newGroupStartTimepickerTp.visibility = View.GONE
            isStartTimeOpen = !isStartTimeOpen
            //bg
            binding.newGroupStartTimeBg.visibility = View.GONE
            binding.newGroupStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //타임피커가 열려있으면 닫아야 함
        if(isEndTimeOpen){
            binding.newGroupEndTimepickerTp.visibility = View.GONE
            //bg
            binding.newGroupEndTimeBg.visibility = View.GONE
            binding.newGroupEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        //닫혀있으면 열어야 함
        else{
            binding.newGroupEndTimepickerTp.visibility = View.VISIBLE
            endTimeData()
            //bg
            binding.newGroupEndTimeBg.visibility = View.VISIBLE
            binding.newGroupEndTimeTv.setTextColor(resources.getColor(R.color.white))
        }
        isEndTimeOpen = !isEndTimeOpen
    }

    private fun datePicker(){
        if(isStartTimeOpen){
            binding.newGroupStartTimepickerTp.visibility = View.GONE
            isStartTimeOpen = !isStartTimeOpen
            //bg
            binding.newGroupStartTimeBg.visibility = View.GONE
            binding.newGroupStartTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }
        else if(isEndTimeOpen){
            binding.newGroupEndTimepickerTp.visibility = View.GONE
            isEndTimeOpen = !isEndTimeOpen

            //bg
            binding.newGroupEndTimeBg.visibility = View.GONE
            binding.newGroupEndTimeTv.setTextColor(resources.getColor(R.color.textGray))
        }

        //데이트피커 열려있으면 닫기
        if(isDateOpen){
            if (isStartDate){
                binding.newGroupStartDateBg.visibility = View.GONE
                binding.newGroupStartDateTv.setTextColor(resources.getColor(R.color.textGray))
            } else {
                binding.newGroupEndDateBg.visibility = View.GONE
                binding.newGroupEndDateTv.setTextColor(resources.getColor(R.color.textGray))
            }
            isStartDate = !isStartDate

            if (!isDateWasOpen) {
                isDateWasOpen = true
            }
            Log.d("DateData","close isDateWasOpen : $isDateWasOpen")
            binding.newGroupDatepickerDp.visibility = View.GONE
        }
        //데이트피커 닫혀있으면 열기
        else{
            binding.newGroupDatepickerDp.visibility = View.VISIBLE
            Log.d("DateData","open isDateWasOpen : $isDateWasOpen")
            if (isStartDate){
                startDateData()
                //bg
                binding.newGroupStartDateBg.visibility = View.VISIBLE
                binding.newGroupStartDateTv.setTextColor(resources.getColor(R.color.white))
            } else {
                if (!isDateWasOpen) {
                    isDateWasOpen = true
                }
                endDateData()
                //bg
                binding.newGroupEndDateBg.visibility = View.VISIBLE
                binding.newGroupEndDateTv.setTextColor(resources.getColor(R.color.white))
            }
        }

        isDateOpen = !isDateOpen
    }

    private fun startDateData(){
        val datePicker = binding.newGroupDatepickerDp
        Log.d("DateData","startDateData")

        datePicker.init(
            selectStartDay.get(Calendar.YEAR), selectStartDay.get(Calendar.MONTH), selectStartDay.get(Calendar.DAY_OF_MONTH)
        ){
                view, year, month, date ->

            selectStartDay.set(year, month, date)
            if(!isDateWasOpen){
                selectEndDay.set(year, month, date)
            }

            Log.d("DateData","startDateData isDateWasOpen : $isDateWasOpen")
            Log.d("DateData","startDateData endStartDate : $selectEndDay")

            var day = LocalDate.of(year, month + 1, date)
            val select = day.format(dateFormatter)

            //서버에 보낼 데이터
            startDay = day.format(sendDateFormatter)

//            val msg = "You Selected : " + select
//            Toast.makeText(context as GroupScheduleActivity, msg, Toast.LENGTH_SHORT).show()

            binding.newGroupStartDateTv.text = select
            if(!isDateWasOpen){
                binding.newGroupEndDateTv.text = select
                endDay = day.format(sendDateFormatter)
            }
        }

    }

    private fun endDateData(){
        Log.d("DateData","endDateData")

        val datePicker = binding.newGroupDatepickerDp

        datePicker.init(
            selectEndDay.get(Calendar.YEAR), selectEndDay.get(Calendar.MONTH), selectEndDay.get(Calendar.DAY_OF_MONTH)
        ){
                view, year, month, date ->

            selectEndDay.set(year, month, date)

            var day = LocalDate.of(year, month + 1, date)
            val select = day.format(dateFormatter)

            //서버에 보낼 데이터
            endDay = day.format(sendDateFormatter)

//            val msg = "You Selected : " + select
//            Toast.makeText(context as GroupScheduleActivity, msg, Toast.LENGTH_SHORT).show()

            binding.newGroupEndDateTv.text = select

        }

    }


    private fun startTimeData(){
        val timePicker = binding.newGroupStartTimepickerTp
        if (!startHourWasSelected){
            timePicker.hour = selectStartHour
            timePicker.minute = selectStartMin
        }

        timePicker.setOnTimeChangedListener{ _, hour, minute ->
            selectStartHour = hour
            selectStartMin = minute
            if (!startHourWasSelected) startHourWasSelected = true

            var time = LocalTime.of(hour, minute)
            val formatter = DateTimeFormatter.ofPattern("hh : mm  a")
            var select = time.format(formatter)

            //서버에 보낼 데이터
            val sendFormat = DateTimeFormatter.ofPattern("HH:mm")
            startTime = time.format(sendFormat)

            binding.newGroupStartTimeTv.text = select

        }
    }

    private fun endTimeData(){
        val timePicker = binding.newGroupEndTimepickerTp
        if (!endHourWasSelected){
            timePicker.hour = selectEndHour
            timePicker.minute = selectEndMin
        }

        timePicker.setOnTimeChangedListener{ _, hour, minute -> var hour = hour
            selectEndHour = hour
            selectEndMin = minute
            if (!endHourWasSelected) endHourWasSelected = true

            var time = LocalTime.of(hour, minute)
            val formatter = DateTimeFormatter.ofPattern("hh : mm  a")
            var select = time.format(formatter)

            //서버에 보낼 데이터
            val sendFormat = DateTimeFormatter.ofPattern("HH:mm")
            endTime = time.format(sendFormat)

            binding.newGroupEndTimeTv.text = select

        }
    }

    private fun getSendDate(){

        startDate = startDay + " " + startTime
        endDate = endDay + " " + endTime

        Log.d("SEND_DATE", "startDate : " + startDate)
        Log.d("SEND_DATE", "endDate : " + endDate)
    }

    private fun finishActivity() {
        binding.newGroupCloseTv.setOnClickListener {
            activity?.finish() //뒤로가기
        }
    }

    override fun onInputGroupScheduleSuccess(code: Int, result: GroupScheduleResult) {
        when(code){
            1000 -> {
                Log.d("ONINPUT_GROUP_SCHEDULE_SUCCESS","SUCCESS, result : ${result}")
                Toast.makeText(contextActivity, "모임 일정이 추가되었습니다", Toast.LENGTH_SHORT).show()
                activity?.finish()
            }
        }
    }

    override fun onGetGroupScheduleSuccess(code: Int, result: GetMoimScheduleRes) {
        TODO("Not yet implemented")
    }


}