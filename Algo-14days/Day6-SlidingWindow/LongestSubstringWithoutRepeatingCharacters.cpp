// Given a string s, find the length of the longest substring without repeating characters.

/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Pseudo code:
1. Initialize hash map: key is character, key-value is its position in the string
2. Initialize two pointers
3. Move one pointer to scan through the string
    . If one character is already in the hashmap, move the other pointer to the right of the same character last found
    . Update the hashmap
    . Calculate max length of substring is the difference between two pointer + 1


*/

#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;

int lengthOfLongestSubstring(string s)
{
    // check empty String
    if (s.size() == 0)
        return 0;
    // Initialize map to store char and its position in string
    unordered_map<char, int> map;
    int max_length = 0;

    // loop to move pointer to the right
    for (int i = 0, j = 0; i < s.size(); i++)
    {
        // if the character is already in the map
        if (map.count(s.at(i)) > 0)
        {
            // update its position - use max() for correctness - ex: abba, when i = 4, j should be at 2 instead of 1
            j = max(j, map[s.at(i)] + 1);
        }
        map[s.at(i)] = i;                        // update the map
        max_length = max(max_length, i - j + 1); // calculate the maximum length of substring
    }
    return max_length;
}

int main()
{
    cout << lengthOfLongestSubstring("abcabcbb") << endl;
    cout << lengthOfLongestSubstring("bbbbb") << endl;
    cout << lengthOfLongestSubstring("pwwkew") << endl;
    cout << lengthOfLongestSubstring("") << endl;
}