package com.example.shopingapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.shopingapp.utils.Constant
import com.google.gson.Gson
import javax.inject.Inject

/**
 * Handles Shared Preferences through out the App
 */
@Suppress("unused")
class PrefUtils @Inject constructor(context: Context) {

    private val appPreference = context.getSharedPreferences(Constant.APP_PREFERENCES, Context.MODE_PRIVATE)
//    /**
//     * Object of [android.content.SharedPreferences]
//     * */
//    private val appPreference = context.getSharedPreferences(Constant.APP_PREFERENCES, Context.MODE_PRIVATE)
//    private val hintVideoPreference = context.getSharedPreferences(Constant.HINT_VIDEO_PREFERENCE, Context.MODE_PRIVATE)
//
//    private val SAVE_USER_DATA = "saveUserData"
//    private val USER_ID = "user_id"
//    private val IS_USER_BASE_URL = "is_user_base_url"
//
//
//    fun getUserData () : LoginModel.Data? {
//        val gson = Gson();
//        val data = appPreference.getString(SAVE_USER_DATA,null)
//        val model : LoginModel.Data  = gson.fromJson(data, LoginModel.Data::class.java)
//        return model
//    }
//
//    fun saveUserId(usedrId: Int,userDataModel  : LoginModel.Data) {
//        val editor: SharedPreferences.Editor = appPreference.edit()
//        //Save user id
//        editor.putInt(USER_ID, usedrId)
//        //Save user model data
//        val gson = Gson();
//        val jsonToString = gson.toJson(userDataModel)
//        editor.putString(SAVE_USER_DATA, jsonToString)
//        editor.apply()
//    }
//
////    fun getAuthToken () : String? {
////        return appPreference.getString(TOKEN, null)
////    }
//
//    fun getUserId() : Int {
//        return appPreference.getInt(USER_ID, 0)
//    }
//
//    /**
//     * Method to clear All Stored Preferences
//     */
//    fun clearAll() {
//        val mEditor = appPreference.edit()
//        mEditor.clear()
//        mEditor.apply()
//    }
//
//    /**
//     * Method to check if url is Buyer or seller base url
//     */
//    fun isBuyerBaseUrl() : Boolean {
//        return appPreference.getBoolean(IS_USER_BASE_URL,false)
//    }
//
//    /**
//     * Method to set base url for Buyer and Seller
//     */
//    fun setBuyerBaseUrl(isBuyerUrl: Boolean) {
//        val editor: SharedPreferences.Editor = appPreference.edit()
//        editor.putBoolean(IS_USER_BASE_URL, isBuyerUrl)
//        editor.apply()
//    }

}