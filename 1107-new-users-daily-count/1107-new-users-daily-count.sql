select tmp.activity_date login_date, count(tmp.user_id) user_count
from (
    select user_id, activity, min(activity_date ) activity_date
    from traffic
    where activity = 'login'
    group by user_id, activity
    ) tmp
where tmp.activity_date >= '2019-04-01'
group by tmp.activity_date
order by 1;
