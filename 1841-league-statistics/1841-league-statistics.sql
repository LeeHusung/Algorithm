select (select team_name from teams t where t.team_id = t1.team_id) as team_name, sum(t1.matches_played) matches_played, sum(t1.points) as points, sum(t1.goal_for) as goal_for, 
sum(t1.goal_against) goal_against, sum(t1.goal_for) - sum(t1.goal_against) as goal_diff
from (
    select home_team_id team_id, 1 matches_played, home_team_goals as goal_for, away_team_goals as goal_against, case when home_team_goals > away_team_goals then 3
                                    when home_team_goals = away_team_goals then 1
                                    else 0
                                    end as points
    from matches m
    union all
    select away_team_id team_id, 1 matches_played, away_team_goals as goal_for, home_team_goals as goal_against, case when home_team_goals < away_team_goals then 3
                                    when home_team_goals = away_team_goals then 1
                                    else 0
                                    end as points
    from matches m
) t1
group by t1.team_id
order by points desc, goal_diff desc, team_name