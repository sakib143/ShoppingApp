package com.example.shopingapp.ui.bag

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.databinding.FragmentMyBagsBinding
import javax.inject.Inject

class MyBagsFragment : BaseBindingFragment<FragmentMyBagsBinding>() {

    @Inject
    lateinit var viewmodel: MyBagsViewModel

    override fun layoutId(): Int = R.layout.fragment_my_bags

    private var navController: NavController? = null


    override fun initializeBinding(binding: FragmentMyBagsBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
//        val categoryId : String = args.categoryCode
//        viewmodel.callSubCategory(categoryId)
    }

    fun openShippingScreen() {
        val action = MyBagsFragmentDirections.actionBagFragmentToShippingFragment()
        navController?.navigate(action)
    }
}