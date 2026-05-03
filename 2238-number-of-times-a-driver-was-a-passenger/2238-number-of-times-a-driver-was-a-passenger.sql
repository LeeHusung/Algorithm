select t1.driver_id, count(t2.passenger_id) cnt
from (
    select driver_id
    from rides t1
    group by driver_id
    ) t1
left join rides t2
 on t1.driver_id = t2.passenger_id
group by t1.driver_id