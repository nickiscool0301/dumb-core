// Given a string s, we can transform every letter individually to be 
// lowercase or uppercase to create another string.
// Return a list of all possible strings we could create. You can return the output in any order.

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }

    public void backtrack(char[] s, int i, List<String> res) {
        if (i == s.length) {
            res.add(new String(s));
            return;
        }
        if (Character.isLetter(s[i])) {
            s[i] = Character.toUpperCase(s[i]);
            backtrack(s, i + 1, res);
            s[i] = Character.toLowerCase(s[i]);
            backtrack(s, i + 1, res);
        } else
            backtrack(s, i + 1, res);
    }
}
