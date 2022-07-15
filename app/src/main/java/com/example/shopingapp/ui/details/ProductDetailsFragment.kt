package com.example.shopingapp.ui.details

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.databinding.FragmentProductDetailsBinding
import com.example.shopingapp.ui.bag.MyBagsFragmentDirections
import com.example.shopingapp.utils.toast
import javax.inject.Inject

class ProductDetailsFragment : BaseBindingFragment<FragmentProductDetailsBinding>() {

    @Inject
    lateinit var viewmodel: ProductDetailsViewModel

    override fun layoutId(): Int = R.layout.fragment_product_details

    private val args: ProductDetailsFragmentArgs by navArgs()

    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentProductDetailsBinding) {
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

    fun openBuyNow() {
        requireActivity().toast("In progress !!! ")
        val action = ProductDetailsFragmentDirections.actionProductDetailsFragmentToShippingFragment()
        navController?.navigate(action)
    }
}