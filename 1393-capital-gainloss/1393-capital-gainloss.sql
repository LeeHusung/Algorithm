/* Write your PL/SQL query statement below */
select t1.stock_name, t2.sum - t1.sum capital_gain_loss
from (
    select stock_name, sum(price) sum
    from Stocks
    where operation = 'Buy'
    group by stock_name
) t1
join (
    select stock_name, sum(price) sum
    from Stocks
    where operation = 'Sell'
    group by stock_name
) t2
on t1.stock_name = t2.stock_name