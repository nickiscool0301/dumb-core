// Write a function that takes an unsigned integer and
//     returns the number of '1' bits it
//     has(also known as the Hamming weight)
//         .

//     Input : n = 00000000000000000000000000001011 Output : 3
//     Explanation : The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

#include <iostream>

int hammingWeight(uint32_t n)
{
    int cnt = 0; // count of set bit
    while (n > 0)
    { // iterate until all bits are traversed
        ++cnt;
        n = n & (n - 1); // change the first set bit from right to 0
    }
    return cnt;
}