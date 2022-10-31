package com.example.shopingapp.ui.details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.data.model.ProductDetailsModel
import com.example.shopingapp.databinding.FragmentProductDetailsBinding
import com.example.shopingapp.listner.ProductDetailsListner
import com.example.shopingapp.utils.Constant
import com.example.shopingapp.utils.LogM
import com.example.shopingapp.utils.toast
import com.google.android.gms.common.config.GservicesValue.value
import com.google.gson.Gson

import javax.inject.Inject

class ProductDetailsFragment  : BaseBindingFragment<FragmentProductDetailsBinding>() ,
    ProductDetailsListner {

    @Inject
    lateinit var viewModel: ProductDetailsViewModel
    override fun layoutId(): Int = R.layout.fragment_product_details

    private var navController: NavController? = null
    private val args: ProductDetailsFragmentArgs by navArgs()

    private var alProductDetails: ArrayList<ProductDetailsModel.Data>? = ArrayList()
    private var binding: FragmentProductDetailsBinding? = null
    private var strCategorycode = ""
    private var name = ""

    override fun initializeBinding(binding: FragmentProductDetailsBinding) {
        this.binding = binding
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listner = this
        binding.alProductDetails = alProductDetails
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        strCategorycode = args.itemCategoryCode
        name = args.name
        setObservable()

        //Make API call
        if (globalMethods.isInternetAvailable(requireActivity())) {
            viewModel.executeProductList(strCategorycode)
        } else {
            requireActivity().toast(Constant.CHECK_INTERNET)
        }
    }

    private fun setObservable() {
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)
        viewModel.productDetails.observe(viewLifecycleOwner,productDetailsObserver)
    }

    private val productDetailsObserver = Observer<ProductDetailsModel> {
        alProductDetails = ArrayList()
        alProductDetails!!.addAll(it!!.data)
        binding?.alProductDetails = alProductDetails

        //Set no data found
        if(alProductDetails?.size == 0) {
            viewModel.setNoDataFound(false)
        } else {

            viewModel.setNoDataFound(true)
        }
    }


    override fun openProductDetails(model: ProductDetailsModel.Data) {
        LogM.e("==> model data check: "+model.name +model.brandName)

        val action = ProductDetailsFragmentDirections.actionProductDetailsFragmentToFullProductsDetailsFragment(
                 model.minSellQuantity.toString(),
                model.defaultWholeSaleRate,
                model.itemid,
                model.name,
                model.brandName,
                model.imageName
            )
        navController?.navigate(action)
    }

    private val onMessageErrorObserver = Observer<Any> {
        activity?.toast(it.toString())
    }



}