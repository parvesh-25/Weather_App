package com.altaf.weatherapp.data.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.altaf.weatherapp.BuildConfig
import com.altaf.weatherapp.data.ForecastResponse
import com.altaf.weatherapp.data.ListItem
import com.altaf.weatherapp.data.WeatherItem
import com.altaf.weatherapp.data.utils.HelperFunctions.formatterDegree
import com.altaf.weatherapp.data.utils.iconSizeWeather2x
import com.altaf.weatherapp.data.utils.iconSizeWeather4x
import com.altaf.weatherapp.databinding.RowItemWeatherBinding
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.MyViewHolder>() {

    private var listWeather = ArrayList<ListItem>()
    class MyViewHolder (val binding: RowItemWeatherBinding):
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder (
        RowItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listWeather[position]
        holder.binding.apply {
            val maxDegree = "Max: " + formatterDegree(data.main?.tempMax)
            tvMaxDegree.text = maxDegree

            val minDegree = "Min: " + formatterDegree(data.main?.tempMin)
            tvMinDegree.text = minDegree

            // take utk ngambil jumlah huruf dari depan
            val date = data.dtTxt?.take(10)
            // takLast ngitung dari belakang
            val time = data.dtTxt?.takeLast(8)
            val dateArray = date?.split("-")?.toTypedArray()
            val timeArray = time?.split(":")?.toTypedArray()

            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, Integer.parseInt(dateArray?.get(0) as String))
            calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1]) -1)
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[2]))

            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray?.get(0) as String))
            calendar.set(Calendar.MINUTE, 0)

            val dateFormat = SimpleDateFormat("EEE, MMM, d", Locale.getDefault())
                .format(calendar.time).toString()
            val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
                .format(calendar.time).toString()

            tvItemDate.text = dateFormat
            tvItemTime.text = timeFormat

            val icon = data.weather?.get(0)?.icon
            val iconUrl = BuildConfig.ICON_URL + icon + iconSizeWeather2x
            Glide.with(imgItemWeather.context).load(iconUrl).into(imgItemWeather)
        }
    }

    override fun getItemCount() = listWeather.size

    fun setData(data: List<ListItem>?){
        if (data == null) return
        listWeather.clear()
        listWeather.addAll(data)
    }
}