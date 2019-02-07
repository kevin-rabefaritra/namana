package mg.startapps.namana.helpers;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.AnimRes;
import android.util.Log;

public class ActivityHelper
{
	public static void launchActivity(Context context, Class<? extends Activity> activityClass, String key, Object value)
	{
		launchActivity(context, activityClass, new String[]{key}, new Object[]{value});
	}

	public static void launchActivity(Context context, Class<? extends Activity> activityClass, String[] keys, Object[] values)
	{
		launchActivity(context, activityClass, keys, values, 0, 0);
	}

	/**
	 * Launch an activity with key and value provided
	 * @param context: Context
	 * @param activityClass: The Activity's class to be launched
	 * @param keys: Set of keys
	 * @param values: Set of values
	 * @param enter: Enter animation (0 is none)
	 * @param exit: Exit animation (0 if none)
	 */
	public static void launchActivity(Context context, Class<? extends Activity> activityClass, String[] keys, Object[] values, @AnimRes int enter, @AnimRes int exit)
	{
		Intent intent = new Intent(context, activityClass);
		// activity.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		for(int i = 0; i < (keys == null ? 0 : keys.length); i++)
		{
			if(values[i] instanceof Integer)
			{
				intent.putExtra(keys[i], ((Integer) values[i]).intValue());
			}
			else if(values[i] instanceof Short)
			{
				intent.putExtra(keys[i], ((Short) values[i]).shortValue());
			}
			else if(values[i] instanceof String)
			{
				intent.putExtra(keys[i], values[i].toString());
			}
			else if(values[i] instanceof Double)
			{
				intent.putExtra(keys[i], ((Double) values[i]).doubleValue());
			}
		}
		context.startActivity(intent);

		if(enter != 0 && exit != 0)
		{
			((Activity) context).overridePendingTransition(enter, exit);
		}
	}

	public static void launchActivity(Context context, Class<? extends Activity> activityClass)
	{
		launchActivity(context, activityClass, new String[]{}, new Object[]{});
	}


	/**
	 * Launch a service
	 * @param context: Context
	 * @param serviceClass: Service class to be launched
	 */
	public static void launchService(Context context, Class<? extends Service> serviceClass)
	{
		Intent intent = new Intent(context, serviceClass);
		context.startService(intent);
	}


	/**
	 * Checks if a service is running, returns true if true
	 * @param context: Context
	 * @param service: The service's class
	 * @return true is the service is still running
	 */
	public static boolean isServiceRunning(Context context, Class<? extends Service> service)
	{
		ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		if(manager != null)
		{
			for (ActivityManager.RunningServiceInfo runningServiceInfo : manager.getRunningServices(Integer.MAX_VALUE))
			{
				if (service.getName().equals(runningServiceInfo.service.getClassName()))
				{
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Opens an URL in a browser
	 * @param context: Context
	 * @param url: The URL to be opened
	 * @param secured: if the URL is secured or not, if true, the url will be appended by "http" instead of "https"
	 */
	public static void openURL(Context context, String url, boolean secured)
	{
		if(url.startsWith("www"))
		{
			if(secured)
			{
				url = "https://" + url;
			}
			else
			{
				url = "http://" + url;
			}
		}
		Log.d("OPEN URL", url);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		context.startActivity(intent);
	}


	/**
	 * Restarts an activity
	 * @param activity: Activity
	 */
	public static void restartActivity(Activity activity)
	{
		activity.finish();
		activity.startActivity(activity.getIntent());
	}


	/**
	 * Closes all activites
	 * @param activity: Activity
	 * @param activityClass: Activity class
	 */
	public static void finishAllActivities(Activity activity, Class<? extends Activity> activityClass)
	{
		Intent intent = new Intent(activity, activityClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		activity.startActivity(intent);
	}
}
