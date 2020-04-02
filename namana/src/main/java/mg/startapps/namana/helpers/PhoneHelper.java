package mg.startapps.namana.helpers;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class PhoneHelper
{
	/**
	 * Calls a number
	 * Note: CALL permission is required
	 * @param activity
	 * @param number
	 */
	@SuppressLint("MissingPermission")
	public static void call(Activity activity, String number)
	{
		if(PermissionsHelper.hasPermissions(activity, Manifest.permission.CALL_PHONE))
		{
			Intent dialer = new Intent(Intent.ACTION_CALL);
			dialer.setData(Uri.parse("tel:" + Uri.encode(number)));
			activity.startActivity(dialer);
		}
		else
		{
			PhoneHelper.dial(activity, number);
		}
	}

	public static void dial(Activity activity, String number)
	{
		Intent dialer = new Intent(Intent.ACTION_DIAL);
		dialer.setData(Uri.parse("tel:" + Uri.encode(number)));
		activity.startActivity(dialer);
	}

	public static void sendMail(Activity activity, String email)
	{
		Intent mailIntent = new Intent(Intent.ACTION_VIEW);
		Uri data = Uri.parse(String.format("mailto:%s?subject=&body=", email));
		mailIntent.setData(data);
		activity.startActivity(mailIntent);
	}
}
