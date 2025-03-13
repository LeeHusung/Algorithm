-- 코드를 입력하세요
SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(TMP.SUM * B.PRICE) TOTAL_SALES
FROM BOOK B
JOIN AUTHOR A
ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN (
    SELECT BOOK_ID, SUM(SALES) SUM
    FROM BOOK_SALES BS
    WHERE TO_CHAR(SALES_DATE, 'YYYYMM') = '202201'
    GROUP BY BOOK_ID
    ) TMP
    ON TMP.BOOK_ID = B.BOOK_ID
    
GROUP BY A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY
    ORDER BY AUTHOR_ID, CATEGORY DESC
    