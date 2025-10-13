'''
Take one element at a time and insert it into the correct position among teh sorted part
Worst:
TC: O(N^2)
SC: O(1)
'''

def insertion_sort(arr):
    N = len(arr)
    for i in range(1, N):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = key
    return arr


def insertion_sort2(arr):
    N = len(arr)
    for i in range(1, N):
        for j in range(i,0,-1):
            if arr[j-1] > arr[j]:
                arr[j-1], arr[j] = arr[j], arr[j-1]
            else:
                break
    return arr