package com.example.shopingapp.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.BR
import com.example.shopingapp.data.model.ProductDetailsModel
import com.example.shopingapp.databinding.AdapterProductDetailsBinding
import com.example.shopingapp.listner.ProductDetailsListner

class ProductDetailsAdapter (
    private val context: Context,
    private val dataList: List<ProductDetailsModel.Data>,
    private val  listner: ProductDetailsFragment
) : RecyclerView.Adapter<ProductDetailsAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding =
            AdapterProductDetailsBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(
            rootView
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val model = dataList[position]

        holder.itemBinding.setVariable(BR.productDetails, model)
        holder.itemBinding.executePendingBindings()
        holder.itemBinding.setVariable(BR.productDetailsListner, listner as ProductDetailsListner)
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemBinding.root)
}