package com.example.shopingapp.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.data.db.table.CartData
import com.example.shopingapp.databinding.FragmentMyCartBinding
import com.example.shopingapp.listner.CartListner
import com.example.shopingapp.ui.payment.PaymentActivity
import com.example.shopingapp.utils.LogM
import com.example.shopingapp.utils.logException
import com.google.android.material.dialog.MaterialDialogs
import javax.inject.Inject

class CartFragment : BaseBindingFragment<FragmentMyCartBinding>(),CartListner{

    override fun layoutId(): Int = R.layout.fragment_my_cart

    @Inject
    lateinit var viewmodel: CartViewModel
    private var binding: FragmentMyCartBinding? = null

    private var alCart: java.util.ArrayList<CartData> = ArrayList()
    private var navController: NavController? = null
//    private val args: CartFragmentArgs by navArgs()

    override fun initializeBinding(binding: FragmentMyCartBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        this.binding = binding
        binding.alCartItem = alCart
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        setObservable()

    }

    private fun setObservable() {
        viewmodel.cartList.observe(requireActivity(), cartListObserver)
    }

    private val cartListObserver = Observer<List<CartData>> {
        alCart.clear()
        alCart.addAll(it)
        binding?.alCartItem = alCart
        binding?.listner = this
        LogM.e("alCart:"+alCart.size)

        //Set no data found
        if(alCart?.size == 0) {
            viewmodel.setNoDataFound(false)
        } else {
            viewmodel.setNoDataFound(true)
        }
    }


    fun openPaymentScreen(){
        //requireActivity().toast("Your order is successfully add")
        val myIntent = Intent(activity, PaymentActivity::class.java)
        startActivity(myIntent)
    }

    override fun deletfromcart(model: CartData) {
        LogM.e("==>delet your item"+model.id)
        viewmodel.callDeleteCart(model.id)

    }

    /*fun openShippingScreen() {
        val action = CartFragmentDirections.actionCartFragmentToShippingFragment()
        navController?.navigate(action)
    }*/
}