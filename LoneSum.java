public class LoneSum {
public static void main(String[] args) {
   loneSum(1, 2, 3);
}   
public static int loneSum(int a, int b, int c) {
  int sum = 0;
  if (a != b && a != c) {
    sum += a;
  }
  if (b != a && b != c) {
    sum += b;
  }
  if (c != a && c != b) {
    sum += c;
  }
  return sum;
  
  // Solution notes: this code is a pretty direct translation
  // of the problem statement.
  // For each of a/b/c, check that it is different from
  // the other two before adding it to the sum variable
}
}