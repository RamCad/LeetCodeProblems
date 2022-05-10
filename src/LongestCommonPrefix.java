public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = new String[]{"dog","racecar","car"};

//    String str = "";
//    Arrays.sort(strs, Comparator.comparingInt(String::length));
//    System.out.println(strs[0] + " " + strs[1] + " " + strs[2]);
//    List<String> cp = new ArrayList<>();
//    for(int i = 0; i < strs[0].length(); i++) {
//      str = str + strs[0].charAt(i);
//      if(!(strs[1].contains(str) && strs[2].contains(str))) {
//        cp.add(str.substring(0, str.length()-1));
//        str = "";
//      }
//    }
//    if(strs.length > 2 && strs[1].contains(str) && strs[2].contains(str)) {
//      cp.add(str);
//    }
//    cp.stream().filter(s -> !s.isEmpty())
//        .collect(Collectors.toList())
//        .sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));
//    System.out.println(cp.isEmpty() ? "" : cp.get(0));
    lcp(strs);
    lcp1(strs);
  }

  private static String lcp(String[] strs) {
    if (strs.length ==0) return "";
    String cp = strs[0];
    if ( strs.length ==1) return cp;

    for (String s : strs) {
      int len = (cp.length() > s.length()) ? s.length() : cp.length();
      cp = cp.substring(0,len);
      for (int i = 0; i < len; i++) {
        if(s.charAt(i) != cp.charAt(i)) {
          cp = s.substring(0,i);
          break;
        }
      }
    }
    return cp;
  }

    private static String lcp1(String[] strs) {
      if(strs.length == 0) return "";
      if(strs.length == 1) return strs[0];

      String cp = strs[0];

      for(int i = 1; i < strs.length; i++) {
        while(strs[i].indexOf(cp) != 0) {
          cp = cp.substring(0, cp.length() - 1);
          if (cp.isEmpty()) return "";
        }
      }
      return cp;
    }
}
