package com.example.namo.Floating.Todo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.namo.Floating.Schedule.AddActivity
import com.example.namo.R
import com.example.namo.Bottom.Todo.CategoryTodoFragment
import com.example.namo.Data.Todo.*
import com.example.namo.databinding.FragmentNewTodoBinding
import com.kakao.sdk.auth.AuthApiClient
import java.text.SimpleDateFormat
import java.util.*

class NewTodoFragment : Fragment(), TodoView {
    lateinit var binding: FragmentNewTodoBinding

    private var access : String = ""
    private var refresh : String = ""

    private var isDateOpen : Boolean = false
    private var isTimeOpen : Boolean = false

    lateinit var todo : Todo
    lateinit var editTodo : EditTodo

    private var name : String = ""
    private var categoryIdx : Int = 0
    private var deadLine : String = ""
    private var memo : String = ""
    private var complete : Boolean = false

    private var endDate = ""
    private var endTime = ""

    private var todoTitle = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTodoBinding.inflate(inflater, container, false)

        initText()
        getToken()

        val pref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        binding.addTodoCategoryLayout.setOnClickListener {
            todoTitle = binding.addTodoTitleEt.text.toString()
            editor.putString("TodoTitle", todoTitle).apply()
            (context as AddTodoActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.add_todo_frm, CategoryTodoFragment())
                .commitAllowingStateLoss()
        }

        binding.addTodoCloseTv.setOnClickListener {
            activity?.finish()
        }

        binding.addTodoEndDateTv.setOnClickListener {
            datePicker()
        }

        binding.addTodoEndTimeTv.setOnClickListener {
            timePicker()
        }

        binding.addTodoAlarmLayout.setOnClickListener {
            name = binding.addTodoTitleEt.text.toString()
            deadLine = endDate
            editTodo = EditTodo(2, name, categoryIdx, deadLine, memo, complete)
            editTodoData()

        }

        binding.addTodoSaveTv.setOnClickListener {
            if(binding.addTodoTitleEt.text.toString().isEmpty()){
                Toast.makeText(context as AddActivity, "할 일 이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{
                name = binding.addTodoTitleEt.text.toString()
                deadLine = endDate
                todo = Todo(name, categoryIdx, deadLine, memo, complete)
                getTodoData()
                activity?.finish()
            }
            //데이터 저장하기
        }


        return binding.root
    }

    private fun getTodoData(){
        val todoService = TodoService()
        todoService.setTodoView(this)
        todoService.getTodo(access, refresh, todo)
        Log.d("GET_TODO_DATA",access)
        Log.d("GET_TODO_DATA",refresh)
        Log.d("GET_TODO_DATA",todo.toString())
    }

    private fun editTodoData(){
        val todoService = TodoService()
        todoService.setTodoView(this)
        todoService.editTodo(access, refresh, editTodo)
    }

    override fun onStart() {
        super.onStart()

        val spf = requireActivity().getSharedPreferences("TodoCategory", Context.MODE_PRIVATE)
        val categoryJson = spf.getString("todoCategoryJson", null)

        if (categoryJson != null){
            binding.addTodoCategoryContentNameTv.setText(spf.getString("todoCategory",""))
            binding.addTodoCategoryContentColorCiv.setImageResource(spf.getInt("todoColor", R.color.schedule))
            categoryIdx = spf.getInt("todoPosition", 0)
            Log.d("TODO-CATEGORY", "${spf.getString("todoCategory","")}, ${spf.getInt("todoColor", R.color.schedule)}, ${spf.getInt("todoPosition",0)}")
            spf.edit().clear().commit()
            Log.d("TODO-CATEGORY2", "${spf.getString("todoCategory","")}, ${spf.getInt("todoColor", R.color.schedule)}, ${spf.getInt("todoPosition",0)}")
        }

        val pref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        todoTitle = pref.getString("TodoTitle","")!!
        editor.remove("TodoTitle").apply()

        binding.addTodoTitleEt.setText(todoTitle)
        todoTitle = ""
        //이거 날짜랑 시간도 해줘야됨!

    }

    private fun getToken(){

        val spf = activity?.getSharedPreferences("prefs", Activity.MODE_PRIVATE)

        if (AuthApiClient.instance.hasToken()) {  //발급받은 카카오 토큰이 있는 지 확인
            Log.d("TOKEN", "Kakao")
            access = spf!!.getString("accessToken","")!!
            refresh = spf!!.getString("refreshToken","")!!
        }
        else { //발급받은 토큰이 없으면 네이버
            Log.d("TOKEN", "Naver")
            access = spf!!.getString("accessToken2","")!!
            refresh = spf!!.getString("refreshToken2","")!!
        }


        Log.d("TOKEN-ACC",access)
        Log.d("TOKEN-REF",refresh)

    }

    private fun initText(){

        binding.addTodoTitleEt.setText("")

        val today = Calendar.getInstance()
        val year =today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH) + 1
        val date = today.get(Calendar.DAY_OF_MONTH)

