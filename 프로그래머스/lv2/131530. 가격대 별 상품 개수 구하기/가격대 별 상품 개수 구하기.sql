-- 코드를 입력하세요
SELECT PRICE - (PRICE % 10000) AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY 1;