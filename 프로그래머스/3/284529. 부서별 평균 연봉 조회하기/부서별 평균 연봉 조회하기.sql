SELECT HE.DEPT_ID, HD.DEPT_NAME_EN, ROUND(AVGSAL) AVG_SAL
FROM HR_DEPARTMENT HD
JOIN (
    SELECT DEPT_ID, AVG(SAL) AVGSAL
    FROM HR_EMPLOYEES
    GROUP BY DEPT_ID
) HE
    ON HE.DEPT_ID = HD.DEPT_ID
ORDER BY AVG_SAL DESC

