// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.

// Topic: Sliding Window
/*
- Think of the other way: find the substring with the same size as s1 in s2 which matches all the characters inside
  that string. Or find the anagram of s1 in s2

- Algorithm:
    + Create a 26 size array contain the frequency from 'a' to 'z'
    + Loop through s1 to find the frequency of each character
    + Assign two pointer i,j to the first char in s2
    + Apply sliding window technique to find substring of s2: keep moving i, j to the end of string s2
        . whenever j - i is equal to size of s1, compare the substring with s1 to see if it is anagram of s1 => return true
    + return false
*/

#include <iostream>

using namespace std;

bool checkInclusion(string s1, string s2)
{
    // initialize an array contains the frequency of char from 'a' to 'z'
    int map[26] = {0};

    // calculate the frequency of chars in s1
    for (char c : s1)
        map[c - 'a']++;

    // initialize two pointers and count to keep track the frequency in substring
    int j = 0, i = 0, count_chars = s1.size();

    // move pointers until it reach the end of string
    while (j < s2.size())
    {
        // move pointer j to the right, if character is included in s1,
        // reduce it frequency by 1 and reduce the tracking count variable
        if (map[s2.at(j++) - 'a']-- > 0)
            count_chars--;

        // when count is 0 which means all the char in substring match with all chars in s1
        if (count_chars == 0)
            return true;

        // reach the size of s1 but it does not match s1 => start move pointer i, update the frequency and tracking count
        if (j - i == s1.size() && map[s2.at(i++) - 'a']++ >= 0)
            count_chars++;
    }
    return false;
}

int main()
{
    cout << checkInclusion("abc", "bbcah") << endl;   // true
    cout << checkInclusion("ab", "eidbaooo") << endl; // true
    cout << checkInclusion("ab", "eidboaoo") << endl; // false
}
