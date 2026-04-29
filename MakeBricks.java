import java.util.Scanner;
import java.util.Random;

public class MakeBricks {
public static void main(String[] args) {
   makeBricks(3, 1, 10);
   }
public static boolean makeBricks(int small, int big, int goal) {
  if( goal > (big*5 + small)) {
    return false;
  }
  if ((goal % 5) > small ) {
    return false;
  }
  return true;
}
}