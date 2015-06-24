import java.util.Set;
import java.util.Collection;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

//questions 
//if there are same key
//does it contain?
public class SZJUnit{
	HashTableEntry entry1,entry2,entry3,entry4,entry5;
	LinearProbingHashTable testTable, testTable1, testTable2, testTable3, table1,table2,table3,table4,table5;
	ArrayList<Integer> keys;
	ArrayList<String> values;
	ArrayList<HashTableEntry> entries;

	@org.junit.Before public void setUp(){
		keys = new ArrayList<Integer>();
		values = new ArrayList<String>();
		entries = new ArrayList<HashTableEntry>();

		testTable = new LinearProbingHashTable();

		testTable1 = new LinearProbingHashTable(5,.5);

		testTable2 = new LinearProbingHashTable();
		testTable2.put((int)1,"Steven");
		testTable2.put((int)2,"Saman");
		testTable2.put((int)3,"Crystal");
		testTable2.put((int)4,"Hannah");
		testTable2.put((int)5,"Ilyssa");
		testTable2.put((int)6,"Tri-An");
		testTable2.put((int)7,"William");
		testTable2.put((int)8,"Dhruv");
		testTable2.put((int)9,"Kefu");
		testTable2.put((int)10,"Somya");

		testTable3 = new LinearProbingHashTable(5);
		testTable3.put((int)1,"Akbar");
		testTable3.put((int)3,"Akbar");
		testTable3.put((int)2,"Akbar");
		testTable3.put((int)10,"Akbar");
		testTable3.put((int)90,"Akbar");
		testTable3.put((int)33,"Akbar");
		testTable3.put((int)17,"Akbar");
		testTable3.put((int)18,"Akbar");
		testTable3.put((int)19,"Akbar");
		testTable3.put((int)20,"Akbar");
		testTable3.put((int)29,"Akbar");
	}

	@Test(timeout = 2000)
	public void testHashEntryEquals1(){
		entry1 = new HashTableEntry((int) 1, (int) 2);
		entry2 = new HashTableEntry((int)1, (int)2);
		assertTrue("they should be equal",entry1.equals(entry2));
	}
	
	@Test
	public void testHashEntryEquals2(){
		entry1 = new HashTableEntry((int) 1, (int) 2);
		entry2 = new HashTableEntry((int)1, (int)2);
		entry3 = new HashTableEntry((int)2,(int)2);
		entry4 = new HashTableEntry((int)1,(int)3);
		entry5 = new HashTableEntry((int)2,(int)1);
		assertFalse("check false case",entry1.equals(entry3));
		assertFalse("check false case",entry1.equals(entry4));
		assertFalse("check false case",entry1.equals(entry5));
	}

	@Test 
	public void testHashEntryHashCode(){
		entry1 = new HashTableEntry((int) 1, (int) 2);
		entry2 = new HashTableEntry((int)1, (int)2);
		assertTrue("Hash code should be equal",entry1.hashCode() == entry2.hashCode());
	}

	@Test 
	public void testHashEntryAvailable(){
		entry1 = new HashTableEntry((int) 1, (int) 2);
		assertFalse("constructing should be false first", entry1.isAvailable());
		entry1.setAvailable(true);
		assertTrue("Available has been set",entry1.isAvailable());
	}

	@Test
	public void testHashEntryGetKey(){
		entry1 = new HashTableEntry((int)1,(int) 2);
		entry3 = new HashTableEntry((int)2,(int)2);
		assertEquals("check getKey()",(Object)1,entry1.getKey());
		assertEquals("check getKey()",(Object)2,entry3.getKey());
	}

	@Test
	public void testHashEntrySetAndGetValue(){
		entry1 = new HashTableEntry((int)1,(int)2);
		entry2 = new HashTableEntry((int)1,(int)3);
		entry3 = new HashTableEntry((int)2,(int)4);
		entry4 = new HashTableEntry((int)1,(int)5);
		entry5 = new HashTableEntry((int)2,(int)1);
		assertEquals("check getValue",(Object)2,entry1.getValue());
		assertEquals("check getValue",(Object)3,entry2.getValue());
		assertEquals("check getValue",(Object)4,entry3.getValue());
		assertEquals("check getValue",(Object)5,entry4.getValue());
		assertEquals("check getValue",(Object)1,entry5.getValue());
		entry1.setValue((int) 3);
		assertEquals("check setValue",(Object)3,entry1.getValue());
	}

	@Test 
	public void testConstructor1(){
		table1 = new LinearProbingHashTable();
		assertTrue("does not start empty",table1.isEmpty());
		assertEquals("does not start with right size",0,(int)table1.size());
		assertEquals("table size does not match", 11, (int)table1.getArray().length);
	}

	@Test 
	public void testConstructor2(){
		table1 = new LinearProbingHashTable(9);
		assertTrue("does not start empty",table1.isEmpty());
		assertEquals("does not start with right size",0,(int)table1.size());
		assertEquals("array does not match",9,(int)table1.getArray().length);
	}

