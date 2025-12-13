'''
convert the base 10 to base -2
'''

class Solution:
    def convert_baseneg2(self, n: int) -> str:
        if n == 0:
            return "0"
        
        res = []
        while n != 0:
            r = n % (-2)
            n = n // (-2)

            if r < 0:
                r += 2
                n += 1
            res.append(str(r))
        return "".join(reversed(res))
    
if __name__ == "__main__":
    s = Solution()
    print(s.convert_baseneg2(6))
