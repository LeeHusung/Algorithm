select b.book_id, b.name
from books b
left join (
            select o.book_id, sum(o.quantity) salesSum
            from orders o
            where dispatch_date >= '2018-06-23'
            group by o.book_id
            ) tmp
on b.book_id = tmp.book_id
where b.available_from <= '2019-05-23' 
and ifnull(tmp.salesSum, 0) < 10