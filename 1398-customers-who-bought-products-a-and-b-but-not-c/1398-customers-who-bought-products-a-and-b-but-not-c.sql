select t1.customer_id, t1.customer_name
from customers t1
join (
select customer_id
from orders
group by customer_id
having sum(product_name = 'C') = 0
and sum(product_name = 'A') > 0
and sum(product_name = 'B') > 0
) t2
on t1.customer_id = t2.customer_id
order by 1;