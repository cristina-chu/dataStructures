public class T {
 private int num;

 public T(int num) {
  this.num = num;
 }

 public String toString() {
  return "" + num;
 }

 public int getNum() {
  return num;
 }
 
 public boolean equals(Object other) {
  return ((T)other).getNum() == num;
 }

}