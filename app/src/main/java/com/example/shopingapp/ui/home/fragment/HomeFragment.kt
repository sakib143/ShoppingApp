package com.example.shopingapp.ui.home.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.data.model.MainCategoryModel
import com.example.shopingapp.databinding.FragmentHomeBinding
import com.example.shopingapp.di.AppInjector.init
import com.example.shopingapp.listner.HomeListner
import javax.inject.Inject
import kotlin.math.abs

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>(), HomeListner {

    @Inject
    lateinit var viewmodel: HomeViewModel

    override fun layoutId(): Int = R.layout.fragment_home

    private var navController: NavController? = null

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: SliderImageAdapter

    override fun initializeBinding(binding: FragmentHomeBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        init()
        //setUpTransformer()
        viewPager2.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable, 2000)
                }
            })
    }

    override fun openSubCategory(model: MainCategoryModel.Data) {
        val action = HomeFragmentDirections.actionHomeFragmentToSubCategoryFragment(model.itemCategoryCode, model.itemCategoryName)
        navController?.navigate(action)
    }

    private fun init() {
        viewPager2 = view?.findViewById(R.id.viewPager2)!!
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.slide1)
        imageList.add(R.drawable.slide2)
        imageList.add(R.drawable.slide3)
        imageList.add(R.drawable.slide4)
        imageList.add(R.drawable.slide5)
        imageList.add(R.drawable.slide6)



        adapter = SliderImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 1
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

}