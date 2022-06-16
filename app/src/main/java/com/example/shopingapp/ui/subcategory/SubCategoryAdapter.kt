package com.example.shopingapp.ui.subcategory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.BR
import com.example.shopingapp.data.model.SubCategoryModel
import com.example.shopingapp.databinding.AdapterSubCategoryBinding

class SubCategoryAdapter (
    private val context: Context,
    private val dataList: MutableList<SubCategoryModel.Data>,
    private val  listner: SubCategoryFragment
) : RecyclerView.Adapter<SubCategoryAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding =
            AdapterSubCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(
            rootView
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val model = dataList[position]

        holder.itemBinding.setVariable(BR.subCategory, model)
        holder.itemBinding.executePendingBindings()
//        holder.itemBinding.setVariable(BR.subCategoryListner, listner as SubCategoryListner)
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemBinding.root)

    fun updateList(list: List<SubCategoryModel.Data>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}