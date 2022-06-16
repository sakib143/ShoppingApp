package com.example.shopingapp.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopingapp.data.model.MainCategoryModel
import com.example.shopingapp.data.model.SubCategoryModel
import com.example.shopingapp.ui.home.fragment.HomeFragment
import com.example.shopingapp.ui.home.fragment.MainCategoryAdapter
import com.example.shopingapp.ui.subcategory.SubCategoryAdapter
import com.example.shopingapp.ui.subcategory.SubCategoryFragment


/*
Generic way to data binding in recyclerview
 */
//@BindingAdapter("bindScheduleList")
//fun bindRecyclerView(view: RecyclerView, list: List<ScheduleModel.Data>) {
//    view.layoutManager = LinearLayoutManager(view.context)
//    var adapter = view.adapter
//    adapter = ScheduleAdapter(view.context, list)
//    view.adapter = adapter
//}


//Proper way to set recyclerview which used in Best seller.
//if(list != null) {
//    var adapter : ProductListAdapter? = view.adapter as? ProductListAdapter
//    if (adapter == null) {
//        adapter = ProductListAdapter(view.context, list.toMutableList(),fragment!!)
//        view.adapter = adapter
//    }
//    adapter.updateList(list)
//}


@BindingAdapter("bindMainCategory", "homelistner", requireAll = false)
fun bindMainCategory(view: RecyclerView, list: List<MainCategoryModel.Data>?,fragment: HomeFragment?) {
    if(list != null) {
        var adapter : MainCategoryAdapter? = view.adapter as? MainCategoryAdapter
        if(adapter == null){
            adapter = MainCategoryAdapter(view.context, list.toMutableList(),fragment!!)
            view.adapter = adapter
        }
        adapter.updateList(list)
    }
}

@BindingAdapter("bindSubCategory", "subcategoryListner", requireAll = false)
fun bindSubCategory(view: RecyclerView, list: List<SubCategoryModel.Data>?,fragment: SubCategoryFragment?) {
    if(list != null) {
        var adapter : SubCategoryAdapter? = view.adapter as? SubCategoryAdapter
        if(adapter == null){
            adapter = SubCategoryAdapter(view.context, list.toMutableList(),fragment!!)
            view.adapter = adapter
        }
        adapter.updateList(list)
    }
}


@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(view: ImageView, url: String?) {
    if(url != null) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}