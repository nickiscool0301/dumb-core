'''
return min num of letters need to be deleted from S -> obtains A..B..

Eg:
Input: BAAABAB
Output: 2 -> remove B and B

Input: BBABAA
Output: 3 -> remove all B or all A

Input: AABBBB
Output: 0 
'''

def solution(S):
    total_A = S.count('A')
    b_before = 0
    a_after = total_A
    res = 0

    for c in S:
        if c == 'A':
            a_after -= 1
        res = min(res, b_before + a_after)
        if c == 'B':
            b_before += 1
    return res

        