select II.item_id, II.item_name, II.rarity
from ITEM_INFO II
join (
    select item_id
    from ITEM_INFO II
    where item_id not in (select distinct PARENT_ITEM_ID from ITEM_TREE where parent_item_id is not null)
    ) TMP
on II.item_id = TMP.item_id
order by 1 desc