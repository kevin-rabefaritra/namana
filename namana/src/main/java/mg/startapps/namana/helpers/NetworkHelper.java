package mg.startapps.namana.helpers;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import java.lang.reflect.Method;

public class NetworkHelper
{
	public static boolean isLocationEnabled(Context context)
	{
		LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		boolean gpsEnabled = false;
		boolean networkEnabled = false;
		try
		{
			gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			networkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		}
		catch (Exception e){};
		if(!gpsEnabled && !networkEnabled)
		{
			return false;
		}
		else return true;
	}

	private static boolean isMobileDataEnabled(Context context)
	{
		boolean result = false; // Assume disabled
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		try
		{
			Class connectivityClass = Class.forName(connectivityManager.getClass().getName());
			Method method = connectivityClass.getDeclaredMethod("getMobileDataEnabled");
			method.setAccessible(true); // Make the method callable
			// get the setting for "mobile data"
			result = (Boolean) method.invoke(connectivityManager);
		}
		catch (Exception e)
		{
			// Some problem accessible private API
		}
		return result;
	}

	private static boolean isWifiEnabled(Context context)
	{
		WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
		if(wifiManager != null)
		{
			return wifiManager.isWifiEnabled();
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns true if the device has an internet connection
	 * @param context: Context
	 * @return true if there's an internet connection
	 */
	public static boolean isConnected(Context context)
	{
		ConnectivityManager connectivityManager = null;
		try
		{
			// In case the connectivity service is not available (NullPointerException)
			connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			if(connectivityManager != null)
			{
				NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
				return networkInfo != null && networkInfo.isConnected();
			}
			else
			{
				return false;
			}
		}
		catch (NullPointerException e)
		{
			return false;
		}
	}
}
