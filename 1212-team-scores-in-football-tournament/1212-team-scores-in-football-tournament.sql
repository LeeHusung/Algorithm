select t.team_id, t.team_name,
    sum(case when t.team_id = m.host_team and host_goals > guest_goals then 3
             when t.team_id = m.guest_team and host_goals < guest_goals then 3
             when (t.team_id = m.host_team or t.team_id = m.guest_team) and host_goals = guest_goals then 1
             else 0 end) as num_points
from matches m
right join teams t
 on m.host_team = t.team_id or m.guest_team = t.team_id
group by t.team_id
order by num_points desc, team_id