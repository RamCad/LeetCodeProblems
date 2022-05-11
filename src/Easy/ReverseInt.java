package Easy;

import java.util.Scanner;

public class ReverseInt {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    System.out.println(printReverse(x));
    System.out.println(printReverseInt(x));
  }

  //dirty but works
  public static int printReverse(int x) {
    String str = "";
    if (x < 0) {
      x = Math.abs(x);
      str = "-";
    }
    while(x > 0){
      str = str.concat(String.valueOf(x%10));
      x /= 10;
    }
    try {
      return str.equals("") ? 0 : Integer.valueOf(str);
    } catch(NumberFormatException nfe) {
      return 0;
    }
  }

  public static int printReverseInt(int x) {
    int temp = Math.abs(x);
    long result = 0;
    while(temp != 0) {
      result = (result*10) + (temp%10);
      temp /= 10;
    }
    if (x < 0) {
      result *= -1;
    }
    return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int) result;
  }

}
