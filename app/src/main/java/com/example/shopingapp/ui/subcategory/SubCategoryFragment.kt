package com.example.shopingapp.ui.subcategory

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.databinding.FragmentSubCategoryBinding
import javax.inject.Inject

class SubCategoryFragment : BaseBindingFragment<FragmentSubCategoryBinding>() {

    @Inject
    lateinit var viewmodel: SubCategoryViewModel

    override fun layoutId(): Int = R.layout.fragment_sub_category

    private val args: SubCategoryFragmentArgs by navArgs()

    override fun initializeBinding(binding: FragmentSubCategoryBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryId : String = args.categoryCode
        viewmodel.callSubCategory(categoryId)
    }
}