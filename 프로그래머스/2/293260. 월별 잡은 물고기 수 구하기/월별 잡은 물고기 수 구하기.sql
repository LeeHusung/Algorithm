select count(id) FISH_COUNT, MONTH(TIME) MONTH
FROM FISH_INFO
GROUP BY MONTH(TIME)
ORDER BY 2;