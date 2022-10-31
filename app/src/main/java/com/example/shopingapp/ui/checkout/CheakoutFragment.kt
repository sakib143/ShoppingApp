package com.example.shopingapp.ui.checkout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.data.model.ProductDetailsModel
import com.example.shopingapp.databinding.FragmentCheakoutBinding
import com.example.shopingapp.ui.payment.PaymentActivity
import com.example.shopingapp.utils.toast
import javax.inject.Inject

class CheakoutFragment : BaseBindingFragment<FragmentCheakoutBinding>() {

    @Inject
    lateinit var viewmodel: ChekoutViewModel

    override fun layoutId(): Int = R.layout.fragment_cheakout

    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentCheakoutBinding) {
        binding.lifecycleOwner = this
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

    }

    fun openPaymentScreen(){
        //requireActivity().toast("Your order is successfully add")
        val myIntent = Intent(activity, PaymentActivity::class.java)
        startActivity(myIntent)
    }

}