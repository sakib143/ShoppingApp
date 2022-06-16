package com.example.shopingapp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Build.MANUFACTURER
import android.os.Build.MODEL
import android.os.Environment
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.inject.Inject
import kotlin.random.Random


class GlobalMethods @Inject constructor() {

    val dateFormat = SimpleDateFormat("dd-MM-yy")
    val dateFormatNew = SimpleDateFormat("dd-MMM-yy")
    val dateFormatForTime = SimpleDateFormat("h:mm a")


    fun isPackageInstalled(
        packagename: String, context: Context
    ): Boolean {
        return try {
            context.packageManager.getPackageGids(packagename)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    fun currencyFormat(amount: String): String? {
        val formatter = DecimalFormat("###,###,##0.00")
        return formatter.format(amount.toDouble())
    }

    fun getAppVersion(context: Context): String {
        var version = ""
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            version = pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return version
    }

    fun getYoutubeThumbnailUrlFromVideoUrl(videoUrl: String): String? {
        return "http://img.youtube.com/vi/" + getYoutubeVideoIdFromUrl(videoUrl) + "/0.jpg"
    }

    fun getYoutubeVideoIdFromUrl(inUrl: String): String? {
        var inUrl = inUrl
        inUrl = inUrl.replace("&feature=youtu.be", "")
        if (inUrl.toLowerCase().contains("youtu.be")) {
            return inUrl.substring(inUrl.lastIndexOf("/") + 1)
        }
        val pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*"
        val compiledPattern: Pattern = Pattern.compile(pattern)
        val matcher: Matcher = compiledPattern.matcher(inUrl)
        return if (matcher.find()) {
            matcher.group()
        } else null
    }

    fun getCurrentDayName() : String {
        val weekDay: String
        val dayFormat = SimpleDateFormat("EEEE", Locale.US)
        val calendar = Calendar.getInstance()
        weekDay = dayFormat.format(calendar.time)
//        return weekDay.substring(0,7)
        return weekDay
    }

    fun getDayNamebyDate(strDate: String) : String {
        val date = dateFormat.parse(strDate)
        val outFormat = SimpleDateFormat("EEEE")
        val goal = outFormat.format(date)
        return goal.substring(0,3)
    }

    fun getDayNamebyDateFullString(strDate: String) : String {
        val date = dateFormat.parse(strDate)
        val outFormat = SimpleDateFormat("EEEE")
        val goal = outFormat.format(date)
        return goal
    }

    fun getTwoDigitCurrentDate() : String {
        val todaysDate: String = java.text.SimpleDateFormat("dd").format(Date())
//        val strDate = String.format("%02d", todaysDate)
        return todaysDate
    }

    fun getTwoDigitDate(strDate: String) : String {
        val date = dateFormat.parse(strDate)
        val todaysDate: String = java.text.SimpleDateFormat("dd").format(date)
        return todaysDate
    }

    fun getDateForSideMenu(): String {
        val cal = Calendar.getInstance()
        val simpleformat = SimpleDateFormat("MMM dd, yyyy")
        return simpleformat.format(cal.time)
    }

    fun getCurrentDate(): String {
        val c = Calendar.getInstance().time
        return dateFormat.format(c)
    }

    fun getCurrentTime(): String  {
        val c = Calendar.getInstance().time
        return dateFormatForTime.format(c)
    }

    fun getCurrentDateAndTimeNew(): String? {
        val c = Calendar.getInstance().time
        return dateFormatNew.format(c)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun isInternetAvailable(context: Context): Boolean {
        var isOnline = false
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        try {
            val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
            isOnline =  capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return isOnline
    }

    fun drawableToBitmap(drawable: Drawable): Bitmap? {
        var bitmap: Bitmap? = null
        if (drawable is BitmapDrawable) {
            val bitmapDrawable = drawable
            if (bitmapDrawable.bitmap != null) {
                return bitmapDrawable.bitmap
            }
        }
        bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(
                1,
                1,
                Bitmap.Config.ARGB_8888
            ) // Single color bitmap will be created of 1x1 pixel
        } else {
            Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
        drawable.draw(canvas)
        return bitmap
    }

    fun openFacebookPage(pageId: String, context: Context) {
        val pageUrl = "https://www.facebook.com/$pageId"
        try {
            val applicationInfo: ApplicationInfo =
                context.getPackageManager().getApplicationInfo("com.facebook.katana", 0)
            if (applicationInfo.enabled) {
                val versionCode: Int =
                    context.getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode
                val url: String
                url = if (versionCode >= 3002850) {
                    "fb://facewebmodal/f?href=$pageUrl"
                } else {
                    "fb://page/$pageId"
                }
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            } else {
                throw Exception("Facebook is disabled")
            }
        } catch (e: Exception) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(pageUrl)))
        }
    }

    fun getFourDigitNumber(): String {
        val randomNumber = "" + ((Math.random() * 9000).toInt() + 1000)
        return "$randomNumber"
    }

    fun getRandomNumberBetween(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
    }

    fun getDeviceName(): String =
        (if (MODEL.startsWith(MANUFACTURER, ignoreCase = true)) {
            MODEL
        } else {
            "$MANUFACTURER $MODEL"
        }).capitalize()

    // TODO: 28-09-2018 full image path to Bitmap by Sakib END
    fun getDeviceID(context: Context): String? {
        var android_id: String? = ""
        try {
            android_id =
                Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return android_id
    }


    fun saveFile(context: Activity, fileName: String, sBody: String?) {
        try {
            val root: File
            root = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() + "/" + Constant.ROOT_FOLDER_NAME)
            } else {
                File(Environment.getExternalStorageDirectory(), Constant.ROOT_FOLDER_NAME)
            }

            if (!root.exists()) {
                root.mkdirs()
            }
            val jsonFile = "${fileName}.json" // Save to JSON file
            val file = File(root, jsonFile)
            val writer = FileWriter(file)
            writer.append(sBody)
            writer.append("\n")
            writer.flush()
            context.toast(file.absolutePath + jsonFile)
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "\"*/*\""
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra(Intent.EXTRA_SUBJECT, "Sharing file from the AppName")
                putExtra(Intent.EXTRA_TEXT, "Sharing file from the AppName with some description")
                val fileURI = FileProvider.getUriForFile(
                    context, context.packageName + ".provider",
                    File(file.absolutePath))
                putExtra(Intent.EXTRA_STREAM, fileURI)
            }
                context.startActivity(shareIntent)
        } catch (e: IOException) {
            context.toast(e.printStackTrace().toString())
        }
    }
}