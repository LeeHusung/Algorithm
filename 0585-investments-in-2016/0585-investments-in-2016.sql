select round(sum(t1.tiv_2016), 2) tiv_2016
from Insurance t1
join (
    select tiv_2015, sum(tiv_2016)
    from Insurance
    group by tiv_2015
    having count(tiv_2015) >= 2
) t2
on t1.tiv_2015 = t2.tiv_2015
join (
    select distinct lat, lon
    from Insurance
    group by lat, lon
    having count(lat) < 2
) t3
on t1.lat = t3.lat and t1.lon = t3.lon