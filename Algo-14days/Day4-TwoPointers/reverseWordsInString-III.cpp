// Other approach in C++

// Basically loop through each character in string
// When it meets the ' ' character, reverse the string from the begin to the current index
// Finally, reverse the last word in string then return the final answer

#include <iostream>
#include <algorithm> // std::reverse

using namespace std;

string reverseWords(string s)
{
    int i = 0;
    for (int j = 0; j < s.size(); j++)
    {
        if (s[j] == ' ')
        {
            reverse(s.begin() + i, s.begin() + j);
            i = j + 1;
        }
    }
    reverse(s.begin() + i, s.end());
    return s;
}

int main()
{
    string s = "Let's go to school";
    cout << reverseWords(s) << endl;
}