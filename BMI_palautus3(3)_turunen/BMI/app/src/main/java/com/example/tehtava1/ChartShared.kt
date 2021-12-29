package com.example.tehtava1

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Color.GREEN
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ChartShared : AppCompatActivity() {

    var barChart: BarChart? = null
    var barData: BarData? = null
    var barDataSet: BarDataSet? = null
    var barEntriesArrayList = ArrayList<BarEntry>()
    val spbmi = "bmi"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_shared)

        barChart = findViewById(R.id.idBarChart);
        barEntries();

        barDataSet = BarDataSet(barEntriesArrayList, "BMIs");
        barData = BarData(barDataSet);
        barChart?.setData(barData);
        barDataSet?.setColors(Color.RED);
        barDataSet?.setValueTextColor(Color.BLACK);
        barDataSet?.setValueTextSize(16f);
        barChart?.getDescription()?.setEnabled(false);



    }

    fun barEntries(){
        val sharedpreferences = getSharedPreferences(spbmi,MODE_PRIVATE)
        val gson = Gson()
        barEntriesArrayList = ArrayList<BarEntry>();
        var values : String? = sharedpreferences?.getString(spbmi,"")
        if(values == null || values?.isEmpty()){ return }
        var editor : SharedPreferences.Editor? = sharedpreferences?.edit()
        val itemType = object : TypeToken<ArrayList<String>>() {}.type
        var bmi = arrayListOf<String>()
        bmi = gson.fromJson<ArrayList<String>>(values, itemType)
        var index = 1f
        for (item in bmi){
            barEntriesArrayList.add(BarEntry(index, item.toFloat()));
            index++
        }
    }
}