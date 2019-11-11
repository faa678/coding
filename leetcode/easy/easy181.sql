/*
The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------++----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         || Id | Name  | Salary | ManagerId |
| 2  | Henry | 80000  | 4         |+----+-------+--------+-----------+
| 3  | Sam   | 60000  | NULL      || 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      || 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------++----+-------+--------+-----------+
                                    

Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+
*/
/*需要A.Name, 否则报错Column 'Name' in field list is ambiguous*/
/*时间慢*/
select A.Name Employee from Employee A inner join Employee B on A.Salary > B.Salary and A.ManagerId = B.Id


