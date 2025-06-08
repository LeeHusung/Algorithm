-- 코드를 입력하세요
SELECT count(distinct(name)) count
from ANIMAL_INS
where NAME IS NOT NULL