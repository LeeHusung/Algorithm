select t2.name Department, t1.name Employee, t1.salary Salary
from (
select departmentId, name, salary, dense_rank() over (partition by departmentId order by salary desc) rank
from Employee
) t1
join Department t2
on t1.departmentId = t2.id
where t1.rank <= 3