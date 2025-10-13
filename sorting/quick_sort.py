'''
- pick pivot
- partition array around pivot
- recursively sort left and right of the pivot

TC: O(N log N) avg, O(N^2) worst
SC: O(log N) - recursion stack
'''

def quick_sort(arr):
    N = len(arr)

    if N <= 1:
        return arr
    
    p = arr[-1]

    L = [x for x in arr[:-1] if x <= p]
    R = [x for x in arr[:-1] if x > p]

    L = quick_sort(L)
    R = quick_sort(R)

    return L + [p] + R
