select tmp.followee follower, count(tmp.followee) num
from (
    select f1.followee
    from follow f1
    join follow f2
    on f1.followee = f2.follower
    group by f1.followee
) tmp
join follow f3
where tmp.followee = f3.followee
group by tmp.followee
order by 1;