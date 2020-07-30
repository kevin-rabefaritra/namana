package mg.startapps.namana.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;

public class DrawableHelper {

	public static Drawable createDrawable(Context context, @DrawableRes int drawableRes, int size) {
		Drawable drawable = context.getResources().getDrawable(drawableRes);
		return DrawableHelper.createDrawable(context, drawable, size);
	}

	public static Drawable createDrawable(Context context, Drawable drawable, int size) {
		Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
		return new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, size, size, true));
	}
}
