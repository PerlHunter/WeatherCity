package com.example.weathercity

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weathercity.fragments.API_KEY

class RequestWeather(val context: Context?) {

    fun requestWeatherData(nameCity: String) {
        val url =
            "http://api.weatherapi.com/v1/forecast.json?key="+
                    API_KEY +
                    "&q=" +
                    nameCity +
                    "&days=1&aqi=no&alerts=no"
        val queue = Volley.newRequestQueue(context)
        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                    result -> ParsingWeatherData().parseWeatherData(result)
            },
            {
                    error -> Log.d("MyLog", "Result: $error")
            }
        )
        queue.add(request)
    }
}