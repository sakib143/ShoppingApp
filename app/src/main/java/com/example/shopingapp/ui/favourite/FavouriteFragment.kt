package com.example.shopingapp.ui.favourite

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.databinding.FragmentFavouriteBinding
import javax.inject.Inject

class FavouriteFragment : BaseBindingFragment<FragmentFavouriteBinding>() {

    @Inject
    lateinit var viewmodel: FavouriteViewModel

    override fun layoutId(): Int = R.layout.fragment_favourite


    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentFavouriteBinding) {
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

}