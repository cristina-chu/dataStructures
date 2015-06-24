
public class MissionThree {

	/**
	 * Merges two sorted arrays, and computer the difference in scores
	 * 
	 * @param person1 a sorted array of medals
	 * @param person2 a sorted array of medals
	 * @return the difference in score of person1 and person2
	 */
	public static <T extends Comparable<? super T>> int merge(T[] person1, T[] person2) {
		int score1 = 0;
		int score2 = 0;
		
		int place = 0;
		int index1 = 0;
		int index2 = 0;
		while (index1 < person1.length && index2 < person2.length) {
			if (person1[index1].compareTo(person2[index2])<0) {
				score1 = score1+(place+1);
				index1++;
				place++;
			}
			else { 
				score2 = score2+(place+1);
				index2++;
				place++; 
			}
		}
		
		if (index2 != person2.length) {
			while (index2 < person2.length) {
				score2 = score2+(place+1);
				index2++;
				place++;
			}
		}
		else if (index1 != person1.length) {
			while (index1 < person1.length) {
				score1 = score1+(place+1);
				index1++;
				place++;
			}
		}

		return (score1-score2);
	}

}
