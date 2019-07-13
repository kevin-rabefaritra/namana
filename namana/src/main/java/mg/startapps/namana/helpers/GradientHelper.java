package mg.startapps.namana.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorRes;

public class GradientHelper
{
	/**
	 * Create a gradient from a color to another
	 * @param context: the context for fetching the color resources
	 * @param orientation: the orientation of the gradient
	 * @param from: initial color
	 * @param to: final color
	 * @return the drawable according to the defined colors
	 */
	@SuppressLint("ResourceAsColor")
	public static Drawable createGradient(Context context, GradientDrawable.Orientation orientation, @ColorRes int from, @ColorRes int to)
	{
		from = context.getResources().getColor(from);
		to = context.getResources().getColor(to);
		return new GradientDrawable(orientation, new int[]{from, to});
	}

	public static Drawable createGradient(GradientDrawable.Orientation orientation, String from, String to)
	{
		int colorFrom = Color.parseColor(from);
		int colorTo = Color.parseColor(to);
		return new GradientDrawable(orientation, new int[]{colorFrom, colorTo});
	}
}
