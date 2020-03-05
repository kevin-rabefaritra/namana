package mg.startapps.namana.helpers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Px;

public class ViewHelper
{
	public static void setFontStyleToTextView(Context context, TextView textView, String font)
	{
		Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/" + font + "");
		textView.setTypeface(typeFace);
	}

	public static View getBlankView(@NonNull Activity activity, @Px int width)
	{
		TextView view = new TextView(activity);
		view.setWidth(width);
		return view;
	}

	public static void addRectangleBackground(View view, @ColorInt int backgroundColor, float radius)
	{
		GradientDrawable shape = new GradientDrawable();
		shape.setShape(GradientDrawable.RECTANGLE);
		shape.setCornerRadius(radius);
		shape.setColor(backgroundColor);
		view.setBackgroundDrawable(shape);
	}

	public static Drawable getRectangleBackground(Context context, @ColorRes int backgroundColor, float cornerRadii)
	{
		GradientDrawable shape = new GradientDrawable();
		shape.setShape(GradientDrawable.RECTANGLE);
		shape.setCornerRadius(cornerRadii);
		shape.setColor(context.getResources().getColor(backgroundColor));
		return shape;
	}

	public static void addCircleBackground(View view, int backgroundColor)
	{
		GradientDrawable shape = new GradientDrawable();
		shape.setShape(GradientDrawable.OVAL);
		shape.setColor(backgroundColor);
		view.setBackgroundDrawable(shape);
	}

	public static int selectedIndex(RadioGroup radioGroup)
	{
		for(int i = 0; i < radioGroup.getChildCount(); i++)
		{
			if(radioGroup.getChildAt(i) instanceof RadioButton && ((RadioButton) radioGroup.getChildAt(i)).isChecked())
			{
				return i;
			}
		}
		return -1;
	}
}