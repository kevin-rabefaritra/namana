package io.kevin.namana.utils

import android.app.Activity
import android.content.Intent

object ActivityHelper {

    fun launchActivity(activity: Activity, target: Class<*>, close: Boolean = false) {
        activity.startActivity(Intent(activity, target))
        if(close) {
            activity.finish()
        }
    }
}