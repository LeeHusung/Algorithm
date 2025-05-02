/* Write your PL/SQL query statement below */
select tmp.id, to_char(tmp.visit_date, 'YYYY-MM-DD') visit_date, tmp.people
from (
    select s1.*
    from Stadium s1
        where s1.people > 99
        and s1.id + 1 in (select t2.id from Stadium t2 where t2.people > 99)
        and s1.id - 1 in (select t3.id from Stadium t3 where t3.people > 99)
    union
    select s1.*
    from Stadium s1
        where s1.people > 99
         and s1.id + 1 in (select t2.id from Stadium t2 where t2.people > 99)
        and s1.id + 2 in (select t3.id from Stadium t3 where t3.people > 99)
    union
    select s1.*
    from Stadium s1
        where s1.people > 99
        and s1.id - 2 in (select t2.id from Stadium t2 where t2.people > 99)
        and s1.id - 1 in (select t3.id from Stadium t3 where t3.people > 99)
) tmp
order by visit_date