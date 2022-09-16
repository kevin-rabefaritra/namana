package io.kevin.namana.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {

    fun request(activity: Activity, permissionRequestCode: Int, vararg permissions: String) {
        ActivityCompat.requestPermissions(activity, permissions, permissionRequestCode)
    }

    fun hasPermissions(context: Context, vararg permissions: String): Boolean {
        permissions.forEach { permission ->
            if(ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
        return true
    }
}