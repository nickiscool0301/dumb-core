URL: https://leetcode.com/problems/maximum-matrix-sum/description/?envType=daily-question&envId=2024-11-24

Topic:
- 2D Array Manipulation

Idea: 
- If all positive number: just sum all and return
- If having even negative number, just sum all abs and return
- If having odd negative number, there will be one left negative number, otheres are converted to positive

## 11/24/2025
- keep tracking of all negative number count for return result
- Keep update the sum, rmb that we sum abs value
- Keep update the min value for negative number (just smallest number)
- in case of odd -> return sum - 2*min 
  - Why 2? Since the sum already contains the value of abs of min before

