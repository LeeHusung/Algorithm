select t1.left_operand, t1.operator, t1.right_operand
, case when tmp_left_operand > tmp_right_operand and operator = ">" then "true"
  when tmp_left_operand > tmp_right_operand and (operator = "=" or operator = "<") then "false"
  when tmp_left_operand > tmp_right_operand and (operator = "=" or operator = "<") then "false"
  when tmp_left_operand < tmp_right_operand and operator = "<" then "true"
  when tmp_left_operand < tmp_right_operand and (operator = "=" or operator = ">") then "false"
  when tmp_left_operand = tmp_right_operand and operator = "=" then "true"
  when tmp_left_operand = tmp_right_operand and operator != "=" then "false"
end as value
from (
    select (
        select value
        from variables v
        where e.left_operand = v.name
    ) tmp_left_operand, operator, (
        select value
        from variables v
        where e.right_operand = v.name
    ) tmp_right_operand, e.left_operand, e.right_operand
    from expressions e
) t1