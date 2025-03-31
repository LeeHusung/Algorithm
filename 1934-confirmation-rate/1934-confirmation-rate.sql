select t3.user_id, nvl(round(confirmedCnt / wholeCnt, 2), 0) confirmation_rate
from (
    select user_id, count(user_id) wholeCnt
    from Confirmations
    group by user_id
) t1
join (
    select user_id, count(user_id) confirmedCnt
    from Confirmations
    where action = 'confirmed'
    group by user_id
) t2
on t1.user_id = t2.user_id
right join Signups t3
on t1.user_id = t3.user_id 


