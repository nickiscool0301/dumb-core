### URL: https://leetcode.com/problems/second-highest-salary/submissions/1482914740/

### Think process
Notes: should handle case
- Table only has one salary value
- Table have two same salary number 
Both cases should return null


There are two ways:
- use offset:
```sql
SELECT (select DISTINCT salary from Employee ORDER BY salary DESC LIMIT 1 OFFSET 1) AS SecondHighestSalary
```
- not use offset
```sql
select max(salary) AS SecondHighestSalary FROM Employee WHERE salary < (SELECT max(salary) from Employee)
```