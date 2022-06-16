package com.example.shopingapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.shopingapp.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication: Application(), HasAndroidInjector {

    /**
     * @see [dagger.android.DispatchingAndroidInjector]
     * */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    /**
     * @see [dagger.android.DispatchingAndroidInjector]
     * */
    override fun androidInjector() = dispatchingAndroidInjector

    /**
     * this method gets called when the Application gets created
     * */
    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

//        val config = CheckoutConfig(
//            application = this,
//            clientId = "AQzCnZDozWETAMlwCvegEueWNVkWDVmXMHOqylMaRcSwgAhOHoKsgbtSLm91GRQMT8sKP0bev6cNmCpD",
//            environment = Environment.SANDBOX,
//            returnUrl = String.format("%s://paypalpay", "com.buyamia"),
//            currencyCode = CurrencyCode.USD,
//            userAction = UserAction.PAY_NOW,
//            settingsConfig = SettingsConfig(
//                loggingEnabled = true
//            )
//        )
//        PayPalCheckout.setConfig(config)

    }
}