/* Write your PL/SQL query statement below */
select person_name
from (
select person_name
    from (
        select turn, person_id, person_name, weight, sum(weight) over (order by turn) total_sum
        from Queue
        )
    where total_sum <= 1000
    order by total_sum desc
    )
where rownum <= 1