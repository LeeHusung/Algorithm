/* Write your PL/SQL query statement below */
select name
from Employee t1
join (
    select managerId, count(managerId) cnt
    from Employee
    group by managerId
) t2
on t2.managerId = t1.id
where t2.cnt >= 5