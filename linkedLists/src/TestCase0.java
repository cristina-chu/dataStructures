import java.util.ArrayList;

public class TestCase0 {
	public static void main(String [] args){
		boolean[] bool = new boolean[10];
		LinkedList<T> ll = new LinkedList<T>();
		
		bool[0] = ll.isEmpty();
		ll.add(new T(33));// gone
		T first = (T)ll.getFirst();
		bool[1] = (ll.removeFirst()).equals(first);
		ll.addFirst(new T(123));//1
		ll.addLast(new T(0));//5
		ll.add(new T(000) , 1);//2
		bool[2] = ll.size() == 3;
		bool[3] = ll.contains(ll.get(2));
		ll.add(new T(55));//6
		ll.add(new T(11));//8
		ll.add(new T(90));//9
		ll.add(new T(5));//10
		ll.addLast(new T(3));//11
		ll.add(new T(455) , 2);//3
		ll.addFirst(new T(83));//0
		ll.add(new T(58) , 6);//7
		ll.addLast(new T(-23));//gone
		ll.add(new T(12) , 4);//4
		bool[4] = ((T)(ll.getLast())).equals(new T(-23));
		bool[5] = ((T)(ll.getFirst())).equals(new T(83));
		bool[6] = ll.indexOf(new T(5)) == 10;
		ll.removeLast();
		System.out.println("ll.get(11) is: " + (T)ll.get(11));
		bool[7] = ( ((T)(ll.get(11))).equals(new T(3)));
		bool[8] = ll.size() == 12;
		System.out.println(ll.toString());
		ll.clear();
		bool[9] = ll.size()==0;
		int i=0;
		for(boolean b : bool)
			System.out.println("case " + (i++) + " pass: " + b);
	}
}
