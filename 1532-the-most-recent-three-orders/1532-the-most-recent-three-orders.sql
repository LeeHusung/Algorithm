
select c.name customer_name, c.customer_id, tmp.order_id, tmp.order_date
from customers c
join (
    select *, row_number() over (partition by customer_id order by customer_id, order_date desc) as rownum
    from orders
) tmp
 on c.customer_id = tmp.customer_id
where tmp.rownum <= 3
order by 1, 2, 4 desc