package mg.startapps.namana.listeners.activities.sharing;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class ShareTextOnClickListener implements View.OnClickListener {

	private Activity activity;
	private String text;

	public ShareTextOnClickListener(Activity activity, String text) {
		super();
		this.activity = activity;
		this.text = text;
	}

	@Override
	public void onClick(View v) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, this.text);
		sendIntent.setType("text/plain");
		this.activity.startActivity(sendIntent);
	}
}
