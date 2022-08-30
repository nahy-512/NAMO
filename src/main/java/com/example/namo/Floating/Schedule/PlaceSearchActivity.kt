package com.example.namo.Floating.Schedule

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Todo.CategoryScheduleFragment
import com.example.namo.Data.Map.PlaceList
import com.example.namo.Data.Map.KakaoMapAPI
import com.example.namo.Data.ResultSearchKeyword
import com.example.namo.Data.Schedule.TempSchedule
import com.example.namo.databinding.ActivityPlaceSearchBinding
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlaceSearchActivity : AppCompatActivity() {

    private var tempSchedule = TempSchedule()
    companion object {
        const val BASE_URL = "https://dapi.kakao.com/"
        const val API_KEY = "KakaoAK 818de08ab952bb5274fa890b790f338d"

        private const val KEY_PREFS = "tempSchedule"
        private const val KEY_DATA = "tempData"
    }

    lateinit var binding : ActivityPlaceSearchBinding
    private val placeList = arrayListOf<PlaceList>()
    private val placeSearchRVAdapter = PlaceSearchRVAdapter(placeList)
    private var pageNum = 1
    private var keyword = ""

    private var x:Double = 0.0
    private var y:Double = 0.0
    private var name:String = ""
    private var id : String = ""
    private var pos = -1

    lateinit var mapView:MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadPref()

        binding.placeSearchRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.placeSearchRv.adapter = placeSearchRVAdapter

        mapView = MapView(this)
        val mapViewContainer = binding.placeSearchMapView as ViewGroup
        mapViewContainer.addView(mapView)

        placeSearchRVAdapter.setItemClickListener(object :
            PlaceSearchRVAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                pos = position
                val mapPoint = MapPoint.mapPointWithGeoCoord(placeList[position].y, placeList[position].x)
                mapView.setMapCenterPointAndZoomLevel(mapPoint, 1, true)

                val h = (binding.placeSearchMapView.height * 1.5).toInt()
                binding.placeSearchMapView.layoutParams.height = h

                binding.placeSelectBtnLayout.visibility = View.VISIBLE

            }
        })

        binding.placeSelectBtn.setOnClickListener {

            tempSchedule.x = placeList[pos].x
            tempSchedule.y = placeList[pos].y
            tempSchedule.place = placeList[pos].name

            putPref()

            x = placeList[pos].x
            y = placeList[pos].y
            name = placeList[pos].name
            id = placeList[pos].id

            intent.putExtra("x",x)
            intent.putExtra("y",y)
            intent.putExtra("name",name)
            intent.putExtra("id",id)
            setResult(RESULT_OK, intent)

            finish()
        }

        binding.placeSearchBtn.setOnClickListener {
            keyword = binding.placeSearchEt.text.toString()
            pageNum = 1
            searchKeyword(keyword, pageNum)
        }

        binding.placeSearchPrevPage.setOnClickListener {
            pageNum--
            binding.placeSearchPageNum.text = pageNum.toString()
            searchKeyword(keyword, pageNum)
        }

        binding.placeSearchNextPage.setOnClickListener {
            pageNum++
            binding.placeSearchPageNum.text = pageNum.toString()
            searchKeyword(keyword, pageNum)
        }
    }

    override fun finish() {
        binding.placeSearchMapView.removeView(mapView)
        super.finish()
    }


    private fun searchKeyword(keyword:String, page:Int){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(KakaoMapAPI::class.java)
        val call = api.getSearchKeyword(API_KEY, keyword,page)

        call.enqueue(object : Callback<ResultSearchKeyword>{
            override fun onResponse(
                call: Call<ResultSearchKeyword>,
                response: Response<ResultSearchKeyword>
            ) {
                Log.d("Test","Raw : ${response.raw()}")
                Log.d("Test","Body : ${response.body()}")
                addItemsAndMarkers(response.body())
            }

            override fun onFailure(call: Call<ResultSearchKeyword>, t: Throwable) {
                Log.w("LocalSearch","통신 실패 : ${t.message}")
            }
        })
    }

    private fun addItemsAndMarkers(searchResult : ResultSearchKeyword?){
        if(!searchResult?.documents.isNullOrEmpty()){
            placeList.clear()
            mapView.removeAllPOIItems()
            for (document in searchResult!!.documents){
                val item = PlaceList(
                    document.place_name,
                    document.road_address_name,
                    document.address_name,
                    document.x.toDouble(),
                    document.y.toDouble(),
                    document.id
                )
                placeList.add(item)

                val point = MapPOIItem()
                point.apply {
                    itemName = document.place_name
                    mapPoint = MapPoint.mapPointWithGeoCoord(document.y.toDouble(), document.x.toDouble())

                    markerType = MapPOIItem.MarkerType.BluePin
                    selectedMarkerType = MapPOIItem.MarkerType.RedPin
                }
                mapView.addPOIItem(point)
            }
            placeSearchRVAdapter.notifyDataSetChanged()

            binding.placeSearchNextPage.isEnabled = !searchResult.meta.is_end
            binding.placeSearchPrevPage.isEnabled = pageNum !== 1
        } else {
            Toast.makeText(this, "검색 결과가 없습니다", Toast.LENGTH_SHORT).show()
        }
    }


    private fun putPref(){
        val sharedPreferences = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(tempSchedule)
        editor.putString(KEY_DATA, json)
        editor.apply()
        Log.d("PLACE_PREF", tempSchedule.toString())
    }


    private fun loadPref(){
        val sharedPreferences = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        if (sharedPreferences.contains(KEY_DATA)){
            val gson = Gson()
            val json = sharedPreferences.getString(KEY_DATA, "")
            try {
                val typeToken = object : TypeToken<TempSchedule>(){}.type
                tempSchedule = gson.fromJson(json, typeToken)
            } catch (e : JsonParseException){
                e.printStackTrace()
            }
            Log.d("PLACE_PREF", tempSchedule.toString())
        }
        else Log.d("PLACE_PREF", "clear already")
    }
}