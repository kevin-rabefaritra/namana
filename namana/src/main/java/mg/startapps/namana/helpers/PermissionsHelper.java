package mg.startapps.namana.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Created by kevinRabefaritra on 28/03/2018.
 */

public class PermissionsHelper
{
	public static boolean hasPermissions(Context context, String... permissions)
	{
		for(String permission : permissions)
		{
			if(ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED)
			{
				return false;
			}
		}
		return true;
	}

	public static void requestPermissions(Activity activity, int requestCode, String... permissions)
	{
		ActivityCompat.requestPermissions(activity, permissions, requestCode);
	}

	public static boolean checkPermissions(int[] grantResults)
	{
		for (int grantResult : grantResults)
		{
			if (grantResult == PackageManager.PERMISSION_DENIED)
			{
				return false;
			}
		}
		return true;
	}
}
