/*
Meet the requests follows:
1、The id field is odd, 
2、The movie's description is boring，
3、order by rating desc.
*/
select * from cinema t
where 1=1
and id&1
and t.description <> 'boring'
order by rating desc;
