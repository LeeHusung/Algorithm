select t1.employee_id, t2.employee_name, t2.department
, count(t1.employee_id) meeting_heavy_weeks
from (
    SELECT employee_id, DATE_SUB(meeting_date, INTERVAL WEEKDAY(meeting_date) DAY) tmp
    from meetings
    group by employee_id, DATE_SUB(meeting_date, INTERVAL WEEKDAY(meeting_date) DAY)
    having sum(duration_hours) > 20
) t1
join employees t2
 on t1.employee_id = t2.employee_id
group by t1.employee_id
having count(t1.employee_id) >= 2
order by meeting_heavy_weeks desc, employee_name