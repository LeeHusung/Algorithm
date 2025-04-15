select requester_id id, num
from (
select requester_id, sum(cnt) num
from (
select requester_id, count(requester_id) cnt
from RequestAccepted
group by requester_id
union all
select accepter_id , count(accepter_id) cnt
from RequestAccepted
group by accepter_id 
)
group by requester_id
order by num desc
)
where rownum <= 1