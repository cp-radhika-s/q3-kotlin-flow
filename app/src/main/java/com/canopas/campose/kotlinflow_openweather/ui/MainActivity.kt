package com.canopas.campose.kotlinflow_openweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.canopas.campose.kotlinflow_openweather.R
import com.canopas.campose.kotlinflow_openweather.databinding.ActivityMainBinding
import com.canopas.campose.kotlinflow_openweather.utils.AppUtils.getWeatherAnimation
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val adapter = WeatherDayAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            viewModel.loadCurrentWeather("India")
        }
        initView()
        initObserver()
    }

    private fun initView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val query = query ?: return false
                requestWeather(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        requestWeather("Landon")

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun requestWeather(query: String) {
        viewModel.loadCurrentWeather(query)
        viewModel.getFiveDaysHourlyWeather(query)
    }

    private fun initObserver() {
        viewModel.currentWeather.observe(this, Observer { currentWeather ->
            binding.cityName.text = "Current Weather of ${currentWeather.name}"
            binding.tempTextView.setText(
                String.format(
                    Locale.getDefault(),
                    "%.0f°",
                    currentWeather.getTemp()
                )
            )
            binding.descriptionTextView.setText(currentWeather.getWeatherId().toString())
            binding.humidityTextView.setText(
                String.format(
                    Locale.getDefault(),
                    "%d%%",
                    currentWeather.getHumidity()
                )
            )
            binding.windTextView.setText(
                String.format(
                    Locale.getDefault(),
                    resources.getString(R.string.wind_unit_label),
                    currentWeather.getWindSpeed()
                )
            )
            binding.animationView.setAnimation(getWeatherAnimation(currentWeather.getWeatherId()))
            binding.animationView.playAnimation()
        })

        viewModel.fiveDayHourlyWeather.observe(this, Observer {
            adapter.setItems(it.list)
        })

        viewModel.showError.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}