package mg.startapps.namana.helpers;

import android.content.Context;

import mg.startapps.namana.tasks.DownloadFileAsyncTask;

public class DownloadHelper
{
	public static DownloadFileAsyncTask get(Context context, String url, String fileName, String downloadTitle, String downloadDescription, String downloadDestination)
	{
		return new DownloadFileAsyncTask(context, url, fileName, downloadTitle, downloadDescription, downloadDestination);
	}
}
