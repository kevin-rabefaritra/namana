package mg.startapps.namana.helpers;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class PhoneHelper
{
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
}
