package mg.startapps.namana.helpers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import androidx.annotation.NonNull;

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

	public static boolean isInArray(int value, int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(value == array[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean isInArray(short value, short[] array) {
		for(int i = 0; i < array.length; i++) {
			if(value == array[i]) {
				return true;
			}
		}
		return false;
	}

	public static int[] concatenateArrays(int[] arrayA, int[] arrayB) {
		int[] result = new int[arrayA.length + arrayB.length];
		for(int i = 0; i < result.length; i++) {
			if(i < arrayA.length) {
				result[i] = arrayA[i];
			}
			else {
				result[i] = arrayB[i - arrayA.length];
			}
		}
		return result;
	}

	public static <T extends Object>T[] concatenate(T[] array1, @NonNull T[] array2) {
		T[] result = (T[]) Array.newInstance(array2[0].getClass(), array1.length + array2.length);
		for(int i = 0; i < result.length; i++) {
			if(i < array1.length) {
				result[i] = array1[i];
			}
			else {
				result[i] = array2[i - array1.length];
			}
		}
		return result;
	}

	public static int indexOf(Object object, Object[] array) {
		for(int i = 0; i < array.length; i++) {
			if(object.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}

	/**************************** Hashmap ***************************/
	public static HashMap<String, String> generateMap(String[] keys, String[] values) {
		HashMap<String, String> result = new HashMap<>();
		for(int i = 0; i < keys.length; i++) {
			result.put(keys[i], values[i]);
		}
		return result;
	}

	public static HashMap<String, String> generateMap(String key, String value) {
		HashMap<String, String> result = new HashMap<>();
		result.put(key, value);
		return result;
	}

	public static <T extends Object> List<T> removeDuplicates(List<T> list) {
		HashSet<T> hashSet = new HashSet<>(list);
		hashSet.addAll(list);
		return  new ArrayList<>(hashSet);
	}

	public static <T extends Object> List<T> clone(List<T> array)
	{
		return new ArrayList<>(array);
	}

	public static <T extends Object> T[] toArray(List<T> list) {
		T[] result = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
		for(int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
