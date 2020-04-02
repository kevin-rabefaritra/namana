package mg.startapps.namana.models.time;

import java.util.Calendar;

import mg.startapps.namana.helpers.StringHelper;

/**
 * Created by Onion Knight on 20/10/2016.
 */
public class Time
{
    private int hour;
    private int minutes;
    private int seconds;

    public Time(int hour, int minutes, int seconds)
    {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hour, int minutes)
    {
        this(hour, minutes, 0);
    }

    public Time(int hour)
	{
		this(hour, 0);
	}

    public Time(String time)
    {
        String[] timeArray = time.split(":");
        this.hour = Integer.parseInt(timeArray[0]);
        this.minutes = Integer.parseInt(timeArray[1]);

        if(timeArray.length > 2)
		{
			this.seconds = Integer.parseInt(timeArray[2]);
		}
		else
		{
			this.seconds = 0;
		}
    }

    public Time()
    {
        Calendar calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minutes = calendar.get(Calendar.MINUTE);
        this.seconds = calendar.get(Calendar.SECOND);
    }

    /***************************** GETTERS / SETTERS ****************************************/
    public int getHour()
    {
        return this.hour;
    }

    public int getMinutes()
    {
        return this.minutes;
    }

    public int getSeconds()
	{
		return this.seconds;
	}

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds)
	{
		this.seconds = seconds;
	}

    public int compareTo(Time time)
    {
		int minutes1 = this.toMinutes();
    	int minutes2 = time.toMinutes();
    	if(minutes1 > minutes2)
		{
			return 1;
		}
		else if(minutes1 < minutes2)
		{
			return -1;
		}
		else
		{
			return 0;
		}
    }

    public int toMinutes()
	{
		return (this.hour * 60) + this.minutes;
	}

	public boolean isBetween(Time time1, Time time2)
	{
		return this.toMinutes() >= time1.toMinutes() && this.toMinutes() <= time2.toMinutes();
	}

	public Time addMinutes(int minutes)
	{
		Time time = this;
		int newMinutes = time.toMinutes() + minutes;
		time.hour = newMinutes / 60;
		time.minutes = newMinutes - (time.hour * 60);
		return time;
	}

    @Override
    public String toString()
    {
        // return String.format("%s:%s:%s", StringHelper.fillZeros(this.hour, 2), StringHelper.fillZeros(this.minutes, 2), StringHelper.fillZeros(this.seconds, 2));
        return String.format("%s:%s", StringHelper.fillZeros(this.hour, 2), StringHelper.fillZeros(this.minutes, 2));
    }

    public String toLongString()
	{
		return String.format("%s:%s:%s", StringHelper.fillZeros(this.hour, 2), StringHelper.fillZeros(this.minutes, 2), StringHelper.fillZeros(this.seconds, 2));
	}

	/**
	 * Returns the amount of minutes of difference between two Time
	 * @param time2
	 * @return the difference in minutes
	 */
	public int minutesDifference(Time time2)
	{
		return this.toMinutes() - time2.toMinutes();
	}
}
