import java.util.Random;

public class MakeChocolate {
public static void main(String[] args) {
   makeChocolate(4, 1, 9);
}   
public static int makeChocolate(int small, int big, int goal) {

  if (goal > ( big*5 + small)) {
    return -1;
  }
  if ((goal% 5) > small) {
    return -1;
  }
  if(goal < 5) {
    return small;
  }
  
  if (goal - (big*5) < 0) {
   return (goal - 5);   
  }
  
  if (goal - (big*5) > 0) {
    return ((goal - (big*5))); 
  }
   return 0;
}

}
