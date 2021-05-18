## 196. Delete Duplicate Emails

Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its
smallest Id.

    +----+------------------+
    | Id | Email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    | 3  | john@example.com |
    +----+------------------+

Id is the primary key column for this table. For example, after running your query, the above Person table should have
the following rows:

    +----+------------------+
    | Id | Email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    +----+------------------+

#### # Write your MySQL query statement below

    1.DELETE FROM Person WHERE Id NOT IN
      (SELECT Id FROM (SELECT MIN(Id) Id FROM Person GROUP BY Email) p);
    
    2.DELETE p2 FROM Person p1 JOIN Person p2 
      ON p2.Email = p1.Email WHERE p2.Id > p1.Id;
    
    3.DELETE p2 FROM Person p1, Person p2
      WHERE p1.Email = p2.Email AND p2.Id > p1.Id;
     