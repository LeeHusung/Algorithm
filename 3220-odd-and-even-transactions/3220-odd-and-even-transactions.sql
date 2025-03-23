select COALESCE(t1.transaction_date, t2.transaction_date) AS transaction_date, nvl(t2.odd_sum, 0) odd_sum, nvl(t1.even_sum, 0) even_sum
from (
    select TO_CHAR(t1.transaction_date, 'YYYY-MM-DD') transaction_date, SUM(t1.amount) even_sum
    from transactions t1
    where MOD(t1.amount, 2) = 0
    group by TO_CHAR(t1.transaction_date, 'YYYY-MM-DD')
) t1
full outer join (
    select TO_CHAR(transaction_date, 'YYYY-MM-DD') transaction_date, SUM(amount) odd_sum
    from transactions
    where MOD(amount, 2) = 1
    group by TO_CHAR(transaction_date, 'YYYY-MM-DD')
) t2
on t1.transaction_date = t2.transaction_date
order by 1