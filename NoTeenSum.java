public class NoTeenSum {
public static void main(String[] args) {
   noTeenSum(1, 2, 3);
}   

public int noTeenSum(int a, int b, int c) {
  fixTeen(a);
  fixTeen(b);
  fixTeen(c);
  return a + b + c;
}

public int fixTeen(int n) {
  if (( 13 <= n <= 19) && (n!= 15 || n!=16)) {
    return = 0;
  }
  return n;
}
}