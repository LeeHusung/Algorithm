select t3.customer_id
from (
    select customer_id, datediff(max(transaction_date), min(transaction_date))
    from customer_transactions
    where transaction_type = 'purchase'
    group by customer_id
    having count(transaction_id) >= 3
) t3
join (
    select customer_id
    from customer_transactions
    group by customer_id
    having datediff(max(transaction_date), min(transaction_date)) >= 30
) t5
on t3.customer_id = t5.customer_id
join (
    select t1.customer_id
    from (
        select customer_id, (select count(transaction_id) from customer_transactions where transaction_type = 'refund' and customer_id = tmp.customer_id) / 
        (select count(transaction_id) from customer_transactions where customer_id = tmp.customer_id) cnt
        from customer_transactions tmp
        group by customer_id
    ) t1
    where t1.cnt < 0.2
) t4
on t3.customer_id = t4.customer_id
order by t3.customer_id