select round(cnt / (select count(distinct player_id) from Activity) , 2) fraction
from (
select count(t1.player_id) cnt
from Activity t1
join 
    (
    select player_id, min(event_date) event_date
    from Activity
    group by player_id
    ) t2
    on t1.player_id = t2.player_id
    and t1.event_date - 1 = t2.event_date
)