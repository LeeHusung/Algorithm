select tmp1.student_id, tmp1.subject, tmp2.minScore first_score, tmp1.maxScore latest_score
from (
    select t1.student_id, t1.subject, t1.score maxScore, t2.max
    from Scores t1
    join (
    select student_id, subject, max(exam_date) max
        from Scores
        group by student_id, subject
        having count(student_id) >= 2
    ) t2
    on t1.student_id = t2.student_id and t1.subject = t2.subject and t1.exam_date = t2.max
    ) tmp1
join (
    select t1.student_id, t1.subject, t1.score minScore, t2.min
    from Scores t1
    join (
    select student_id, subject, min(exam_date) min
        from Scores
        group by student_id, subject
        having count(student_id) >= 2
    ) t2
    on t1.student_id = t2.student_id and t1.subject = t2.subject and t1.exam_date = t2.min
    ) tmp2
on tmp1.student_id = tmp2.student_id and tmp1.subject = tmp2.subject
where maxScore > minScore
order by 1, 2