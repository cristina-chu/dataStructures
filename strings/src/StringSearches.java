import java.util.ArrayList;

public class StringSearches {

	/**
	 * Return a table for use with Boyer-Moore.
	 * 
	 * map[c] = the length - 1 - last index of c in the needle
	 * map[c] = the length if c doesn't appear in the needle
	 * 
	 * the map should have an entry for every character, 0 to Character.MAX_VALUE
	 */
	public static int[] buildCharTable(String needle) {
		int[] map = new int[Character.MAX_VALUE + 1];
		
		for (int i = 0; i<Character.MAX_VALUE + 1; i++) {
			map[i] = needle.length(); 
		}
		
		for (int j = 0; j<needle.length(); j++) {
			int x = needle.charAt(j);	
			map[x] = needle.length()-j-1;
		}
			
		return map;
	}

	/**
	 * Run Boyer-Moore on the given strings, looking for needle in haystack.
	 * Return an array of the indices of the occurrence of the needle in the
	 * haystack. 
	 * 
	 * If there are matches that start at index 4, 7, and 9 in the
	 * haystack, return an array containing only 4, 7, and 9. If there are no
	 * matches return an empty array, new int[0]
	 * 
	 * Running time matters, you will not get full credit if it is not
	 * implemented correctly
	 * 
	 * 
	 */
	public static int[] boyerMoore(String needle, String haystack) {
		if (needle.length() == 0)
			return new int[0];
		
		int[] lastTable = buildCharTable(needle);
		
		ArrayList<Integer> array = new ArrayList<Integer>(); 
		int count = 0; //counts how many "founds"
		
		int len = needle.length()-1; //length of needle for indexing
		int i = len; //index of needle
		int j = len; //index of haystack
		int jStart = 0;
		
		while (j<haystack.length() && j>0) {			
			if (needle.charAt(i) == haystack.charAt(j)) {
				i--;
				j--;
				
				if (i==0 && j==jStart) {
					array.add(j);
					count++;
					
					jStart++;
					i=len;
					j=j+needle.length();
				}
			}
			
			else {
				int x = haystack.charAt(j);
				int shift = lastTable[x];
				
				if (shift == 0) 
					shift = 1;
				
				i = len;
				j = j+shift;
				
				jStart = jStart+shift;
			}
			
		}
		
		int[] result = new int[count]; 
		
		for (int s = 0; s<count; s++) {
			result[s] = array.get(s);
		}
		
		return result;
	}

	/**
	 * Return a table for use with KMP. In this table, table[i] is the length of
	 * the longest possible prefix that matches a proper suffix in the string
	 * needle.substring(0, i)
	 */
	public static int[] buildTable(String needle) {
		if (needle.length() == 0) 
			return new int[0];
		
		int[] kmpTable = new int[needle.length()];
		
		kmpTable[0] = -1;
		if (needle.length()>1)
			kmpTable[1] = 0;
		
		int i = 0; //index needle
		int j = 2; //index haystack
		
		while (j < needle.length()){
			if (needle.charAt(i) == needle.charAt(j-1)) {
				i++;
				kmpTable[j] = i;
				j++;
			}
			else if (i > 0){
				i = kmpTable[i];
			}
			else {
				kmpTable[j] = 0;
				j++;
			}
		}
		
		return kmpTable;
	}

	/**
	 * Run Knuth-Morris-Pratt on the given strings, looking for needle in
	 * haystack. Return an array of the indices of the occurrence of the needle
	 * in the haystack.
	 * 
	 * If there are matches that start at index 4, 7, and 9 in the
	 * haystack, return an array containing only 4, 7, and 9. If there are no
	 * matches return an empty array, new int[0]
	 */
	public static int[] kmp(String needle, String haystack) {
		if (needle.length() == 0) {
			return buildTable(needle);
		}
		
		int[] failureTable = buildTable(needle);
		ArrayList<Integer> found = new ArrayList<Integer>();
		int count = 0;
		int i = 0;
		int j = 0;
		
		while (j<haystack.length()) {
			if (needle.charAt(i) == haystack.charAt(j)) {
				i++;
				j++;
				
				if (i == needle.length()) {
					i=0;
					found.add(j-needle.length());
					count++;
				}
			}
			else {
				int a = failureTable[i];
				if (a == -1) {
					j++;
					i=0;
					count = a;
				}
				else {
					i = a;
					count=a;
				}
			}
		}
		
		int[] result = new int[count+1];
		
		for (int s = 0; s<=count; s++) {
			result[s] = found.get(s);
		}
		
		return result;
	}

	
	
	/////// All the methods below are extra credit, you do not have to fill them out. ////////

	// This is the base you should use, don't change it
	public static final int BASE = 1332;

	/**
	 * Given the hash for a string, return the hash for that string removing
	 * oldChar from the front and adding newChar to the end.
	 * 
	 * Power is BASE raised to the power of the length of the needle
	 */
	public static int updateHash(int oldHash, int power, char newChar,
			char oldChar) {
		return 0;
	}

	/**
	 * Hash the given string, using the formula given in the homework
	 */
	public static int hash(String s) {
		return 0;
	}

	/**
	 * Run Rabin-Karp on the given strings, looking for needle in haystack.
	 * Return an array of the indices of the occurrence of the needle in the
	 * haystack.
	 * 
	 * If there are matches that start at index 4, 7, and 9 in the
	 * haystack, return an array containing only 4, 7, and 9. If there are no
	 * matches return an empty array, new int[0]
	 */
	public static int[] rabinKarp(String needle, String haystack) {
		return null;
	}

}