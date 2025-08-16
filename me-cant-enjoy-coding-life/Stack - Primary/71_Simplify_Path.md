## URL: https://leetcode.com/problems/simplify-path/description/


## Topic
- Use traditional stack method
- In Java, Stack class is old (from Vector)
- Use Deque for better performance (no synchronize)


## Solution
- split the given input by "/"
- From the problem, we ignore ".", "..", and ""
- Create a set to blacklist those ignored character
- Loop through each character after split the input
- If facing "..", pop out from the stack
- If not in blacklist, add to the stack

- Create a STringBuilder
- For each String in stack, append to sb with "/" + str
- If the sb is empty, jus return "/". Otherwise, return sb.toString()


```java
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> blackList = new HashSet<>(Arrays.asList("..", ".",""));

        for(String str : path.split("/")) {
            if(str.equals("..") && !stack.isEmpty()) stack.removeLast();
            else if(!blackList.contains(str)) stack.addLast(str);
        }

        StringBuilder res = new StringBuilder();
        for (String str : stack) {
            res.append("/").append(str);
        }
        return res.length() == 0 ? "/" : res.toString();
        
    }
}
```