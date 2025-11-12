select min(log_id) start_id, max(log_id) end_id
from (
    select log_id, row_number() over (order by log_id) rnum
    from logs
) t1
group by t1.log_id - t1.rnum
order by start_id