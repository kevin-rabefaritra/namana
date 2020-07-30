package mg.startapps.namana.helpers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class TextViewHelper {

	public static void setFontToTextView(Context context, String fontName, TextView... textViews) {
		TextViewHelper.setFontToTextView(context, "fonts/", fontName, textViews);
	}

	public static void setFontToTextView(Context context, String path, String fontName, TextView... textViews) {
		Typeface typeFace = Typeface.createFromAsset(context.getAssets(), path + fontName + "");
		for(TextView textView : textViews) {
			textView.setTypeface(typeFace);
		}
	}
}
