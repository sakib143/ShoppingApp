package com.example.shopingapp.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopingapp.R
import com.example.shopingapp.data.db.table.CartData
import com.example.shopingapp.data.model.MainCategoryModel
import com.example.shopingapp.data.model.ProductDetailsModel
import com.example.shopingapp.data.model.SubCategoryModel
import com.example.shopingapp.ui.cart.CartFragment
import com.example.shopingapp.ui.cart.CartListAdapter
import com.example.shopingapp.ui.details.ProductDetailsAdapter
import com.example.shopingapp.ui.details.ProductDetailsFragment
import com.example.shopingapp.ui.home.fragment.HomeFragment
import com.example.shopingapp.ui.home.fragment.MainCategoryAdapter
import com.example.shopingapp.ui.subcategory.SubCategoryAdapter
import com.example.shopingapp.ui.subcategory.SubCategoryFragment
import com.example.shopingapp.utils.LogM
import com.example.shopingapp.utils.setDivider


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
fun bindMainCategory(
    view: RecyclerView,
    list: List<MainCategoryModel.Data>?,
    fragment: HomeFragment?,
) {
    if (list != null) {
        var adapter: MainCategoryAdapter? = view.adapter as? MainCategoryAdapter
        if (adapter == null) {
            adapter = MainCategoryAdapter(view.context, list.toMutableList(), fragment!!)
            view.adapter = adapter
        }
        adapter.updateList(list)
    }
}

@BindingAdapter("bindSubCategory", "subcategoryListner", requireAll = false)
fun bindSubCategory(
    view: RecyclerView,
    list: List<SubCategoryModel.Data>?,
    fragment: SubCategoryFragment?,
) {
    if (list != null) {
        var adapter: SubCategoryAdapter? = view.adapter as? SubCategoryAdapter
        if (adapter == null) {
            adapter = SubCategoryAdapter(view.context, list.toMutableList(), fragment!!)
            view.adapter = adapter
        }
        adapter.updateList(list)
    }
}


@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(view: ImageView, url: String?) {
    if (url != null) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}

@BindingAdapter(value = arrayOf("bindProductDetails", "bindProductDetailsListner"), requireAll = false)
fun bindProductDetails(
    view: RecyclerView,
    list: List<ProductDetailsModel.Data>?,
    fragment: ProductDetailsFragment?
) {
    val layoutManager = view.layoutManager
    if (layoutManager == null)
     view.layoutManager = LinearLayoutManager(view.context)
    //   view.layoutManager = GridLayoutManager(view.context,2)
    var adapter  = list?.let { fragment?.let { it1 -> ProductDetailsAdapter(view.context, it, it1) } }
    view.adapter = adapter
}

@BindingAdapter(value= arrayOf("bindgNamazList", "bindMainListner"), requireAll=false )
fun bindNamazList(view: RecyclerView, list: List<CartData>?, fragment: CartFragment?) {
    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)
    var adapter = view.adapter

    if (adapter == null) {
        adapter = list?.let { fragment?.let { it1 -> CartListAdapter(view.context, it, it1) } }
        view.adapter = adapter
    }else{
        LogM.e("==>else is call")

    }
}


 /*//is wokeing
@BindingAdapter("bindMominList")
fun bindMominList(view: RecyclerView, list: List<CartData>) {
    view.setDivider(R.drawable.recyclerview_divider)
    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)
    var adapter = view.adapter
    adapter = CartListAdapter(view.context, list)
    view.adapter = adapter
}*/

/*
@BindingAdapter("bindmoqlist")
fun bindmoqlist(view: RecyclerView, list: List<ProductDetailsModel>?) {
    if(list != null) {
        var adapter = view.adapter
        adapter = CartAdapter(view.context, list)
        view.adapter = adapter
    }
}*/
