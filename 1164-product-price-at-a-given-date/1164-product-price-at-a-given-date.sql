select product_id, FIRST_VALUE(new_price) OVER (PARTITION BY product_id order by change_date desc) as price
from Products
where change_date <= '20190816'
union
select product_id, 10
from Products
where product_id not in (select product_id from Products where change_date <= '20190816')