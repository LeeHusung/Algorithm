with trans as (
    select date_format(trans_date, '%Y-%m') month, country, count(id) approved_count, sum(amount) approved_amount
    from transactions
    where state = 'approved'
    group by date_format(trans_date, '%Y-%m'), country
),
charge as (
    select date_format(t1.trans_date, '%Y-%m') month, t2.country, count(t1.trans_id) chargeback_count, sum(t2.amount) chargeback_amount
    from chargebacks t1
    join transactions t2
    on t1.trans_id = t2.id
    group by date_format(t1.trans_date, '%Y-%m'), t2.country
)

select t.month, t.country, t.approved_count, t.approved_amount, ifnull(c.chargeback_count, 0) chargeback_count, ifnull(c.chargeback_amount, 0) chargeback_amount
from trans t
left join charge c
 on t.month = c.month
 and t.country = c.country
union
select c.month, c.country, ifnull(t.approved_count, 0) approved_count, ifnull(t.approved_amount, 0) approved_amount, c.chargeback_count, c.chargeback_amount
from charge c
left join trans t
 on t.month = c.month
 and t.country = c.country