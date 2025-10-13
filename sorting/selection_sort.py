'''
Select the smallest(largest) number and place it at the correct position one by one

TC: O(N^2)
SC: O(1)
'''

def selection_sort(arr):
    N = len(arr)
    for i in range(N):
        min_idx = i
        for j in range(i+1,N):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
    return arr