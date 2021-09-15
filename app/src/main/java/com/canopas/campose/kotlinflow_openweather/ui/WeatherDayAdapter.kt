package com.canopas.campose.kotlinflow_openweather.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canopas.campose.kotlinflow_openweather.Constant.DAYS_OF_WEEK
import com.canopas.campose.kotlinflow_openweather.data.fivedayweather.ItemHourly
import com.canopas.campose.kotlinflow_openweather.databinding.WeatherDayItemBinding
import com.canopas.campose.kotlinflow_openweather.utils.AppUtils
import java.util.*

class WeatherDayAdapter : RecyclerView.Adapter<WeatherDayAdapter.WeatherViewHolder>() {

    private val items = mutableListOf<ItemHourly>()

    fun setItems(items: List<ItemHourly>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    class WeatherViewHolder internal constructor(view: View) :
        RecyclerView.ViewHolder(view) {

        var context: Context
        var binding: WeatherDayItemBinding

        fun bindView(item: ItemHourly) {
            val colors = intArrayOf(
                Color.TRANSPARENT,
                1,
                Color.TRANSPARENT
            )
            val calendar = Calendar.getInstance(TimeZone.getDefault())
            calendar.timeInMillis = item.dt * 1000L

            binding.dayNameTextView.text = DAYS_OF_WEEK.get(calendar[Calendar.DAY_OF_WEEK] - 1)+" "+AppUtils.getTime(calendar, context)

            binding.tempTextView.text = String.format(
                Locale.getDefault(),
                "%.0f°",
                item.main?.temp ?: 0.0
            )
            binding.minTempTextView.text = String.format(
                Locale.getDefault(),
                "%.0f°",
                item.main?.tempMin ?: 0.0
            )
            binding.maxTempTextView.text = String.format(
                Locale.getDefault(),
                "%.0f°",
                item.main?.tempMax ?: 0.0
            )
            AppUtils.setWeatherIcon(
                context,
                binding.weatherImageView,
                item.weather?.get(0)?.id ?: 1
            )
        }

        init {
            binding = WeatherDayItemBinding.bind(view)
            context = view.context
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = WeatherDayItemBinding.inflate(LayoutInflater.from(parent.context))
        return WeatherViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}