package mg.startapps.namana.listeners.permissions;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import mg.startapps.namana.helpers.PermissionsHelper;

/**
 * Created by Kevin Rabefaritra on 06/05/2018.
 */

public class RequestPermissionsOnClickListener implements View.OnClickListener {

	private AppCompatActivity activity;
	private String[] permissions;
	private int requestCode;

	public RequestPermissionsOnClickListener(AppCompatActivity activity, String[] permissions, int requestCode) {
		super();
		this.activity = activity;
		this.permissions = permissions;
		this.requestCode = requestCode;
	}

	@Override
	public void onClick(View v) {
		if(!PermissionsHelper.hasPermissions(this.activity, this.permissions)) {
			PermissionsHelper.requestPermissions(this.activity, this.requestCode, this.permissions);
		}
	}
}
