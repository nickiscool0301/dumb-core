https://neetcode.io/problems/top-k-elements-in-list

Three approaches:
1. HashMap + List + Sort
2. HashMap + Priority Queue (Heap)
3. Bucket Sort

Details:
1. Use hashmap to count the number of frequent for each number
2. Initialize a list of array
3. For each entry of map, add the key, and value to list.
4. Sort the list by the index of value
5. Loop to k, and put the value from the list to result array

Instead of using List.sort() -> take O(nlogn)
Use priority queue -> 0(nlogk)

For better optimization. Use bucket sort