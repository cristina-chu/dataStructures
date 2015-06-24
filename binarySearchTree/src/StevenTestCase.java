public class StevenTestCase{

	public static void main(String[] args){
		boolean test[] = new boolean[40];

		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.add(5);
		t.add(12);
		t.add(3);
		t.add(0);
		t.add(-1);
		t.add(-12);//this is min
		t.add(23);//this is max
		//size should be 7
		System.out.println(t.inOrder());
		
		test[0] = t.size() == 7;
		test[1] = t.contains(5);
		test[2] = t.contains(-1);
		test[3] = !t.contains(-10);
		test[4] = t.contains(0);
		test[5] = t.contains(12);
		test[6] = !t.contains(1);
		test[7] = !t.contains(100);
		test[8] = !t.isEmpty();
		test[9] = t.getMax() ==23;
		test[10] = t.getMin() == -12;
		test[11] = t.contains(23);
		test[12] = t.contains(-12);

		BinarySearchTree<Integer> g = new BinarySearchTree<Integer>();
		g.add(5);
		g.add(1);
		g.add(10);
		g.add(8);
		g.add(3);
		g.add(2);
		g.add(4);
		g.add(7);
		g.add(6);
		g.add(9);
		g.add(-1);
		g.add(11);
		g.add(-10);
		g.add(12);
		g.add(-11);
		g.add(0);

		test[13] = g.size() == 16;
		test[14] = g.getMax() == 12;
		test[15] = g.getMin() == -11;
		test[16] = !g.isEmpty();
		test[17] = g.contains(-10);
		test[18] = g.contains(5);
		test[19] = g.contains(-11);
		test[20] = g.contains(12);
		test[21] = g.contains(6);
		test[22] = g.contains(0);
		test[23] = !g.contains(20);
		test[24] = !g.contains(-2);
		test[25] = !g.contains(13);

		int counter = 0;
		int[] tInOrder = {-12,-1,0,3,5,12,23};
		boolean isRight = true;
		for (int i : t.inOrder()){
			if (!(i == (tInOrder[counter])))  {
				isRight = false;
				break;
			}
			counter++;
		}
		test[26] = isRight;

		counter = 0;
		int[] tPreOrder = {5,3,0,-1,-12,12,23};
		isRight = true;
		for (int i : t.preOrder()){
			if (!(i == (tPreOrder[counter]))){
				isRight = false;
				break;
			}
			counter++;
		}
		test[27] = isRight;

		counter = 0;
		int[] tPostOrder = {-12,-1,0,3,23,12,5};
		isRight = true;
		for (int i : t.postOrder()){
			if (!(i == (tPostOrder[counter]))){
				isRight = false;
				break;
			}
			counter++;
		}
		test[28] = isRight;

		counter = 0;
		int[] gInOrder ={-11,-10,-1,0,1,2,3,4,5,6,7,8,9,10,11,12};
		isRight = true;
		for (int i : g.inOrder()){
			if (!(i == gInOrder[counter])){
				isRight = false;
				break;
			}
			counter++;
		}
		test[29] = isRight;

		counter = 0;
		int[] gPreOrder ={5,1,-1,-10,-11,0,3,2,4,10,8,7,6,9,11,12};
		isRight = true;
		for (int i : g.preOrder()){
			if (!(i == gPreOrder[counter])){
				isRight = false;
				break;
			}
			counter++;
		}
		test[30] = isRight;

		for (int i: g.postOrder()){
			System.out.println(i);
		}
		counter = 0;
		int[] gPostOrder ={-11,-10,0,-1,2,4,3,1,6,7,9,8,12,11,10,5};
		isRight = true;
		for (int i : g.postOrder()){
			if (!(i == gPostOrder[counter])){
				isRight = false;
				break;
			}
			counter++;
		}
		test[31] = isRight;		

		t.clear();
		test[32] = t.isEmpty();
		test[33] = !t.contains(0);
		test[34] = !t.contains(5);
		test[35] = t.size() == 0;

		g.clear();
		test[36] = g.isEmpty();
		test[37] = !g.contains(5);
		test[38] = !g.contains(-11);
		test[39] = g.size() == 0;


		///////////////////////////////////////////////////////
		System.out.println("Testing Methods: ");
		int count = 0;
		for (boolean b: test){
			if (b){
				System.out.println("Test: "+count+"...passed!");
			}
			else{
				System.out.println("Test: "+count+"...failed");
			}
			count++;
		}
		boolean allPass = true;
		for (boolean b: test){
			if (!b){
				allPass = false;
				break;
			}
		}
		if (allPass){
			System.out.println("Passed Everything!");
		}
		else
			System.out.println("Check your work!");
	}
}