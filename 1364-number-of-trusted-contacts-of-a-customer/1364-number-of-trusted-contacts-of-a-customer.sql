select i.invoice_id, c1.customer_name, i.price, ifnull(t2.cnt, 0) contacts_cnt, ifnull(t3.cnt, 0) trusted_contacts_cnt
from invoices i
join customers c1
 on i.user_id = c1.customer_id
left join (
    select c1.customer_id, count(c1.customer_id) cnt
    from customers c1
    join contacts c2
    on c1.customer_id = c2.user_id
    group by c1.customer_id
) t2
 on t2.customer_id = i.user_id
left join (
    select tmp2.customer_id, count(*) cnt
    from customers tmp1
    join (
    select *
        from customers c1
        left join contacts c2 
        on c1.customer_id = c2.user_id 
    ) tmp2
    on tmp1.customer_name = tmp2.contact_name
    group by tmp2.user_id
) t3
 on t3.customer_id = i.user_id
 order by invoice_id


-- select tmp2.customer_id, count(*) cnt
-- from customers tmp1
-- join (
--    select *
--     from customers c1
--     left join contacts c2 
--     on c1.customer_id = c2.user_id 
-- ) tmp2
--  on tmp1.customer_name = tmp2.contact_name
--  group by tmp2.user_id