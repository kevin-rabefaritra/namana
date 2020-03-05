package mg.startapps.namana.helpers;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

public class TextViewHelper {

	public static void setFontToTextView(TextView textView, String fontName, Activity activity) {
		setFontToTextView(textView, fontName, activity, "fonts/");
	}

	public static void setFontToTextView(TextView textView, String fontName, Activity activity, String path) {
		Typeface typeFace = Typeface.createFromAsset(activity.getAssets(), path + fontName + "");
		textView.setTypeface(typeFace);
	}
}
