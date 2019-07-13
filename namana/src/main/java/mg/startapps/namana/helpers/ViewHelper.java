package mg.startapps.namana.helpers;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class ViewHelper
{
	public static void setFontStyleToTextView(Context context, TextView textView, String font)
	{
		Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/" + font + "");
		textView.setTypeface(typeFace);
	}
}