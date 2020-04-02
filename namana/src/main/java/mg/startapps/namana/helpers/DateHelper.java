package mg.startapps.namana.helpers;

import java.util.Calendar;
import java.util.TimeZone;

import mg.startapps.namana.models.time.KalendarTime;

public class DateHelper {

	/**
	 * Converts a DateTime (GMT+0) to the local timezone or the other way around
	 * @param kalendarTime
	 * @return the local date time equivalent
	 */
	private static KalendarTime localTime(KalendarTime kalendarTime, boolean roll) {
		Calendar calendar = kalendarTime.getKalendar().toCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, kalendarTime.getTime().getHour());
		calendar.set(Calendar.MINUTE, kalendarTime.getTime().getMinutes());

		if(roll) {
			calendar.roll(Calendar.MINUTE, DateHelper.getTimeZoneShift());
		}
		else {
			calendar.add(Calendar.MINUTE, DateHelper.getTimeZoneShift());
		}

		return new KalendarTime(
				calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.YEAR),
				calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE)
		);
	}

	public static KalendarTime toLocalTime(KalendarTime kalendarTime) {
		return DateHelper.localTime(kalendarTime, false);
	}

	public static KalendarTime toGlobalTime(KalendarTime kalendarTime) {
		return DateHelper.localTime(kalendarTime, true);
	}

	/**
	 * Returns the timezone shift from GMT+0 in minutes
	 * @return int the timezone shift from GMT+0 in minutes
	 */
	public static int getTimeZoneShift() {
		TimeZone timeZone = TimeZone.getDefault();
		String timeGmt = timeZone.getDisplayName(false, TimeZone.SHORT);
		// timeGmt = GMT+09:30
		timeGmt = timeGmt.replace("GMT", "");
		// timeGmt = +09:30
		String[] hourMinutes = timeGmt.split(":");
		// hourMinutes = ["+09", "30"]
		int hours = Integer.parseInt(hourMinutes[0]);
		int minutes = Integer.parseInt(hourMinutes[1]);
		// hours = 9, minutes = 30
		// if hours is negative, the shift should be further away from 0
		return hours * 60 + ((hours < 0) ? - minutes : minutes);
	}
}
