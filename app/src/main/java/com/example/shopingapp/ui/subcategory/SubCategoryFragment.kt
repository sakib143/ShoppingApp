package com.example.shopingapp.ui.subcategory

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.data.model.SubCategoryModel
import com.example.shopingapp.databinding.FragmentSubCategoryBinding
import com.example.shopingapp.listner.SubCategoryListner
import javax.inject.Inject

class SubCategoryFragment : BaseBindingFragment<FragmentSubCategoryBinding>(),SubCategoryListner {

    @Inject
    lateinit var viewmodel: SubCategoryViewModel

    override fun layoutId(): Int = R.layout.fragment_sub_category

    private val args: SubCategoryFragmentArgs by navArgs()

    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentSubCategoryBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        val categoryId : String = args.categoryCode
        viewmodel.callSubCategory(categoryId)
    }
    override fun openSubCategory(model: SubCategoryModel.Data) {
        val action = SubCategoryFragmentDirections.actionSubCategoryFragmentToProductDetailsFragment(model.itemCategoryCode,model.itemCategoryName)
        navController?.navigate(action)
    }
}