package mg.startapps.namana.helpers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

public class NotificationHelper
{
	private static int NOTIFICATION_ID = 3;

	public static NotificationCompat.Builder notify(Context context, @DrawableRes int icon, String message, String ticker, String contentTitle, @Nullable PendingIntent pendingIntent, int visibility)
	{
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");
		builder.setAutoCancel(true)
				.setDefaults(NotificationCompat.DEFAULT_ALL)
				.setWhen(System.currentTimeMillis())
				.setSmallIcon(icon)
				.setTicker(ticker)
				.setContentTitle(contentTitle)
				.setContentText(message)
				.setPriority(NotificationCompat.PRIORITY_DEFAULT);

		// Android +O
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
		{
			NotificationChannel channel = NotificationHelper.buildNotificationChannel(context, contentTitle, message, visibility);
			if (notificationManager != null)
			{
				notificationManager.createNotificationChannel(channel);
			}
		}

		if(pendingIntent != null)
		{
			builder.setContentIntent(pendingIntent);
		}

		if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.O)
		{
			// alarm
			builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

			// vibrate
			builder.setVibrate(new long[] {0, 100, 50, 100});
		}

		if (notificationManager != null)
		{
			notificationManager.notify(NotificationHelper.NOTIFICATION_ID, builder.build());
			Calendar nextNotifyTime = Calendar.getInstance();
			nextNotifyTime.add(Calendar.DATE, 1);
		}
		return builder;
	}

	private static NotificationChannel buildNotificationChannel(Context context, String name, String description, int visibility)
	{
		NotificationChannel result = null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
		{
			result = new NotificationChannel("default", name,  NotificationManager.IMPORTANCE_HIGH);
			result.setDescription(description);

			result.enableLights(true);
			result.setLightColor(Color.BLUE);
			result.enableVibration(true);
			result.setLockscreenVisibility(visibility);
		}
		return result;
	}
}
