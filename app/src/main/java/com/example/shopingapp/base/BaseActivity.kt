package com.example.shopingapp.base

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.example.shopingapp.di.Injectable
import com.example.shopingapp.utils.GlobalMethods
import com.example.shopingapp.utils.NavigationController
import com.example.shopingapp.utils.PrefUtils
import javax.inject.Inject

/**
 * Class which will be extended by every Activity
 */
@Suppress("unused")
abstract class BaseActivity : AppCompatActivity(), Injectable {

    var AUTOCOMPLETE_REQUEST_CODE = 1

    /**
     * Object for @see [NavigationController], which is used to for navigating screens
     * */
    @Inject
    lateinit var navigationController: NavigationController

    /**
     * Object for @see [PrefUtils] for preferences storage
     * */
    @Inject
    lateinit var prefUtils: PrefUtils

    /**
     * Object for @see [ViewModelProvider.Factory]
     * */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * Makeing GlobalMethods injecatable
     * */
    @Inject
    lateinit var globalMethods: GlobalMethods

    protected val PICKFILE_RESULT_CODE = 786
    protected val LOGIN_FOR_ADD_TO_CART = 110
    protected val LOGIN_FOR_FAVOURITE_LIST = 92
    protected val LOGIN_FOR_CART_TO_OPEN = 14
    protected val LOGIN_FOR_CART_TO_CART = 7
    protected val MULTI_IMAGE_PICKER_RESULT_CODE = 92

    /**
     * request code for storage permission
     * */
    private val mPermissionRequestStorage = 111

    /**
     * request code for camera permission
     * */
    private val mPermissionRequestCamera = 222
    /**
     * request code for location permission
     * */
    private val mPermissionRequestLocation = 333

//    /**
//     * To get Layout Resource ID
//     * @return Layout ID
//     */
//    abstract fun layoutId(): Int

    /**
     * this method gets called when this activity gets created
     * Annotated @CallSuper to make mandatory super call to child class
     * */
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Stop screenshot and Screen recording.
//        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
//        setContentView(layoutId())
    }


    /**
     * One of the methods of Activity Life Cycle, this will be called after activity gets created
     * */
    override fun onResume() {
        super.onResume()
    }


//    /**
//     * Shows Alert dialog to notify user that they re no longer logged-in
//     */
//    fun notAuthorizedDialog() {
//        AlertDialog.Builder(this)
//            .setIcon(android.R.drawable.ic_dialog_alert)
//            .setCancelable(false)
//            .setTitle("Session Expired!")
//            .setMessage("Please login")
//            .setPositiveButton("OK") { _, _ ->
//                clearPrefsAndNavigateToLanding()
//            }
//            .show()
//    }

//    /**
//     * Navigates User to Login page by clearing current session
//     */
//    fun clearPrefsAndNavigateToLanding() {
//        val notificationManager =
//            applicationContext?.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
//        notificationManager?.cancelAll()
//        prefUtils.clearAll()
//        navigationController.navigateToLandingPage(this@BaseActivity)
//        finishAffinity()
//    }

//    /**
//     * this method will add fragment with animation and backStack
//     * @param supportFragmentManager -> supportFragmentManager
//     * @param fragment -> fragment which needs to be added
//     * */
//    fun addFragment(
//        supportFragmentManager: FragmentManager,
//        fragment: Fragment,
//        containerId: Int? = R.id.container, addToBackStack: Boolean = true
//    ) {
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        containerId?.let { fragmentTransaction.add(it, fragment, fragment.javaClass.name) }
//        if (addToBackStack) {
//            fragmentTransaction.addToBackStack(fragment.javaClass.name)
//        }
//        fragmentTransaction.commitAllowingStateLoss()
//    }
//
//
//
//    /**
//     * this method will add fragment without animation and backStack
//     * @param supportFragmentManager -> supportFragmentManager
//     * @param fragment -> fragment which needs to be added
//     * */
//    fun addFragmentWithoutAnimation(
//        supportFragmentManager: FragmentManager?, fragment: Fragment,
//        containerId: Int? = R.id.container, addToBackStack: Boolean = true
//    ) {
//        val fragmentTransaction = supportFragmentManager?.beginTransaction()
//        containerId?.let { fragmentTransaction?.add(it, fragment, fragment.javaClass.name) }
//        if (addToBackStack) {
//            fragmentTransaction?.addToBackStack(fragment.javaClass.name)
//        }
//        fragmentTransaction?.commitAllowingStateLoss()
//    }

    /**
     * Return true if locationPermission granted
     * */
    fun isLocationPermissionGranted(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }


    /**o
     * for requesting location permission
     * */
    fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            mPermissionRequestLocation
        )
    }
}