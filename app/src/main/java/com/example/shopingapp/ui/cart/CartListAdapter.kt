package com.example.shopingapp.ui.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.BR
import com.example.shopingapp.data.db.table.CartData
import com.example.shopingapp.databinding.AdapterCartBinding
import com.example.shopingapp.listner.CartListner

class CartListAdapter   (
    private val context: Context,
    private val dataList: List<CartData>,
    private val  listner: CartFragment
) : RecyclerView.Adapter<CartListAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding = AdapterCartBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val namazData = dataList[position]

        holder.itemBinding.setVariable(BR.mominData, namazData)
        holder.itemBinding.executePendingBindings()
//        //Set Item click listner in Adapte
        holder.itemBinding.setVariable(BR.cartListner, listner as CartListner)
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemBinding.root)


}