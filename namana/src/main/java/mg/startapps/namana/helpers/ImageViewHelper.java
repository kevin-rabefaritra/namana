package mg.startapps.namana.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageViewHelper {

	public static ImageView createImageView(Context context, Drawable drawable) {
		ImageView result = new ImageView(context);
		result.setImageDrawable(drawable);
		return result;
	}

	public static ImageView createImageView(Context context, Drawable drawable, int size) {
		ImageView result = new ImageView(context);
		drawable = DrawableHelper.createDrawable(context, drawable, size);
		result.setImageDrawable(drawable);
		return result;
	}
}
