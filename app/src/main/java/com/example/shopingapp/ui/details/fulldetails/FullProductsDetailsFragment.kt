package com.example.shopingapp.ui.details.fulldetails


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.data.model.AddOrderModel
import com.example.shopingapp.databinding.FragmentFullProductDetailsBinding
import com.example.shopingapp.utils.AlertDialogUtility
import com.example.shopingapp.utils.LogM
import com.example.shopingapp.utils.toast
import com.google.gson.Gson
import javax.inject.Inject


class FullProductsDetailsFragment : BaseBindingFragment<FragmentFullProductDetailsBinding>() {
    @Inject
    lateinit var viewModel: FullProductsDetailsViewModel
    private var binding: FragmentFullProductDetailsBinding? = null
    private var navController: NavController? = null

    override fun layoutId(): Int = R.layout.fragment_full_product_details

    private val args: FullProductsDetailsFragmentArgs by navArgs()

    var strMinQty = ""
    var strRate = ""
    var name = ""
    var brandname = ""

      override fun initializeBinding(binding: FragmentFullProductDetailsBinding) {
        this.binding = binding
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()


         strMinQty = args.qty.toString();
         strRate = args.rate.toString()
         name = args.name
         brandname = args.brandname
        LogM.e("==>full product details get all data from details: " +strMinQty)

        viewModel.setRequiredDetails(
             args.qty,
             args.rate.toString(),
             args.itemid,
             args.imageUrl,
             args.brandname,
             args.name)

        setObservable()
    }

    private fun setObservable() {
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)
        viewModel.addOrder.observe(viewLifecycleOwner, addOrdersObserver)

    }



    private val addOrdersObserver = Observer<AddOrderModel> {
        if (it.status) {
            activity?.toast(it!!.message)
            AlertDialogUtility.showSingleAlert(
                activity, it!!.message
            ) { dialog, which ->
                dialog.dismiss()
            }
        } else {
            activity?.toast(it!!.message)
        }
    }

    private val onMessageErrorObserver = Observer<Any> {
        activity?.toast(it.toString())
    }

    fun openCartScreen() {
        viewModel.addCartData()

      val action =
            FullProductsDetailsFragmentDirections.actionFullProductsDetailsFragmentToCartFragment(
           /*   viewModel.minimumQty.value.toString(),
                viewModel.rate.value!!.toInt(),
                viewModel.itemId.value?.toInt()!!,
                viewModel.brandname.value.toString(),
                viewModel.imageUrl.value.toString(),
                viewModel.name.value.toString()*/
            )

        navController?.navigate(action)

    /*LogM.e("==>data detail minimumQty" + viewModel.minimumQty.value.toString())
        LogM.e("==>data detail rate" + viewModel.rate.value)
        LogM.e("==>data detail itemId" + viewModel.itemId.value)
        LogM.e("==>data detail  brandname" + viewModel.brandname.value)
        LogM.e("==>data detail imageUrl" + viewModel.imageUrl.value)
        LogM.e("==>data detail name" + viewModel.name.value)*/


    }
}