WITH TMP (employee_id, employee_name, lv, salary) AS (
    SELECT employee_id, employee_name, 1 as lv, salary
    FROM Employees
    where manager_id is null
    union all
    select t2.employee_id, t2.employee_name, t1.lv + 1, t2.salary
    from TMP t1
    join Employees t2
        on t1.employee_id = t2.manager_id
),
TMP2 (manager_id, subordinate_id, subordinate_salary) AS (
     SELECT
        e.employee_id AS manager_id,
        r.employee_id AS subordinate_id,
        r.salary AS subordinate_salary
    FROM Employees e
    JOIN Employees r ON r.manager_id = e.employee_id
    UNION ALL
    SELECT
        s.manager_id,
        e.employee_id AS subordinate_id,
        e.salary AS subordinate_salary
    FROM TMP2 s
    JOIN Employees e ON e.manager_id = s.subordinate_id 
),

TEAMSIZE AS (
    SELECT manager_id, COUNT(DISTINCT subordinate_id) cnt
    FROM TMP2
    GROUP BY manager_id
)
,
BUDGET AS (
    SELECT manager_id, SUM(SUBORDINATE_SALARY) sm
    FROM TMP2
    GROUP BY manager_id
)
SELECT x1.employee_id, x1.employee_name, x1.lv as "level", COALESCE(x3.cnt, 0) as team_size, COALESCE(x4.sm, 0) + x1.salary as budget
FROM TMP x1
left JOIN TEAMSIZE x3
    ON x1.employee_id = x3.manager_id
left JOIN BUDGET x4
    on x1.employee_id = x4.manager_id
ORDER BY 3, 5 DESC, 2;