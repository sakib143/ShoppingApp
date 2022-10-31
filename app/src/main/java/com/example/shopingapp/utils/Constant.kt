package com.example.shopingapp.utils

import android.app.DownloadManager

/**
 * Class Contains All the Constant Values which will be used through out App
 */
class Constant {

    companion object {

        const val ROOT_FOLDER_NAME = "TaskApp"

        //Common keys
        const val CHECK_INTENET_TITLE = "No internet"
        const val CHECK_INTERNET = "Please check your internet connection"
        const val DEFAULT_SERVER_ERROR = "Something went wrong on server side. Please try again."
        const val APP_PREFERENCES = "app_preferences"
        const val HINT_VIDEO_PREFERENCE = "hint_video_preference"
        const val SOCKET_TIMEOUT_EXCEPTIONS = "Socket Timeout Exception"
        const val CONNECTION_TIMEOUT_EXCEPTIONS = "Connection Timeout Exception"
        const val HEADER_AUTHORIZATION = "Authorization"
        const val TOKEN = "Token"
        const val SUCCESS_CODE = 200
        const val UNAUTHORIZED_CODE = 401
        const val INTERNAL_SERVER_ERROR_CODE = 500
        const val NO_DATA_FOUND_CODE = 404
        const val METHOD_NOT_ALLOW = 405
        const val NON_AUTHORITATIVE_INFORMATION = 203
        const val RESPONSE_MESSAGE = "message"
        const val LOADING = "loading"
        const val SUCCESS = "success"
        const val ERROR = "error"

        const val REQUEST_MAIN_CATEGORY = "getallactivecategory"
        const val REQUEST_GETSUBCATEGORYLIST = "getsubcategorylist"
        const val REQUEST_USERID = "userid"
        const val REQUEST_MODE = "Mode"
        const val REQUEST_ITEMCATEGORYCODE = "ItemCategoryCode"

        const val REQUEST_ITEM_CATEGORY_CODE = "ItemCategoryCode"
        const val REQUEST_GET_ITEM_LIST_BY_CATEGORY = "getitemlistbycategory"

        const val REQUEST_ADD_ORDER = "addorder"
        const val REQUEST_USER_ID = "userid"
        const val REQUEST_QTY = "qty"
        const val REQUEST_RATE = "rate"
        const val REQUEST_ITEM_ID = "itemid"

        const val KEY_MINSELLQUANTITY= "minSellQuantity"
        const val KEY_ITEMID= "itemid"
        const val KEY_NAME = "name"
        const val KEY_BRANDNAME = "brandName"
        const val KEY_DEFAULTMRP = "defaultMRP"
        const val KEY_IMAGEURL = "imageName"
    }
}