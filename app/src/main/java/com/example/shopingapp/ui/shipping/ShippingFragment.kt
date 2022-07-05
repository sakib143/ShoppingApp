package com.example.shopingapp.ui.shipping

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.databinding.FragmentShippingBinding
import javax.inject.Inject

class ShippingFragment : BaseBindingFragment<FragmentShippingBinding>() {

    @Inject
    lateinit var viewmodel: ShippingViewModel

    override fun layoutId(): Int = R.layout.fragment_shipping


    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentShippingBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
    }

}