package Easy;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {

  public static void main(String[] args) {
    String str = "[{()}]"; //valid case
    String str1 = "[{]}"; //invalid case

    System.out.println(validParenthesis(str));
    System.out.println(validParenthesis(str1));
  }

  private static boolean validParenthesis(String str) {
    if(str.length() == 0) return true;
    if(str.length() == 1) return false;
    List<Character> chars = new ArrayList<>();
    if(str.charAt(0) == ']' || str.charAt(0) == '}' || str.charAt(0) == ')') {
      return false;
    }
    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
        chars.add(str.charAt(i));
      } else {
        if(chars.isEmpty() && (str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')')) {
          return false;
        }
        if(str.charAt(i) == ']' && chars.get(chars.size()-1) == '[') {
          chars.remove(chars.size()-1);
        } else if(str.charAt(i) == '}' && chars.get(chars.size()-1) == '{') {
          chars.remove(chars.size()-1);
        } else if(str.charAt(i) == ')' && chars.get(chars.size()-1) == '(') {
          chars.remove(chars.size()-1);
        } else {
          return false;
        }
      }
    }
    return chars.isEmpty();
  }

}
