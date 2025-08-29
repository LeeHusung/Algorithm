select t1.cnt fish_count, t2.fish_name
from (
    select count(id) cnt, fish_type
    from fish_info
    group by fish_type
) t1
left join fish_name_info t2
    on t1.fish_type = t2.fish_type
order by 1 desc