	@Test 
	public void testConstructor3(){
		table1 = new LinearProbingHashTable(9,.75);
		assertTrue("does not start empty",table1.isEmpty());
		assertEquals("does not start with right size",0,(int)table1.size());
		assertEquals("array does not match",9,(int)table1.getArray().length);
	}

	@Test
	public void testMaxLoad(){
		testTable1.put((int)1,"Akbar");
		testTable1.put((int)3,"Akbar");
		testTable1.put((int)2,"Akbar");
		assertTrue("should have resized",5<(int)testTable1.getArray().length);
		int newSize = testTable1.getArray().length;
		testTable1.put((int)10,"Akbar");
		testTable1.put((int)90,"Akbar");
		testTable1.put((int)33,"Akbar");
		assertTrue("should have resized",newSize<(int)testTable1.getArray().length);
		newSize = testTable1.getArray().length;
		testTable1.put((int)17,"Akbar");
		testTable1.put((int)18,"Akbar");
		testTable1.put((int)19,"Akbar");
		testTable1.put((int)20,"Akbar");
		testTable1.put((int)29,"Akbar");
		assertTrue("should have resized",newSize<(int)testTable1.getArray().length);
	}

	@Test
	public void testClear1(){
		assertFalse("should start with soemthing",testTable2.isEmpty());
		assertEquals("should start with 10 entries",10,(int)testTable2.size());
		testTable2.clear();
		assertTrue("should now be empty",testTable2.isEmpty());
		assertEquals("shouldn't have any entries",0,testTable2.size());
	}

	@Test
	public void testClear2(){ //just to see if it will clear empty hash
		testTable.clear();
	}

	@Test
	public void testContainsKey1(){
		assertFalse("testTable should not contain anything",testTable.containsKey((int) 1));
		assertFalse("testTable 2 should only contain 1-10",testTable2.containsKey((int)11));
		assertFalse("let's see if your thing wraps around!",testTable2.containsKey((int)0));
	}

	@Test
	public void testContainsKey2(){
		assertTrue("testTable 2 should have 1-10",testTable2.containsKey((int)2));
		assertFalse("Key shouldn't be the location",testTable2.containsKey((int)0));
	}

	@Test
	public void testContainsKey3(){
		testTable2.put((int)23,"James");
		assertTrue("should include wrap arounds",testTable2.containsKey((int)23));
	}

	@Test 
	public void testContainsValue1(){
		assertTrue("does contain man",testTable2.containsValue("Steven"));
	}

	@Test 
	public void testContainsValue2(){
		assertFalse("test for false case",testTable2.containsValue("Marcus"));
		assertFalse("test for false case",testTable.containsValue(null));
	}

	@Test
	public void testEntrySet1(){
		entries.add(new HashTableEntry((int)1,"Steven"));
		entries.add(new HashTableEntry((int)2,"Saman"));
		entries.add(new HashTableEntry((int)3,"Crystal"));
		entries.add(new HashTableEntry((int)4,"Hannah"));
		entries.add(new HashTableEntry((int)5,"Ilyssa"));
		entries.add(new HashTableEntry((int)6,"Tri-An"));
		entries.add(new HashTableEntry((int)7,"William"));
		entries.add(new HashTableEntry((int)8,"Dhruv"));
		entries.add(new HashTableEntry((int)9,"Kefu"));
		entries.add(new HashTableEntry((int)10,"Somya"));
		assertTrue("not the right entry set",entrySetTest(testTable2.entrySet(),entries));
	}

	@Test
	public void testGet1(){
		assertEquals("check get()","Steven",testTable2.get(1));
	}

	@Test (expected = NullPointerException.class)
	public void testGet2(){
		testTable2.get(null);
	}

	@Test
	public void testGet3(){
		assertEquals("shouldn't exist",null,testTable.get(3));
	}

	@Test
	public void testIsEmpty1(){
		assertFalse("not empty",testTable2.isEmpty());
		assertTrue("is empty",testTable.isEmpty());
	}

	@Test
	public void testKeySet1(){
		keys.add(1);
		keys.add(3);
		keys.add(2);
		keys.add(10);
		keys.add(90);
		keys.add(33);
		keys.add(17);
		keys.add(18);
		keys.add(19);
		keys.add(20);
		keys.add(29);
		assertTrue("you had:" + printSet(testTable.keySet()),keySetTest(testTable3.keySet(),keys));
	}

	@Test (expected=NullPointerException.class)
	public void testPut1(){
		testTable.put(null,(int)1);
	}

	@Test 
	public void testPut2(){
		assertEquals("adding for the first time",null,testTable.put((int)1,(String) "Steven"));
		assertEquals("size didn't incremet",1,testTable.size());
	}

	@Test 
	public void testPut3(){
		testTable2.put((int)2,"Hannah");
		assertFalse("does not have 3",testTable2.containsKey((int)100));
		assertTrue("does have 2 tho",testTable2.containsKey((int)2));
	}

