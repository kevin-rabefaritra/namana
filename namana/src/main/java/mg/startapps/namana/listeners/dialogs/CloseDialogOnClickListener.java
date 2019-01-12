package mg.startapps.namana.listeners.dialogs;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * Created by Kevin Rabefaritra on 18/02/2018.
 */

public class CloseDialogOnClickListener implements View.OnClickListener
{
	private Dialog dialog;
	private DialogFragment dialogFragment;

	public CloseDialogOnClickListener(DialogFragment dialogFragment, Dialog dialog)
	{
		super();
		this.dialogFragment = dialogFragment;
		this.dialog = dialog;
	}

	public CloseDialogOnClickListener(DialogFragment dialogFragment)
	{
		this(dialogFragment, null);
	}

	public CloseDialogOnClickListener(Dialog dialog)
	{
		this(null, dialog);
	}

	@Override
	public void onClick(View v)
	{
		this.closeDialog();
	}

	private void closeDialog()
	{
		if(this.dialogFragment != null)
		{
			this.dialogFragment.dismiss();
		}
		else if(this.dialog != null)
		{
			this.dialog.dismiss();
		}
	}
}
