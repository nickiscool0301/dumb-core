/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"


Test row = 4
P           I           N
A       L   S       I   G
Y   A       H   R
P           I

Observation:
- For first and last row, to get next indext: s[0] = P, s[6] = I -> move 3 to the end, then move 3 to I -> 2(4-1) = 6
- For middle row, let say k-th row, besides adding like first and last=> index: i + 6 - 2*k
*/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < numRows; r++) {
            int increment = 2*(numRows - 1);
            for(int i = r; i < s.length(); i+=increment) {
                sb.append(s.charAt(i));
                if(r > 0 && r < numRows - 1 && i + increment - 2*r < s.length()) {
                    sb.append(s.charAt(i + increment - 2*r));
                }
            }
        }
        return sb.toString();
    }
}