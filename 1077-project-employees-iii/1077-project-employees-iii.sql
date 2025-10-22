select p.project_id, e.employee_id
from (
    select p.project_id, max(experience_years) max
    from project p
    join employee e
    on p.employee_id = e.employee_id
    group by p.project_id
) tmp
join Project p
 on p.project_id= tmp.project_id
join Employee e
 on p.employee_id = e.employee_id
where max =  e.experience_years