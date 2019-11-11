/*
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
*/
                                                                                    /*要有as B*/
select Email from (select Email, count(Email) as num from Person as A group by Email) as B where num > 1

select Email from Person having count(Email) > 1

select Email from Person having count(1) > 1

/*having 关键字！*/