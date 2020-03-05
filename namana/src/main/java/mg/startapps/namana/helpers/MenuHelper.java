package mg.startapps.namana.helpers;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;

import androidx.annotation.MenuRes;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {

	public static List<MenuItem> extractMenuItems(Menu menu) {
		List<MenuItem> result = new ArrayList<>(menu.size());
		for(int i = 0; i < menu.size(); i++) {
			result.add(menu.getItem(i));
		}
		return result;
	}

	public static List<MenuItem> extractMenuItems(Activity activity, @MenuRes int menuRes) {
		PopupMenu popupMenu  = new PopupMenu(activity, null);
		Menu menu = popupMenu.getMenu();
		activity.getMenuInflater().inflate(menuRes, menu);
		return MenuHelper.extractMenuItems(menu);
	}
}
