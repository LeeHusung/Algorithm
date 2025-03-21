-- 코드를 입력하세요
SELECT FH.FLAVOR
FROM FIRST_HALF FH
JOIN (
    SELECT FLAVOR, SUM(TOTAL_ORDER) SUM
    FROM JULY
    GROUP BY FLAVOR
) TMP
ON FH.FLAVOR = TMP.FLAVOR
ORDER BY (SUM + FH.TOTAL_ORDER) DESC
FETCH FIRST 3 ROW ONLY;