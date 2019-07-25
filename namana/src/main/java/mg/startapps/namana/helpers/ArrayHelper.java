package mg.startapps.namana.helpers;

public class ArrayHelper {

	public static String[] toStringArray(Object[] array) {
		String[] result = new String[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = array[i].toString();
		}
		return result;
	}

	public static int indexOf(Object[] array, Object object) {
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(object)) {
				return i;
			}
		}
		return -1;
	}
}
