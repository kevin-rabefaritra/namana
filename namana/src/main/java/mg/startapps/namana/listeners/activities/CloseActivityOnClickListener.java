package mg.startapps.namana.listeners.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by Kevin Rabefaritra on 22/02/2018.
 */

public class CloseActivityOnClickListener implements View.OnClickListener, DialogInterface.OnClickListener
{
	private Activity activity;

	public CloseActivityOnClickListener(Activity activity)
	{
		super();
		this.activity = activity;
	}

	private void finish()
	{
		this.activity.finish();
	}

	@Override
	public void onClick(View v)
	{
		this.finish();
	}

	@Override
	public void onClick(DialogInterface dialogInterface, int i)
	{
		this.finish();
	}
}
