package mg.startapps.namana.helpers;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

/**
 * Created by Kevin Rabefaritra on 10/02/2018.
 */

public class StringHelper
{
	public static Spanned fromHtml(String source)
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
		{
			return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
		}
		else
		{
			return Html.fromHtml(source);
		}
	}


	/**
	 * Returns true if a string is empty or null
	 * @param str: String to be checked
	 * @return True or false
	 */
	public static boolean isEmptyOrNull(String str)
	{
		return (str == null || str.trim().equals("") || str.trim().toLowerCase().equals("null"));
	}

	/**
	 * Fills a number with zeros into the defined length
	 * @param number: the number to be filled
	 * @param length: length of the result
	 * @return the number preceded by zeros
	 */
	public static String fillZeros(int number, int length)
	{
		String result = "" + number;
		for(int i = result.length(); i < length; i++)
		{
			result = "0" + result;
		}
		return result;
	}


	/**
	 * Truncates a string if longer than the specified length
	 * @param string: the string to be truncated
	 * @param maxLength: the max length
	 * @return String truncated with "..."
	 */
	public static String truncate(String string, int maxLength)
	{
		if(string.length() <= maxLength)
		{
			return string;
		}
		else
		{
			return String.format("%s...", string.substring(0, maxLength - 1));
		}
	}

	public static String[] explode(String str, String delimiter) {
		return str.split(delimiter);
	}

	public static String repeat(String str, int repeat) {
		String result = str;
		for (int i = 1; i < repeat; i++) {
			result += str;
		}
		return result;
	}

	public static String join(String delimiter, String... strings) {
		String result = "";
		for(String string: strings) {
			result += string + delimiter;
		}
		return result.substring(0, result.length() - 1);
	}
}
