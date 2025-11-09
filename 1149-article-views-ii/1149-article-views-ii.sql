select distinct t1.viewer_id as id
from (
    select distinct *
    from views
) t1
group by t1.view_date, t1.viewer_id
having count(t1.viewer_id) > 1
order by id