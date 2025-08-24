https://leetcode.com/problems/generate-parentheses/description/

Idea

- For generating prob -> think about backtrack
- Use Stack: build step by step by adding ( or )
- recursive call with redo -> call stack.pop()
- Think about when we can add ')'??
  -> only when the number of ) is less than the number of (

eg:
n = 3
openN = 3, closeN = 3
with ( -> openN = 2, closeN = 3 -> can add ) here

Solution:
class Solution:
def generateParenthesis(self, n: int) -> List[str]:
stack = []
res = []

        def backtrack(openNum, closeNum):
            if openNum == closeNum == n:
                res.append("".join(stack))
                return
            if openNum < n:
                stack.append("(")
                backtrack(openNum + 1, closeNum)
                stack.pop()

            if closeNum < openNum:
                stack.append(")")
                backtrack(openNum, closeNum + 1)
                stack.pop()

        backtrack(0,0)
        return res

Solution

```python
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = []
        res = []

        def backtrack(openNum, closeNum):
            if openNum == closeNum == n:
                res.append("".join(stack))
                return
            if openNum < n:
                stack.append("(")
                backtrack(openNum + 1, closeNum)
                stack.pop()

            if closeNum < openNum:
                stack.append(")")
                backtrack(openNum, closeNum + 1)
                stack.pop()

        backtrack(0,0)
        return res
```
