package mg.startapps.namana.helpers;

import android.app.Activity;
import android.content.DialogInterface;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;

/**
 * Created by Kevin Rabefaritra on 14/01/2017.
 */
public class DialogHelper
{
    public static void showConfirmationDialog(Activity activity, String message, DialogInterface.OnClickListener onPositive, DialogInterface.OnClickListener onNegative, String positiveMsg, String negativeMsg, @StyleRes int style)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity, style);
        dialog.setMessage(message);
        dialog.setPositiveButton(positiveMsg, onPositive);
        dialog.setNegativeButton(negativeMsg, onNegative);
        dialog.show();
    }

	public static void showConfirmationDialog(Activity activity, @StringRes int message, DialogInterface.OnClickListener onPositive, DialogInterface.OnClickListener onNegative, @StringRes int positiveMsg, @StringRes int negativeMsg, @StyleRes int style)
	{
		DialogHelper.showConfirmationDialog(activity, activity.getResources().getString(message), onPositive, onNegative, activity.getResources().getString(positiveMsg), activity.getResources().getString(negativeMsg), style);
	}

    public static void showInformationDialog(Activity activity, String message, String positiveButton, @StyleRes int style)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity, style);
        dialog.setPositiveButton(positiveButton, null);
        dialog.setMessage(message);
        dialog.show();
    }
}