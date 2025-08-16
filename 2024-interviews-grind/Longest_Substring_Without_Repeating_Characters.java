class Solution {
  public int lengthOfLongestSubstring(String s) {
    int l = 0;
    int res = 1;
    Set<Character> hs = new HashSet<>();
    for (int r = 0; r < s.length(); r++) {
      while(hs.contains(s.charAt(r))) {
        hs.remove(s.charAt(l));
        l++;
      }
      hs.add(s.charAt(r));
      res = Math.max(res, r - l + 1);
    }
    return res;
  }
}