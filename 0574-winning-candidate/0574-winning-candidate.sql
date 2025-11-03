select name
from candidate
where (
select candidateId
from vote
group by candidateId
order by count(candidateId) desc
limit 1) = id