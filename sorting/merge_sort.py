'''
- divide and conquer

TC: O(N log N)
SC: O(N) - can be logN with linked list
'''

def merge_sort(arr):
    N = len(arr)
    if N == 1:
        return arr

    m = N // 2
    L = arr[:m]
    R = arr[m:]
    left_sorted = merge_sort(L)
    right_sorted = merge_sort(R)
    return merge(left_sorted, right_sorted)

def merge(L, R, N):
    sorted_arr = [0] * N 
    i,j = 0,0
    idx = 0
    while i < len(L) and j < len(R):
        if L[i] < R[j]:
            sorted_arr[idx] = L[i]
            i += 1
        else:
            sorted_arr[idx] = R[j]
            j += 1
        idx += 1
    while i < len(L):
        sorted_arr[idx] = L[i]
        i += 1
        idx += 1
    while j < len(R):
        sorted_arr[idx] = R[j]
        j += 1
        idx += 1
    return sorted_arr
