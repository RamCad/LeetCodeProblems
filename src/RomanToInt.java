import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RomanToInt {


  public static void main(String[] args) {
    Map<Character, Integer> romanToInt = new HashMap<>();
    romanToInt.put('I', 1);
    romanToInt.put('V', 5);
    romanToInt.put('X', 10);
    romanToInt.put('L', 50);
    romanToInt.put('C', 100);
    romanToInt.put('D', 500);
    romanToInt.put('M', 1000);

    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    char[] chars = input.toCharArray();

    romanToInt1(chars, romanToInt);
    romanToInt2(chars, romanToInt);

  }

  private static void romanToInt1(char[] chars, Map<Character, Integer> romanToInt) {
    Map<Integer, List<Character>> charMap = new HashMap<>();
    charMap.put(1, Arrays.asList('V', 'X'));
    charMap.put(10, Arrays.asList('L', 'C'));
    charMap.put(100, Arrays.asList('D', 'M'));

    int temp;
    int sum = 0;
    int prev = 0;
    for (int i = 0; i < chars.length; i++) {
      temp = romanToInt.get(chars[i]);
      List<Character> tempList = charMap.get(prev);
      if (tempList != null && tempList.contains(chars[i])) {
        sum = sum + temp - (2 * prev);
      } else {
        sum += temp;
      }
      prev = temp;
    }
    System.out.println(sum);
  }

  private static void romanToInt2(char[] chars, Map<Character, Integer> romanToInt) {
    int sum = 0;
    for(int i=0; i < chars.length; i++) {
      if(i+1 < chars.length && romanToInt.get(chars[i]) < romanToInt.get(chars[i+1])) {
        sum -= romanToInt.get(chars[i]);
      } else {
        sum += romanToInt.get(chars[i]);
      }
    }
    System.out.println(sum);
  }


}
