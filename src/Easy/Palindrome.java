package Easy;

import java.util.Scanner;

public class Palindrome {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();

    isPalindrome(input);
  }

  private static void isPalindrome(int input) {
    if(input < 0) {
      System.out.println(false);
    } else {
      int y = 0;
      int temp = input;
      while(temp > 0) {
        y = (y*10) + temp%10;
        temp = temp/10;
      }
      if (input == y) {
        System.out.println(true);
      } else {
        System.out.println(false);
      }
    }
  }

}
