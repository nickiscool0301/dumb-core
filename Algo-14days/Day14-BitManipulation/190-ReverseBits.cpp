#include <iostream>
#include <unistd.h>

using namespace std;
uint32_t reverseBits(uint32_t n)
{
  if (n == 0)
    return 0;

  int result = 0;
  for (int i = 0; i < 32; i++)
  {
    result <<= 1;
    if ((n & 1) == 1)
      result++;
    n >>= 1;
  }
  return result;
}

int main()
{
  uint32_t num = 43261596;
  cout << reverseBits(num);
}