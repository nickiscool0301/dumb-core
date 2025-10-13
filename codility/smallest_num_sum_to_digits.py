'''
Input: 16
output: 79 -> 7 + 9 = 16
'''


def solution(n):
    if n == 0:
        return 0
    digits = []
    while n > 0:
        d = min(9,n)
        digits.append(d)
        n -= d
    return int("".join(digits[::-1]))