

select u.user_id, u.user_name, u.credit - ifnull(t1.sum, 0) + ifnull(t2.sum, 0) as credit, case when u.credit - ifnull(t1.sum, 0) + ifnull(t2.sum, 0) < 0 then 'Yes' else 'No' end as credit_limit_breached
from users u
left join (
select paid_by, sum(amount) sum
from transactions
group by paid_by
) t1
on u.user_id = t1.paid_by
left join (
select paid_to, sum(amount) sum
from transactions
group by paid_to
) t2
on u.user_id = t2.paid_to