select t2.name Department, t1.name Employee, t1.salary Salary
from Employee t1
    join Department t2
    on t1.departmentId = t2.id
where 3 > (
    select count(distinct salary)
    from Employee t3
    where t3.departmentId = t1.departmentId
    and t1.salary < t3.salary
)