	@Test
	public void testPut4(){
		testTable.put((int)3,"Steven");
		testTable.put((int)2,"Steven");
		testTable.put((int)1,"Steven");
		testTable.put((int)5,"Steven");
		assertEquals("",11,(int)testTable.getArray().length);
		testTable.put((int)10,"Steven");
		testTable.put((int)12,"Steven");
		testTable.put((int)42,"Steven");
		testTable.put((int)8,"Steven");
		testTable.put((int)23,"Steven");
		assertTrue("should have resized",11<(int)testTable.getArray().length);	
	}

	@Test
	public void testPut5(){
		testTable2.put((int)1,"Steven");
		assertEquals("should return previous","Saman",testTable2.put((int)2,"Steven"));
		testTable2.put((int)3,"Steven");
		testTable2.put((int)4,"Steven");
		assertEquals("should return previous","Ilyssa",testTable2.put((int)5,"Steven"));
		testTable2.put((int)6,"Steven");
		testTable2.put((int)7,"Steven");
		testTable2.put((int)8,"Steven");
		testTable2.put((int)9,"Steven");
		testTable2.put((int)10,"Steven");
		assertEquals("should be the same size",10,testTable2.size());
		assertEquals("this should all be me","Steven",testTable2.get(3));
	}

	@Test
	public void testPutAll1(){
		testTable2.putAll(testTable3);
		assertEquals("should combine",17,(int)testTable2.size());
		assertTrue("should have Akbar",testTable2.containsValue("Akbar"));
		assertTrue("should have 90", testTable2.containsKey(90));
	}

	@Test
	public void testRemove1(){
		assertTrue("should contain key 2",testTable2.containsKey((int)2));
		assertTrue("should contain Saman",testTable2.containsValue("Saman"));
		testTable2.remove((int)2);
		assertFalse("should contain key 2",testTable2.containsKey((int)2));
		assertFalse("should contain Saman",testTable2.containsValue("Saman"));
		assertEquals("size need to decrement",9,(int)testTable2.size());
	}

	@Test(timeout = 2000)
	public void testRemove4(){
		//remove everything!!!
		assertTrue("it is there",testTable3.containsKey(90));
		assertTrue("it is there",testTable3.get(90).equals("Akbar"));
		assertEquals("size", 11,(int)testTable3.size());
		assertEquals("wrong return","Akbar",testTable3.remove(90));
		assertEquals("wrong size",10,(int)testTable3.size());
		assertFalse("it isn't there",testTable3.containsKey(90));
		assertEquals("it isn't there",null,testTable3.get(90));
	}

	@Test (expected=NullPointerException.class)
	public void testRemove2(){
		testTable2.remove(null);
	}

	@Test
	public void testRemove3(){
		assertEquals("return null please",null,testTable2.remove(100));
	}

	@Test 
	public void testRemove5(){
		assertEquals("return wrong value","Steven",testTable2.remove(1));
		assertEquals("return wrong value","Saman",testTable2.remove(2));
		assertEquals("return wrong value","Crystal",testTable2.remove(3));
		assertEquals("return wrong value","Hannah",testTable2.remove(4));
		assertEquals("return wrong value","Ilyssa",testTable2.remove(5));
		assertEquals("return wrong value","Tri-An",testTable2.remove(6));
		assertEquals("return wrong value","William",testTable2.remove(7));
		assertEquals("return wrong value","Dhruv",testTable2.remove(8));
		assertEquals("return wrong value","Kefu",testTable2.remove(9));
		assertEquals("return wrong value","Somya",testTable2.remove(10));
		assertEquals("should be emtpy now",0,testTable2.size());
		assertTrue("it is empty fool",testTable2.isEmpty());
	}

	@Test
	public void testSize1(){
		assertEquals("check size method",10,(int)testTable2.size());
	}

	@Test
	public void testMaxLoad2(){
		assertEquals("check size method",20,(int)testTable3.getArray().length);
	}

	@Test
	public void testValues1(){
		assertTrue("should all be Akbar",valueTest(testTable3));
	}

	@Test
	public void testSetSize1(){
		testTable.setSize(10);
		assertEquals("should now be 10",10,(int)testTable.getArray().length);
	}

	private boolean entrySetTest(Set g, ArrayList<HashTableEntry> answerSet){
		if (g.size() != answerSet.size()){
			return false;
		}
		for (Object i: g.toArray()){
			if (!answerSet.contains(i)){
				return false;
			}
		}
		return true;
	}

	private boolean valueTest(LinearProbingHashTable g){
		for(Object i: g.values()){
			if (!i.equals("Akbar")){
				return false;
			}
		}
		return true;
	}

	private boolean keySetTest(Set g, ArrayList<Integer> answerSet){
		if (g.size() != answerSet.size()){
			return false;
		}
		for (Object i: g.toArray()){
			if (!answerSet.contains(i)){
				return false;
			}
		}
		return true;
	}

	private String printSet(Set k){
		String answer ="";
		for(Object o: k.toArray()){
			answer += o;
		}
		return answer;
	}
}
