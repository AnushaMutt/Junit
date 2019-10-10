package junit5;

public class AssertArrayEqualExample {
	
	public static String[] concatenateStringArrays(final String[] array1, final String[] array2) {
		if (array1 == null || array1.length == 0) {
			return array2;
		}
		
		if(array2 == null || array2.length == 0) {
			return array1;
		}
		
		final String[] newArr = new String[array1.length + array2.length];
		System.arraycopy(array1, 0, array2, 0, array1.length);
		System.arraycopy(array2, 0, array1, 0, array2.length);
		
		return newArr;
	}
}
