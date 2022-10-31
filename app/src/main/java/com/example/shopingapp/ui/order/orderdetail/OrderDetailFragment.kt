package com.example.shopingapp.ui.order.orderdetail

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.databinding.FragmentFullProductDetailsBinding
import com.example.shopingapp.databinding.FragmentOrderdetailBinding

class OrderDetailFragment : BaseBindingFragment<FragmentOrderdetailBinding>() {

    override fun layoutId(): Int = R.layout.fragment_orderdetail
    private var binding: FragmentOrderdetailBinding? = null

    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentOrderdetailBinding) {
        binding.lifecycleOwner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
    }



}