        val simpledateformat = SimpleDateFormat("EEEE")
        val day = Date(year, month - 1, date - 1)
        var dayOfWeek = simpledateformat.format(day)
        when(dayOfWeek){
            "Monday" -> dayOfWeek = "월"
            "Tuesday" -> dayOfWeek = "화"
            "Wednesday" -> dayOfWeek = "수"
            "Thursday" -> dayOfWeek = "목"
            "Friday" -> dayOfWeek = "금"
            "Saturday" -> dayOfWeek = "토"
            "Sunday" -> dayOfWeek = "일"
        }

        val monthString = if(month<10) "0" + month else month
        val dateString = if(date<10) "0"+date else date

        binding.addTodoEndDateTv.text = "$year.$monthString.$dateString ($dayOfWeek)"
        endDate = "$year$monthString$dateString"

        //timePicker
        var hour = today.get(Calendar.HOUR_OF_DAY)
        var min = today.get(Calendar.MINUTE)
        var am_pm = ""

        when {hour == 0 -> { hour += 12
            am_pm = "AM"
        }
            hour == 12 -> am_pm = "PM"
            hour > 12 -> {hour -= 12
                am_pm = "PM"
            }
            else -> am_pm = "AM"
        }
        var hourStr =  if(hour < 10) "0" + hour else hour
        var minStr = if(min < 10) "0" + min else min

        binding.addTodoEndTimeTv.text = "$hourStr : $minStr $am_pm"
        endTime = "$hourStr$minStr $am_pm"

    }

    private fun timePicker(){
        if(isDateOpen){
            binding.addTodoDatepickerDp.visibility = View.GONE
            isDateOpen = !isDateOpen
        }

        if(isTimeOpen){
            binding.addTodoTimepickerTp.visibility = View.GONE
        }
        else{
            binding.addTodoTimepickerTp.visibility = View.VISIBLE
            timeData()
        }
        isTimeOpen = !isTimeOpen
    }

    private fun datePicker(){
        if(isTimeOpen){
            binding.addTodoTimepickerTp.visibility = View.GONE
            isTimeOpen = !isTimeOpen
        }

        //데이트피커 열려있으면 닫기
        if(isDateOpen){
            binding.addTodoDatepickerDp.visibility = View.GONE
        }
        //데이트피커 닫혀있으면 열기
        else{
            binding.addTodoDatepickerDp.visibility = View.VISIBLE
            dateData()
        }
        isDateOpen = !isDateOpen
    }

    private fun dateData(){
        val dataPicker = binding.addTodoDatepickerDp
        val today = Calendar.getInstance()
        dataPicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
        ){
            view, year, month, date ->
                val month = month + 1

                val simpledateformat = SimpleDateFormat("EEEE")
                val day = Date(year, month - 1, date - 1)
                var dayOfWeek = simpledateformat.format(day)
                when(dayOfWeek){
                    "Monday" -> dayOfWeek = "월"
                    "Tuesday" -> dayOfWeek = "화"
                    "Wednesday" -> dayOfWeek = "수"
                    "Thursday" -> dayOfWeek = "목"
                    "Friday" -> dayOfWeek = "금"
                    "Saturday" -> dayOfWeek = "토"
                    "Sunday" -> dayOfWeek = "일"
                }

                val monthString = if(month<10) "0" + month else month
                val dateString = if(date<10) "0"+date else date

                binding.addTodoEndDateTv.text = "$year.$monthString.$dateString ($dayOfWeek)"
                endDate = "$year-$monthString-$dateString"
        }
    }

    private fun timeData(){
        val timePicker = binding.addTodoTimepickerTp
        timePicker.setOnTimeChangedListener{_,hour, minute -> var hour = hour
            var am_pm = ""

            when {hour == 0 -> { hour += 12
                am_pm = "AM"
            }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }

            val h = if(hour < 10) "0" + hour else hour
            val min = if(minute < 10) "0" + minute else minute

            binding.addTodoEndTimeTv.text = "$h : $min $am_pm"
            endTime = "${hour} : ${min}"
        }
    }

    override fun onInputTodoSuccess(code: Int, result: TodoResult) {
        when(code){
            1000 ->{
                Log.d("ONINPUT_TODO_SUCCESS","SUCCESS, result : ${result.todoIdx}")
            }
        }
    }

    override fun onEditTodoSuccess(code: Int, result: Int) {
        TODO("Not yet implemented")
    }

    override fun onDeleteTodoSuccess(code: Int, result: String) {
        TODO("Not yet implemented")
    }

    override fun onGetDayTodoSuccess(code: Int, result: List<DayTodoResult>) {
        TODO("Not yet implemented")
    }

    override fun onGetMonthTodoSuccess(code: Int, result: List<DayTodoResult>) {
        TODO("Not yet implemented")
    }

    override fun onGetCategoryTodoSuccess(code: Int, result: List<GetTodoRes>) {
        TODO("Not yet implemented")
    }
}