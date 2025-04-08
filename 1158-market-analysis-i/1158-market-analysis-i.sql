/* Write your PL/SQL query statement below */
select t1.user_id buyer_id, to_char(t1.join_date, 'YYYY-MM-DD') join_date, nvl(t2.cnt, 0) orders_in_2019
from Users t1
left join (
    select buyer_id, count(buyer_id) cnt
    from Orders
    where to_char(order_date, 'YYYY') = '2019'
    group by buyer_id
    ) t2
    on t1.user_id = t2.buyer_id