package com.example.datastore

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.datastore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var dataStore:DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        dataStore = DataStoreManager(this)

        checkThemeMode()

        binding.switchMode.setOnCheckedChangeListener { _, isChecked ->
            when(isChecked){
                true -> {
                    viewModel.setTheme(true)
                }
                false ->{
                    viewModel.setTheme(false)
                }
            }
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun checkThemeMode(){
        viewModel.getTheme.observe(this){isDarkMode ->
            when(isDarkMode){
                true -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    binding.switchMode.isChecked = true
                    binding.switchMode.text = "Dark Mode"
                    binding.imgTheme.background =  getDrawable(R.drawable.night)
                }
                false -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    binding.switchMode.isChecked = false
                    binding.switchMode.text = "Light Mode"
                    binding.imgTheme.background =  getDrawable(R.drawable.day)
                }
            }
        }
    }

}