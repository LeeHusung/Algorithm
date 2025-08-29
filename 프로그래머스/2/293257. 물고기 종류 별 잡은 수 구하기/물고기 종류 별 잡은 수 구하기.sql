SELECT COUNT(f.id) AS FISH_COUNT,
        n.fish_name AS FISH_NAME
       
FROM fish_name_info n
JOIN fish_info f
       ON n.fish_type = f.fish_type
GROUP BY n.fish_name
ORDER BY FISH_COUNT DESC;
