select s1.sale_date, s1.sold_num - s2.sold_num as diff
from sales s1
join sales s2
 on s1.sale_date = s2.sale_date
where s1.fruit = "apples"
and s2.fruit = "oranges"
order by 1;