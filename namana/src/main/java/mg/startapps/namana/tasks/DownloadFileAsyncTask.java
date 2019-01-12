package mg.startapps.namana.tasks;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;

import java.lang.ref.WeakReference;

import mg.startapps.namana.helpers.StringHelper;

public class DownloadFileAsyncTask extends AsyncTask<String, Integer, Long>
{
	private String url;
	private String fileName;
	private DownloadManager downloadManager;
	private String downloadTitle;
	private String downloadDescription;
	private String downloadDestination; // with new filename

	public DownloadFileAsyncTask(Context context, String url, String fileName, String downloadTitle, String downloadDescription, String downloadDestination)
	{
		super();
		this.url = url;
		this.fileName = fileName;
		this.downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
		this.downloadTitle = downloadTitle;
		this.downloadDescription = downloadDescription;
		this.downloadDestination = downloadDestination;
	}

	@Override
	protected Long doInBackground(String... strings)
	{
		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.url));
		request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
		request.setAllowedOverRoaming(false);
		request.setTitle(this.downloadTitle);

		if(!StringHelper.isEmptyOrNull(this.downloadDescription))
		{
			request.setDescription(this.downloadDescription);
		}
		request.setVisibleInDownloadsUi(true);

		request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, this.downloadDestination + "/" + this.fileName);
		request.allowScanningByMediaScanner();
		request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

		return this.downloadManager.enqueue(request);
	}
}
