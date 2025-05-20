-- 코드를 작성해주세요
SELECT ST2.*
FROM (
    SELECT 
        CASE WHEN SUM(IS_FRONT) != 0 AND SUM(IS_PYTHON) != 0 THEN 'A'
             WHEN SUM(IS_C) != 0 THEN 'B'
             WHEN SUM(IS_FRONT) != 0 THEN 'C'
             ELSE 'F' END AS GRADE,
        ST1.ID,
        ST1.EMAIL
    FROM (
        SELECT T2.NAME,
               T2.CATEGORY,
               T1.ID,
               T1.EMAIL,
               CASE WHEN T2.CATEGORY = 'Front End' THEN 1 ELSE 0 END AS IS_FRONT,
               CASE WHEN T2.NAME = 'Python' THEN 1 ELSE 0 END AS IS_PYTHON,
               CASE WHEN T2.NAME = 'C#' THEN 1 ELSE 0 END AS IS_C
        FROM DEVELOPERS T1
            LEFT JOIN SKILLCODES T2
                ON T1.SKILL_CODE & T2.CODE
        ORDER BY T1.ID
    ) ST1
    GROUP BY ST1.ID, ST1.EMAIL
) ST2
WHERE ST2.GRADE != 'F'
ORDER BY ST2.GRADE, ST2.ID;


