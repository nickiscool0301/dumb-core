/*Sum two large numbers that are represented as strings
str1 = "1234567890987654321"
str2 = "9876543210123456789"
res = "11111111101111111110"


For this problem, we have two approaches:
- use BigInteger to handle the big number
- use normal while loop and mathematics to solve:

 */

public static String calculateSum(String str1, String str2) {
  StringBuilder res = new StringBuilder();
  //make sure one string is large
  if(str1.length() > str2.length()) {
    String temp = str1;
    str1 = str2;
    str2 = temp;
  }
  int l1 = str1.length();
  int l2 = str2.length();
  int carry = 0;

  str1 = new StringBuilder(str1).reverse().toString();
  str2 = new StringBuilder(str2).reverse().toString();

  //loop through shorter string first
  for(int i = 0; i < l1; i++) {
    int sum = ((int) (str1.charAt(i) - '0') + (int)(str2.charAt(i) - '0') + carry);
    res.append((sum % 10));
    carry = sum / 10;
  }

  //fill out the left over
  for(int i = l1; i < l2; i++) {
    int sum = (int)(str2.charAt(i) - '0') + carry;
    res.append((sum % 10));
    carry = sum / 10;
  }

  //fill the carry
  if(carry > 0) res.append(carry);
  return res.reverse().toString();
}