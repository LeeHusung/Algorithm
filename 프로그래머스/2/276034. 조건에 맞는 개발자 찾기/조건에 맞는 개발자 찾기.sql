SELECT T1.ID, T1.EMAIL, T1.FIRST_NAME, T1.LAST_NAME
FROM DEVELOPERS T1
WHERE T1.SKILL_CODE & (SELECT CODE
                        FROM SKILLCODES
                        WHERE NAME = 'Python')
                        > 0
        OR 
        T1.SKILL_CODE & (SELECT CODE
                        FROM SKILLCODES
                        WHERE NAME = 'C#')
                        > 0
ORDER BY 1;

# SELECT CODE
# FROM SKILLCODES
# WHERE NAME = 'Python' OR NAME = 'C#';