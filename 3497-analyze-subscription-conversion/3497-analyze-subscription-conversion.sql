/* Write your PL/SQL query statement below */
select t1.user_id, ROUND(t2.trial_avg_duration, 2) trial_avg_duration, ROUND(t1.paid_avg_duration, 2) paid_avg_duration
from (
    select user_id, sum(activity_duration) / count(activity_date) paid_avg_duration
    from UserActivity
    where activity_type = 'paid'
    group by user_id
) t1
join (
    select user_id, sum(activity_duration) / count(activity_date) trial_avg_duration
    from UserActivity
    where activity_type = 'free_trial'
    group by user_id
) t2
on t1.user_id = t2.user_id
order by user_id