package com.example.lesson7.presenter

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lesson7.R
import com.example.lesson7.appComponent
import com.example.lesson7.databinding.FragmentMainBinding
import com.example.lesson7.di.viewModel.ViewModeFactory
import dev.androidbroadcast.vbpd.viewBinding
import javax.inject.Inject
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson7.data.ColorParser
import com.example.lesson7.data.model.ColorInfo

class MainFragment: Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val adapter = ColorsAdapter(
        ::onColorItemClick
    )

    @Inject
    lateinit var viewModelFactory: ViewModeFactory

    private val viewModel: MainViewModel by viewModels{viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.colorsRecycler) {
            adapter = this@MainFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }

        //State
        binding.lampToggle.setOnClickListener {
            viewModel.toggleLamp()
        }

        //Brightness
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                viewModel.setBrightness(seekBar?.progress ?: 0)
            }
        })


        viewModel.lampState.observe(viewLifecycleOwner) {
            updateLampState(it)
        }

        viewModel.colorsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.currentColor.observe(viewLifecycleOwner) {
            if (it != null) {
                changeLampColor()
            }
        }

        viewModel.brightnessLevels.observe(viewLifecycleOwner) {
            binding.seekBar.min = it.min
            binding.seekBar.max = it.max
        }
        viewModel.currentBrightness.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.seekBar.progress = it
                changeLampColor()
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    fun onColorItemClick(colorInfo: ColorInfo) {
        viewModel.setColor(colorInfo.color)
    }

    fun updateLampState(mode: Boolean?) {
        if (mode == true) {
            binding.lampToggle.setColorFilter(Color.BLACK)
            changeLampColor()
        }
        else {
            binding.lampToggle.setColorFilter(Color.WHITE)
            binding.lampToggle.background.setTint(Color.BLACK)
        }
    }

    fun changeLampColor() {
        val color = ColorParser.parseColor(
            viewModel.currentColor.value?.color ?: "white",
            viewModel.currentBrightness.value ?: 100
        )

        binding.lampToggle.background.setTint(color)
    }

    override fun onAttach(context: Context) {
        val component = context.appComponent
        component.inject(this)
        super.onAttach(context)
    }
}