SELECT T1.month, T1.country, T1.trans_count, NVL(T2.approved_count, 0) approved_count, T1.trans_total_amount, NVL(T2.approved_total_amount, 0) approved_total_amount
FROM (
    SELECT TO_CHAR(TRANS_DATE, 'YYYY-MM') month, country, COUNT(ID) trans_count, SUM(AMOUNT) trans_total_amount
    FROM Transactions 
    GROUP BY TO_CHAR(TRANS_DATE, 'YYYY-MM'), COUNTRY
) T1
LEFT JOIN (
    SELECT TO_CHAR(t1.TRANS_DATE, 'YYYY-MM') month, t1.country, count(t1.ID) approved_count, sum(t1.amount) approved_total_amount
    FROM Transactions t1
    where t1.state = 'approved'
    GROUP BY TO_CHAR(t1.TRANS_DATE, 'YYYY-MM'), t1.COUNTRY
) T2
ON T1.month = t2.month and NVL(T2.country, 0) = NVL(t1.country, 0)