select tmp1.category as category1, tmp2.category as category2, count(*) as customer_count
from (
    select distinct PP.user_id, PI.category
    from ProductPurchases PP
    join ProductInfo PI
    on PP.product_id = PI.product_id
) tmp1
join (
    select distinct PP.user_id, PI.category
    from ProductPurchases PP
    join ProductInfo PI
    on PP.product_id = PI.product_id
) tmp2
on tmp1.user_id = tmp2.user_id
where tmp1.category < tmp2.category
group by tmp1.category, tmp2.category
having count(*) >= 3
order by 3 desc, 1, 2;