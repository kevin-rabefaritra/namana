package mg.startapps.namana.listeners.dialogs;

import android.app.Dialog;
import android.view.View;

public class OpenDialogOnClickListener implements View.OnClickListener {

	private Dialog dialog;

	public OpenDialogOnClickListener(Dialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void onClick(View view) {
		this.dialog.show();
	}
}
