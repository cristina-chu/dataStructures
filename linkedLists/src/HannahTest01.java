import java.util.*;

public class HannahTest01 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		boolean[] results = new boolean[60];
		
		results[0] = list.size() == 0;

		list.addFirst(new X('a'));
		results[1] = list.get(0).equals(new X('a'));

		list.addFirst(new X('b'));
		results[2] = list.get(0).equals(new X('b'));

		list.addLast(new X('c'));
		results[3] = list.get(2).equals(new X('c'));

		results[4] = list.size() == 3;

		list.add(new X('n'));

		results[5] = list.get(3).equals(new X('n'));
		results[6] = list.size() == 4;

		list.add(new X('o'), 3);

		results[7] = list.get(2).equals(new X('c'));
		results[8] = list.get(3).equals(new X('o'));
		results[9] = list.get(4).equals(new X('n'));

		results[10] = list.size() == 5;
		results[11] = list.getFirst().equals(new X('b'));
		results[12] = list.getLast().equals(new X('n'));

		for(Object o : list)
			System.out.print((X)o);

		System.out.println();

		results[13] = list.removeFirst().equals(new X('b'));
		results[14] = list.getFirst().equals(new X('a'));

		results[15] = list.removeLast().equals(new X('n'));
		results[16] = list.getLast().equals(new X('o'));

		results[17] = list.size() == 3;

		list.add(new X('b'), 1);
		list.add(new X('e'), 2);
		list.add(new X('r'), 3);
		list.add(new X('r'), 5);
		list.add(new X('m'));
		list.add(new X('b'));
		list.add(new X('i'));
		list.add(new X('e')); 
		list.add(new X('!')); //abercrombie! 12 characters

		for(Object o : list)
			System.out.print((X)o);

		System.out.println();
		
		results[18] = !list.contains(new X('z'));
		results[19] = list.contains(new X('a'));
		results[20] = list.contains(new X('i'));

		results[21] = list.get(4).equals(new X('c'));
		results[22] = list.get(11).equals(new X('!'));

		results[23] = list.indexOf(new X('a')) == 0;
		results[24] = list.indexOf(new X('e')) == 2;
		results[25] = list.indexOf(new X('!')) == 11;
		results[26] = list.indexOf(new X('z')) == -1; //Value of "-1" depends on your code for the indexOf method

		results[27] = list.remove(new X('a')).equals(new X('a')); //this version of remove() assumes it only removes the first instance of 'item'
		results[28] = list.remove(new X('e')).equals(new X('e'));
		results[29] = list.remove(4).equals(new X('o'));
		results[30] = list.remove(list.size()-2).equals(new X('e'));

		//brcrmdi!
		results[31] = list.size() == 8;
		results[32] = list.getFirst().equals(new X('b'));
		results[33] = list.get(1).equals(new X('r'));
		results[34] = list.get(3).equals(new X('r'));
		results[35] = list.get(6).equals(new X('i'));
		results[36] = list.getLast().equals(new X('!'));

		results[37] = list.remove(new X('z')) == null;
		results[38] = !list.isEmpty();

		list.clear();

		results[39] = list.isEmpty();

		list.add(new X());
		results[40] = list.remove(0).equals(new X('a'));
		list.add(new X());
		results[41] = list.remove(new X()).equals(new X('a'));
		
		results[42] = list.size() == 0;		

		try {
			list.getFirst();
		}
		catch(NoSuchElementException e) {
			results[43] = true;
		}

		try {
			list.getLast();
		}
		catch(NoSuchElementException e) {
			results[44] = true;
		}

		list.add(new X());
		results[45] = list.getFirst().equals(new X('a'));
		results[46] = list.getLast().equals(new X('a'));

		list.add(new X('b'), 1);
		results[47] = list.getLast().equals(new X('b'));

		try {
			list.add(new X('c'), 3);
		}
		catch(IndexOutOfBoundsException e) {
			results[48] = true;
		}

		try {
			list.add(new X(), -1);
		}
		catch(IndexOutOfBoundsException e) {
			results[49] = true;
		}

		try {
			list.get(3);
		}
		catch(IndexOutOfBoundsException e) {
			results[50] = true;
		}

		try {
			list.get(-1);
		}
		catch(IndexOutOfBoundsException e) {
			results[51] = true;
		}

		try {
			list.remove(-1);
		}
		catch(IndexOutOfBoundsException e) {
			results[52] = true;
		}

		try {
			list.remove(3);
		}
		catch(IndexOutOfBoundsException e) {
			results[53] = true;
		}

		list.clear();

		try {
			list.removeFirst();
		}
		catch(NoSuchElementException e) {
			results[54] = true;
		}

		try {
			list.removeLast();
		}
		catch(NoSuchElementException e) {
			results[55] = true;
		}

		try {
			list.getFirst();
		}
		catch(NoSuchElementException e) {
			results[56] = true;
		}

		try {
			list.getLast();
		}
		catch(NoSuchElementException e) {
			results[57] = true;
		}

		list.add(new X('a'));
		list.add(new X('b'));
		list.add(new X('c'));

		try {
			list.get(-1);
		}
		catch(IndexOutOfBoundsException e) {
			results[58] = true;
		}

		try {
			list.get(3);
		}
		catch(IndexOutOfBoundsException e) {
			results[59] = true;
		}
		

		int testCase = 0;
	    while(testCase < results.length) {
	      if(results[testCase])
	        System.out.println("Case " + testCase + ": pass");
	      else
	        System.out.println("Case " + testCase + ": fail");
	      
	      testCase++;
	    }

		
	}	
}