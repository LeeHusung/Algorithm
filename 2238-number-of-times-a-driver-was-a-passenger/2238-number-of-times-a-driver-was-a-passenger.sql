select t1.driver_id, count(distinct t2.ride_id) cnt
from rides t1
left join rides t2
 on t1.driver_id = t2.passenger_id
group by t1.driver_id