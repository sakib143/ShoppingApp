package com.example.shopingapp.di

import com.example.shopingapp.ui.bag.MyBagsFragment
import com.example.shopingapp.ui.details.ProductDetailsFragment
import com.example.shopingapp.ui.favourite.FavouriteFragment
import com.example.shopingapp.ui.home.HomeActivity
import com.example.shopingapp.ui.home.fragment.HomeFragment
import com.example.shopingapp.ui.shipping.ShippingFragment
import com.example.shopingapp.ui.subcategory.SubCategoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Helps to generate an {@link AndroidInjector} for all activities
 * */
@Suppress("unused")
@Module
abstract class ActivityBuilder {

    /**
     * fun to bind HomeActivity Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindHomeActivity() : HomeActivity

    /**
     * fun to bind HomeFragment Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindHomeFragment() : HomeFragment

    /**
     * fun to bind SubCategoryFragment Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindSubCategoryFragment() : SubCategoryFragment

    /**
     * fun to bind ProductDetailsFragment Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindProductDetailsFragment() : ProductDetailsFragment

    /**
     * fun to bind MyBagsFragment Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindMyBagsFragment() : MyBagsFragment

    /**
     * fun to bind FavouriteFragment Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindFavouriteFragment() : FavouriteFragment

    /**
     * fun to bind ShippingFragment, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindShippingFragment() : ShippingFragment
}