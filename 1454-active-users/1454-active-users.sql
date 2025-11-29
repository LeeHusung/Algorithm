with cte as (
    select *, row_number() over(partition by id order by login_date) rnum
    from (
        select distinct id, login_date
        from logins
    ) tmp
)

select distinct t1.id, t1.name
from accounts t1
join (
    select id, date_sub(login_date, interval rnum day)
    from cte
    group by date_sub(login_date, interval rnum day), id
    having count(id) >= 5
) t2
 on t1.id = t2.id
 order by 1;