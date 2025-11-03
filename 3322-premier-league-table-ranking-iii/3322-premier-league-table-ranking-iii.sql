select tmp.season_id, tmp.team_id, tmp.team_name, tmp.points, tmp.goal_difference, tmp.position
from (
    select season_id, team_id, team_name, wins * 3 + draws * 1 as points, goals_for - goals_against as goal_difference, row_number() over (partition by season_id order by season_id, wins * 3 + draws * 1 desc, goals_for - goals_against desc, team_name) as position
    from seasonstats
    order by season_id, points desc, goal_difference desc, team_name
    ) tmp