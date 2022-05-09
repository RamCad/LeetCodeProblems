import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int length = scan.nextInt();

    int[] intArray = new int[length];
    for(int i = 0; i < length; i++) {
      intArray[i] = scan.nextInt();
    }
    int sum = scan.nextInt();

    printIndices(intArray, sum);

  }

  // Brute force
  private static void printIndices(int[] intArray, int sum) {
    for(int i = 0; i < intArray.length; i++) {
      for(int j = i + 1; j < intArray.length; j++) {
        if(intArray[i] + intArray[j] == sum) {
          System.out.printf("%d %d", i, j);
          return;
         }
      }
    }
    System.out.println("Result not found");
  }

  //More optimal
  private static void printIndicesMap(int[] intArray, int sum) {
    Map<Integer, Integer> indicesMap = new HashMap<>();
    for(int i = 0; i < intArray.length; i++) {
      Integer idx = indicesMap.get(sum - intArray[i]);
      if(idx != null) {
        System.out.printf("%d %d", i, idx);
        return;
      }
      indicesMap.put(intArray[i], i);
    }
    System.out.println("Result not found");
  }

  //even more optimal
  private static void printIndicesAlternateComparison(int[] nums, int target) {
    for (int i = 1; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (nums[j] + nums[j - i] == target) {
          System.out.printf("%d %d", j, j - i);
          return;
        }
      }
    }
  }

}
