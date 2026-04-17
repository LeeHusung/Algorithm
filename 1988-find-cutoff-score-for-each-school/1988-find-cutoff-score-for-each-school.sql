select s.school_id, IFNULL((
                    select MIN(e.score) min
                    from exam e
                    where s.capacity >= e.student_count
                    ), -1) score
from schools s