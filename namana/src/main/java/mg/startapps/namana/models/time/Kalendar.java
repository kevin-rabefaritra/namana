package mg.startapps.namana.models.time;

import java.util.Calendar;

import mg.startapps.namana.helpers.StringHelper;

public final class Kalendar
{
	private int day;
	private int month;
	private int year;

	public Kalendar()
	{
		Calendar today = Calendar.getInstance();
		this.setMonth(today.get(Calendar.MONTH) + 1);
		this.setYear(today.get(Calendar.YEAR));
		this.setDay(today.get(Calendar.DAY_OF_MONTH), this.getMonth(), this.getYear());
	}

	public Kalendar(int day, int month, int year)
	{
		this.setMonth(month);
		this.setYear(year);
		this.setDay(day, month, year);
	}

	public Kalendar(String date)
	{
		int annee = Integer.parseInt(date.substring(0, 4));
		int mois = Integer.parseInt(date.substring(5, 7));
		int jour = Integer.parseInt(date.substring(8, 10));
		this.setMonth(mois);
		this.setYear(annee);
		this.setDay(jour, mois, annee);
	}
	
	public Kalendar(int nb_jours)
	{
		this.initDate(nb_jours);
	}

	public Kalendar(Kalendar it)
	{
		this( it.getDay(), it.getMonth(), it.getYear() );
	}

	public boolean setDay(int jour, int mois, int annee)
	{
		int max = 31;
		boolean result = false;
		if(mois == 4 || mois == 6 || mois == 9 || mois == 11 )
		{
			max = 30;
		}
		else if(mois == 2)
		{
			max = 28;
			if(annee%4 == 0) // on peut se baser sur le calendrier julien :$
				max = 29;
		}

		// In case of new month reaches 13 (& 0 anyway)
		if(jour <= max && jour > 0 && mois < 13 && mois > 0)
		{
			this.day = jour;
			result = true;
		}
		return result;
	}

