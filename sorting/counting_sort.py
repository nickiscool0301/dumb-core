'''
- counting sort algorithm
TC: O(N + K) where K is the max of array
SC: O(N + K). If use inplace -> O(K)
if K is too large -> not efficient

'''


def count_sort(arr):
    N = len(arr)
    maxx = max(arr)
    count = [0] * (maxx + 1)
    
    for num in arr:
        count[num] += 1

    i = 0
    for c in range(maxx + 1):
        while count[c] > 0:
            arr[i] = c
            i += 1
            count[c] -= 1
    return arr
