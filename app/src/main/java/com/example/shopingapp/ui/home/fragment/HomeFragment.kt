package com.example.shopingapp.ui.home.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.data.model.MainCategoryModel
import com.example.shopingapp.databinding.FragmentHomeBinding
import com.example.shopingapp.listner.HomeListner
import javax.inject.Inject

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>(), HomeListner {

    @Inject
    lateinit var viewmodel: HomeViewModel

    override fun layoutId(): Int = R.layout.fragment_home

    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentHomeBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
    }

    override fun openSubCategory(model: MainCategoryModel.Data) {
        val action = HomeFragmentDirections.actionHomeFragmentToSubCategoryFragment(model.itemCategoryCode)
        navController?.navigate(action)
    }
}