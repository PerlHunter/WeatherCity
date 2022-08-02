package com.example.weathercity.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.weathercity.MainViewModel
import com.example.weathercity.RequestWeather
import com.example.weathercity.databinding.FragmentMainBinding
import com.example.weathercity.extends.isPermissionGranted

const val API_KEY = "8c0085ce49ee4ee2b0e74114221607"

class MainFragment : Fragment() {
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding
    private lateinit var request: RequestWeather

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        request = RequestWeather(super.getContext())
        request.requestWeatherData("Lviv")
    }



    private fun permissionListener(){
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermission(){
        if(!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionListener()
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}