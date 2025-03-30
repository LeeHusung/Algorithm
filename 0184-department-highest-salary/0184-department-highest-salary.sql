/* Write your PL/SQL query statement below */
select t1.name Department, t3.name Employee, t2.salary Salary
from Department t1
join (
    select max(salary) salary, departmentId
    from Employee
    group by departmentId
) t2
on t1.id = t2.departmentId
join Employee t3
on t2.departmentId = t3.departmentId and t2.salary = t3.salary