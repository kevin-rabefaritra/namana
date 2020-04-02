package mg.startapps.namana.models.time;

/**
 * Created by Onion Knight on 02/10/2017.
 */

public class KalendarTime
{
	private Kalendar kalendar;
	private Time time;

	public KalendarTime(Kalendar kalendar, Time time)
	{
		this.kalendar = kalendar;
		this.time = time;
	}

	public KalendarTime(String kalendarTime)
	{
		String[] kalendarTimeArray = kalendarTime.split(" ");
		this.kalendar = new Kalendar(kalendarTimeArray[0]);
		this.time = new Time(kalendarTimeArray[1]);
	}

	public KalendarTime(int jour, int mois, int annee, int heure, int minutes, int secondes)
	{
		this.kalendar = new Kalendar(jour, mois, annee);
		this.time = new Time(heure, minutes, secondes);
	}

	public KalendarTime(int jour, int mois, int annee, int heure, int minutes)
	{
		this(jour, mois, annee, heure, minutes, 0);
	}

	public KalendarTime(int jour, int mois, int annee)
	{
		this.kalendar = new Kalendar(jour, mois, annee);
		this.time = new Time();
	}

	public KalendarTime()
	{
		this.kalendar = new Kalendar();
		this.time = new Time();
	}

	public Kalendar getKalendar()
	{
		return kalendar;
	}

	public void setKalendar(Kalendar kalendar)
	{
		this.kalendar = kalendar;
	}

	public Time getTime()
	{
		return time;
	}

	public void setTime(Time time)
	{
		this.time = time;
	}

	@Override
	public String toString()
	{
		return String.format("%s - %s", this.kalendar.toStringReduced(), this.time.toString());
	}

	public String toDateTimeString()
	{
		return String.format("%s %s", this.kalendar.toNumericString(), this.time.toString());
	}

	public String toTimestamp()
	{
		return String.format("%s %s", this.kalendar.toNumericString(), this.time.toLongString());
	}

	public int compareTo(KalendarTime kalendarTime)
	{
		if(this.kalendar.compareTo(kalendarTime.getKalendar()) == 0)
		{
			if(this.time.compareTo(kalendarTime.getTime()) == 0)
			{
				return 0;
			}
			else
			{
				return this.time.compareTo(kalendarTime.getTime());
			}
		}
		else
		{
			return this.kalendar.compareTo(kalendarTime.getKalendar());
		}
	}
}
