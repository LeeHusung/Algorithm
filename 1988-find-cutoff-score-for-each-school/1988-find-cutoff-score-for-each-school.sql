select s.school_id, IFNULL(MIN(e.score), -1) score
from schools s
left join exam e
on s.capacity >= e.student_count
group by s.school_id