	// 1 : Janvier, 12 : Decembre
	public boolean setMonth(int mois)
	{
		boolean result = false;
		if(mois>0 && mois<13)
		{
			this.month = mois;
			result = true;
		}
		return result;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	// Getters
	public int getDay()
	{
		return this.day;
	}

	public int getMonth()
	{
		return this.month;
	}

	public int getYear()
	{
		return this.year;
	}

	/// Méthodes

	// retourne 1 si l'objet appelant est plus récent que l'argument
	public int compareTo(Kalendar b)
	{
		int result = 0;
		if( this.getYear() > b.getYear() )
		{
			result = 1;
		}
		else if( this.getYear() < b.getYear() )
		{
			result = -1;
		}
		else
		{
			if( this.getMonth() > b.getMonth() )
			{
				result = 1;
			}
			else if( this.getMonth() < b.getMonth() )
			{
				result = -1;
			}
			else
			{
				if( this.getDay() > b.getDay() )
				{
					result = 1;
				}
				else if( this.getDay() < b.getDay() )
				{
					result = -1;
				}
				else
				{
					return 0;
				}
			}
		}
		return result;
	}

	public boolean isBetween(Kalendar date1, Kalendar date2)
	{
		return (this.compareTo(date1) >= 0 && this.compareTo(date2) <= 0);
	}

	public Kalendar nextWeek()
	{
		int counter = 0;
		Kalendar result = new Kalendar(this);
		for(counter = 0; counter < 7; counter++)
		{
			result = result.nextDay();
		}
		return result;
	}

	public Kalendar nextWeek(int times)
	{
		if(times == 0)
			return this;
		else return this.nextWeek().nextWeek(times - 1);
	}

	public Kalendar nextDay()
	{
		// setDay returns boolean but also apply if true, so no more getMonth+1 anymore
		if(!this.setDay(this.getDay() + 1 , this.getMonth(), this.getYear()) )
		{
			if( !this.setDay(1, this.getMonth() + 1, this.getYear()) )
			{
				return new Kalendar(1, 1, this.getYear() + 1);
			}
			else return new Kalendar(1, this.getMonth() + 1, this.getYear());
		}
		else return new Kalendar( this.getDay(), this.getMonth(), this.getYear() );
	}

	public Kalendar previousDay()
	{
		// setDay returns boolean but also apply if true, so no more getMonth+1 anymore
		if(!this.setDay(this.getDay() - 1 , this.getMonth(), this.getYear()) )
		{
			if( !this.setDay(Kalendar.getLastJourMois(this.getMonth() -1, this.getYear()), this.getMonth() - 1, this.getYear()) )
			{
				return new Kalendar(31, 12, this.getYear() - 1);
			}
			else return new Kalendar(Kalendar.getLastJourMois(this.getMonth() -1, this.getYear()), this.getMonth() - 1, this.getYear());
		}
		else return new Kalendar( this.getDay(), this.getMonth(), this.getYear() );
	}

	public Kalendar previousWeek()
	{
		int counter = 0;
		Kalendar result = new Kalendar(this);
		for(counter = 0; counter < 7; counter++)
		{
			result = result.previousDay();
		}
		return result;
	}

	// nb_jours depuis 2000 -> date
	public void initDate(int nbDays)
	{
		int annee = 0, mois = 1, jour = 0;
		
		// Etape 1 : retirer les annees
		int jours_annee = 366;
		for(annee = 0; nbDays > jours_annee; annee++)
		{
			//System.out.println("Nombre jours : " + nb_jours + "(-" + jours_annee + " car year " + (year + 2000) + ")");
			nbDays -= jours_annee;
			jours_annee = (annee+1)%4 == 0? 366 : 365;
		}
		// Etape 2 retirer les month
		int[] jours_mois = new int[]{31, annee%4 == 0? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(mois = 1; nbDays > jours_mois[mois-1]; mois++)
		{
			//System.out.println("Nombre jours : " + nb_jours + "(-" + jours_mois[month-1] + ")");
			nbDays -= jours_mois[mois-1];
		}
		//System.out.println("Nombre jours restants : " + nb_jours + "");
		jour = nbDays;
		this.setMonth(mois);
		this.setYear(annee + 2000);
		this.setDay(jour, mois, annee);
	}

	/**
	 * Returns the number of days since the 1st January 2000
	 * @return
	 */
	public int getNbDays()
	{
		return this.getDay() + this.monthsToDays() + this.yearsToDays();
	}
	
	public int monthsToDays()
	{
		int[] tab = new int[]{31, this.isLeapYear() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int result = 0;
		for(int i = 0; i < this.getMonth() - 1; i++)
			result += tab[i];
		return result;
	}
	
	public int yearsToDays()
	{
		int years_since_2k = this.getYear() - 2000;
		return ( years_since_2k * 365 ) + (years_since_2k / 4)  + (years_since_2k % 4 == 0 ? 0 : 1);
	}
	
	public boolean isLeapYear()
	{
		return (this.getYear() % 4 == 0 && this.getYear() % 100 != 0) || this.getYear() % 400 == 0;
	}

	public static boolean isAfternoon()
	{
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 12;
	}
	
	public String toString()
	{
		String[] mois = new String[] {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
		String zeroJ = "";
		if(this.getDay() < 10) zeroJ = "0";

		return zeroJ + this.getDay() + " " + mois[this.getMonth() - 1] + " " + this.getYear();
	}

	public String toStringReduced(boolean withYear)
	{
		String[] mois = new String[] {"Jan", "Fev", "Mars", "Avril", "Mai", "Juin", "Juil", "Août", "Sept", "Oct", "Nov", "Dec"};
		String zeroJ = "";
		if(this.getDay() < 10) zeroJ = "0";

		String value = zeroJ + this.getDay() + " " + mois[this.getMonth() - 1] + " " + this.getYear();

		String[] splited = value.split(" ");
		String result = splited[0] + " " + splited[1];

		if(withYear)
		{
			result += " " + this.getYear();
		}

		return result;
	}

	public String toStringReduced()
	{
		return this.toStringReduced(false);
	}

	public boolean isToday()
	{
		return this.compareTo(new Kalendar()) == 0;
	}

	/**
	 * Retourne sous la forme YYYY-mm-dd
	 * @return String
	 */
	public String toNumericString()
	{
		return String.format("%s-%s-%s", this.year, StringHelper.fillZeros(this.month, 2), StringHelper.fillZeros(this.day, 2));
	}

	public Calendar toCalendar()
	{
		Calendar result = Calendar.getInstance();
		result.set(Calendar.MONTH, this.month - 1);
		result.set(Calendar.YEAR, this.year);
		result.set(Calendar.DAY_OF_MONTH, this.day);
		return result;
	}

	private static int getLastJourMois(int mois, int annee)
	{
		mois = mois < 1 ? mois + 12: mois % 13;
		int[] joursMois = new int[]{31, annee%4 == 0? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		return joursMois[mois - 1];
	}
}
