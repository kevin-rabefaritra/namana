package mg.startapps.namana.listeners.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;

import mg.startapps.namana.helpers.ActivityHelper;

/**
 * Created by kevinRabefaritra on 28/12/16.
 */
public class OpenActivityOnClickListener implements View.OnClickListener, DialogInterface.OnClickListener {

    private Activity activity;
    private Class<? extends Activity> activityClass;
    private String[] keys;
    private Object[] values;
    private boolean closeAfter;
	private boolean fadingEffect;

    public OpenActivityOnClickListener(Activity activity, Class<? extends Activity> activityClass, String[] keys, Object[] values, boolean closeAfter, boolean fadingEffect) {
        super();
        this.activity = activity;
        this.activityClass = activityClass;
        this.keys = keys;
        this.values = values;
		this.closeAfter = closeAfter;
		this.fadingEffect = fadingEffect;
    }

	public OpenActivityOnClickListener(Activity activity, Class<? extends Activity> activityClass, String[] keys, Object[] values) {
		this(activity, activityClass, keys, values, false, false);
	}

	public OpenActivityOnClickListener(Activity activity, Class<? extends Activity> activityClass, String key, Object value) {
		this(activity, activityClass, new String[]{key}, new Object[]{value});
	}

	public OpenActivityOnClickListener(Activity activity, Class<? extends Activity> activityClass, boolean closeAfter, boolean fadingEffect) {
		this(activity, activityClass, null, null, closeAfter, fadingEffect);
	}

	public OpenActivityOnClickListener(Activity activity, Class<? extends Activity> activityClass, boolean closeAfter) {
		this(activity, activityClass, null, null, closeAfter, false);
	}

	public OpenActivityOnClickListener(Activity activity, Class<? extends Activity> activityClass) {
		this(activity, activityClass, false);
	}

    private void launchActivity() {
        ActivityHelper.launchActivity(this.activity, this.activityClass, this.keys, this.values);
		if(this.fadingEffect) {
			this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
		if(this.closeAfter) {
			this.activity.finish();
		}
    }

    @Override
    public void onClick(View v) {
        this.launchActivity();
    }

	@Override
	public void onClick(DialogInterface dialogInterface, int i) {
		this.launchActivity();
	}
}
