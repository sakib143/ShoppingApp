package com.example.shopingapp.di

import com.example.shopingapp.ui.home.HomeActivity
import com.example.shopingapp.ui.home.fragment.HomeFragment
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

//    /**
//     * fun to bind LoginActivity, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindLoginActivity() : LoginActivity
//
//    /**
//     * fun to bind HomeActivity, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindAHomeActivity() : HomeActivity
//
//    /**
//     * fun to bind HomeFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindHomeFragment() : HomeFragment
//
//    /**
//     * fun to bind ProductDetails Fragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindProductDetailsFragment() : ProductDetailsFragment
//
//    /**
//     * fun to bind SpecificationsFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindSpecificationsFragment() : SpecificationsFragment
//
//    /**
//     * fun to bind CompanyProfileFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindCompanyProfileFragment() : CompanyProfileFragment
//
//    /**
//     * fun to bind MOQDialogFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindMOQDialogFragment() : MOQDialogFragment
//
//    /**
//     * fun to bind AccountFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindAccountFragment() : AccountFragment
//
//    /**
//     * fun to bind OrderFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindOrderFragment() : OrderFragment
//
//    /**
//     * fun to bind CategoryFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindCategoryFragment() : CategoryFragment
//
//    /**
//     * fun to bind ViewAllFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindViewAllFragment() : ViewAllFragment
//
//    /**
//     * fun to bind ProductvedioFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindProductvedioFragment() : ProductvedioFragment
//
//    /**
//     * fun to bind Company Policy, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindReviewsFragment() : ReviewsFragment
//
//    /**
//     * fun to bind Search Fragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindSearchFragment() : SearchFragment
//
//    /**
//     * fun to bind LoginFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindLoginFragment() : LoginFragment
//
//    /**
//     * fun to bind SignUpFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindSignUpFragment() : SignUpFragment
//
//    /**
//     * fun to bind ChangePasswordFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindChangePasswordFragment() : ChangePasswordFragment
//
//    /**
//     * fun to bind ForgotPasswordFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindForgotPasswordFragment() : ForgotPasswordFragment
//
//    /**
//     * fun to bind OTPFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindOTPFragment() : OTPFragment
//
//    /**
//     * fun to bind WebviewFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindWebviewFragment() : WebviewFragment
//
//    /**
//     * fun to bind FullImageviewFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindFullImageviewFragment() : FullImageviewFragment
//
//    /**
//     * fun to bind SubCategoryFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindSubCategoryFragment() : SubCategoryFragment
//
//    /**
//     * fun to bind CartFragment, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindCartFragment() : CartFragment
//
//    /**
//     * fun to bind Custome And Inqrire, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindCustomQAndInquireFragment() : CustomQAndInquireFragment
//
//    /**
//     * fun to bind Custome And Inqrire List, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindCustomQAndInquireListFragment() : CustomQAndInquireListFragment
//
//    /**
//     * fun to bind Custome And Inqriry Detail, making Injection enable
//     **/
//
//    @ContributesAndroidInjector()
//    abstract fun FragmentCustomInquiryDetailBinding() : CustomInquiryDetailsFragment
//
//    /**
//     * fun to bind Checkout, making Injection enable
//     **/
//
//    @ContributesAndroidInjector()
//    abstract fun FragmentCheckoutBinding() : CheckoutFragment
//
//    /**
//     * fun to bind OrderList, making Injection enable
//     **/
//
//    @ContributesAndroidInjector()
//    abstract fun FragmentOrderListBinding() : OrderListFragment
//
//    /**
//     * fun to bind OrderDetails, making Injection enable
//     **/
//
//    @ContributesAndroidInjector()
//    abstract fun FragmentOrderDetailBinding() : OrderDetailFragment
//
//    /**
//     * fun to bind Shipping Quote, making Injection enable
//     **/
//
//    @ContributesAndroidInjector()
//    abstract fun FragmentShippingQuoteBinding() : ShippingQuoteFragment
//    /**
//     * fun to bind Shipping Quote List, making Injection enable
//     **/
//
//    @ContributesAndroidInjector()
//    abstract fun FragmentShippingQuoteListBinding() : ShippingQuoteListFragment
}