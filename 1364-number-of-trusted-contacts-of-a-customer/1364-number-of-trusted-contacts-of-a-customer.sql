-- with cte as (
--     select user_id, contact_email, sum(contact_email in (select email from customers)) contacts_cnt
--     from contacts c1
--     group by user_id
-- )

select i.invoice_id, t1.customer_name, i.price, ifnull(contacts_cnt, 0) contacts_cnt, ifnull(trusted_contacts_cnt, 0) trusted_contacts_cnt
from invoices i
left join customers t1
 on i.user_id = t1.customer_id
left join (
            select user_id, contact_email, count(c1.user_id) contacts_cnt, sum(contact_email in (select email from customers)) trusted_contacts_cnt
        from contacts c1
        group by user_id
) tmp
 on t1.customer_id = tmp.user_id

 order by 1;