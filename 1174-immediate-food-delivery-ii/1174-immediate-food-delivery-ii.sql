select ROUND(100* count(case when t2.order_date = t2.customer_pref_delivery_date then 1 end) / count(tmp.customer_id), 2) immediate_percentage
from (
    select distinct t1.customer_id, FIRST_VALUE(t1.order_date) OVER (partition by t1.customer_id order by t1.order_date) order_date
    from Delivery t1
) tmp
join Delivery t2
on tmp.customer_id = t2.customer_id and tmp.order_date = t2.order_date
