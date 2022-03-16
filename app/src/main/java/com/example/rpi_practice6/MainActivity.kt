package com.example.rpi_practice6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rpi_practice6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RandomNumberViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val provider = ViewModelProvider(this)
        viewModel = provider.get(RandomNumberViewModel::class.java)
        initView()
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.currentRandomNumber.observe(this, Observer {
            binding.rndNum?.setText(it.toString())
        })
    }

    fun initView() {
        binding.getRnd?.setOnClickListener {
            viewModel.generateRandomNumber()
        }
    }
}