public class MainMethod {
  public static void main(String[] args) {
    boolean[] result = new boolean[15];
    
    ArrayList<T> list = new ArrayList<T>();
    
    result[0] = list.size() == 0;
    
    list.add(new T(10),0);
    list.add(new T(9),1);
    list.add(new T(3),2);
    list.add(new T(15),3);
    list.add(new T(19),4);
    list.add(new T(0),5);
    list.add(new T(7),6);
    list.add(new T(6),7);
    list.add(new T(10),8);
    list.add(new T(1),9);
    list.add(new T(2),10);
    list.add(new T(12),11);
    list.add(new T(14),12);
    
    result[1] = list.size() == 13;
    result[2] = list.get(-1) == null;
    result[3] = list.get(100) == null;
    result[4] = list.get(2).getNum() == 3;
    list.traverse();
    result[5] = list.get(12).getNum() == 14;
    result[6] = list.indexOf(new T(14)) == 12;
    result[7] = !list.contains(new T(999));
    result[8] = list.contains(new T(14));
    list.add(new T(42), 7);
    result[9] = list.get(7).getNum() == 42;
    result[10] = list.get(list.size()-1).getNum() == 14;
    //list.traverse();
    result[11] = !list.isEmpty();
    
    
    ArrayList<T> list2 = new ArrayList<T>(5);
    
    list2.add(new T(10),0);
    list2.add(new T(9),1);
    list2.add(new T(3),2);
    list2.add(new T(15),3);
    list2.add(new T(19),4);
    list2.add(new T(0),5);
    list2.add(new T(7),6);
    list2.add(new T(6),7);
    
    result[12] = list2.size() == 8;
    
    list.clear();
    result[13] = list.size() == 0;
    result[14] = list.isEmpty();
    
    int testCase = 0;
    for(boolean b : result) {
      if(b)
        System.out.println("Case " + testCase + ": pass");
      else
        System.out.println("Case " + testCase + ": fail");
      
      testCase++;
    }
  }
}
