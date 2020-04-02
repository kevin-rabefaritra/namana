package mg.startapps.namana.listeners.dialogs;

import android.view.View;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

import mg.startapps.namana.helpers.DialogHelper;

/**
 * Created by Onion Knight on 30/12/2017.
 */

public class PopupMessageOnClickListener implements View.OnClickListener
{
	private AppCompatActivity activity;
	private String message;
	private int style;

	public PopupMessageOnClickListener(AppCompatActivity activity, String message, @StyleRes int style)
	{
		super();
		this.activity = activity;
		this.message = message;
		this.style = style;
	}

	public PopupMessageOnClickListener(AppCompatActivity activity, String message)
	{
		this(activity, message, 0);
	}

	@Override
	public void onClick(View view)
	{
		DialogHelper.showInformationDialog(this.activity, null, this.message, this.style);
	}
}
