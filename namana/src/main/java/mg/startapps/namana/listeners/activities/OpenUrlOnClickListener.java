package mg.startapps.namana.listeners.activities;

import android.app.Activity;
import android.view.View;

import mg.startapps.namana.helpers.ActivityHelper;

/**
 * Created by Kevin Rabefaritra on 18/02/2018.
 */

public class OpenUrlOnClickListener implements View.OnClickListener
{
	private Activity activity;
	private String url;
	private boolean securedUrl;

	public OpenUrlOnClickListener(Activity activity, String url, boolean securedUrl)
	{
		super();
		this.activity = activity;
		this.url = url;
		this.securedUrl = securedUrl;
	}

	public OpenUrlOnClickListener(Activity activity, String url)
	{
		this(activity, url, false);
	}

	@Override
	public void onClick(View v)
	{
		ActivityHelper.openURL(this.activity, this.url, this.securedUrl);
	}
}
