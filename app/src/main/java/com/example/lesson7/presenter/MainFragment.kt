package com.example.lesson7.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil3.load
import com.example.lesson7.R
import com.example.lesson7.appComponent
import com.example.lesson7.databinding.FragmentMainBinding
import com.example.lesson7.di.DaggerAppComponent
import com.example.lesson7.di.viewModel.ViewModeFactory
import dev.androidbroadcast.vbpd.viewBinding
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModeFactory

    private val viewModel: MainViewModel by viewModels{viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dog.setOnClickListener {
            viewModel.loadNewDog()
        }

        viewModel.dogImageUrl.observe(viewLifecycleOwner) {
            binding.dogImage.load(it)

            Toast.makeText(
                requireContext(),
                it,
                Toast.LENGTH_LONG
            ).show()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        val component = context.appComponent
        component.inject(this)
        super.onAttach(context)
    }
}