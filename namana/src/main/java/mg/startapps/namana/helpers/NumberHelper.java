package mg.startapps.namana.helpers;

public class NumberHelper {

	/**
	 * Returns a random number between minValue and maxValue (inclusive)
	 * @param minValue
	 * @param maxValue
	 * @return a random number
	 */
	public static int generateRandom(int minValue, int maxValue) {
		return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
	}
}
