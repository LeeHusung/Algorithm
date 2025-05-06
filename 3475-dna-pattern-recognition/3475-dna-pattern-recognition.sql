select sample_id, dna_sequence, species, 
case when SUBSTR(dna_sequence, 0, 3) = 'ATG'
then 1
else 0 end has_start,

case when SUBSTR(dna_sequence, -3, 3) IN ('TAA', 'TAG', 'TGA')
then 1
else 0 end has_stop,

case when dna_sequence like '%ATAT%'
then 1
else 0 end has_atat,

case when dna_sequence like '%GGG%'
then 1
else 0 end has_ggg

from Samples