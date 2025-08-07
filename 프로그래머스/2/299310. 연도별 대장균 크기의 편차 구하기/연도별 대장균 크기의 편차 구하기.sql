select YEAR(t1.DIFFERENTIATION_DATE) YEAR, t2.m - t1.size_of_colony YEAR_DEV, T1.ID
from ECOLI_DATA t1
join (
    select year(DIFFERENTIATION_DATE) y, max(size_of_colony) m
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
    ) t2
    on year(t1.DIFFERENTIATION_DATE) = t2.y
ORDER BY 1, 2;