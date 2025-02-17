select case
when MONTH(DIFFERENTIATION_DATE) < 4 THEN CONCAT(1, 'Q')
when MONTH(DIFFERENTIATION_DATE) < 7 THEN CONCAT(2, 'Q')
when MONTH(DIFFERENTIATION_DATE) < 10 THEN CONCAT(3, 'Q')
ELSE CONCAT(4, 'Q') END AS QUARTER,
COUNT(*) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER