with avg as(
    select format(2 * sum(duration) / (count(duration) * 2), 4) avg
    from calls
)
, temp as (
    select p.id, p.name person_name, p.phone_number, c.name country_name, c.country_code
    from person p
    join country c
    on c.country_code = SUBSTRING_INDEX(p.phone_number, '-', 1) 
)

select t1.country_name country
from (
    select t.country_name, count(c.caller_id) cnt, sum(c.duration) sum
    from temp t
    join calls c
    on t.id = c.caller_id
    group by t.country_name
) t1
join (
    select t.country_name, count(c.caller_id) cnt, sum(c.duration) sum
    from temp t
    join calls c
    on t.id = c.callee_id
    group by t.country_name
) t2
 on t1.country_name = t2.country_name
where (t1.sum + t2.sum) / (t1.cnt + t2.cnt) > (select avg from avg)