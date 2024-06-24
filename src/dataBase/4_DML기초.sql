-- 데이터베이스 생성
drop database if exists day04;	-- 만약 day04 라는 데이터 베이스가 있으면 삭제
create database day04;	-- 데이터베이스 생성
use day04;	-- day04 데이터베이스 사용

-- 테이블 생성
drop table if exists table1;
create table table1(
	 mno int , 
	 mname varchar(30) not null unique 		-- 중복제거 공백 X
);
     
-- DML : 조작어	
-- 1. insert 2. select 3. update 4. delete
--     (C)        (R)       (U)       (D)
/*
	[1] insert : 레코드(행 , 튜플 , 가로단위) 삽입
		1. 모든 필드에 값 대입 : insert into 테이블명 values (값1 , 값2 , 값3 ~~~);
		2. 특정 필드에 값 대입 : insert into 테이블명(필드명 ,필드명) values (값1 , 값2);
		3. 여러개의 레코드 삽입 : insert into 테이블명(필드명 , 필드명) values (값1 , 값2) , (값1 , 값2) , (값1 , 값2);
        
	[2] select : 레코드(행 , 튜플 , 가로단위) 조회/검색/찾기
		1. 전체 필드 조회 : select * from 테이블명;
        2. 특정 필드 조회 : select 필드명1 , 필드명2 from 테이블명;
        3. 레코드 조건 조회 : select 필드명1 , 필드명2 from 테이블명 where 조건절;
        
	[3] update : 레코드(행 , 튜플 , 가로단위) 필드 값 수정
		1. 특정 필드의 전체 값 수정 : update 테이블명 set 수정할필드명 = 새로운 값;
        2. 특정 필드의 조건에 따른 값 수정 : update 테이블명 set 수정할필드명 = 새로운 값 where 조건절;
        
	[4] delete : 레코드(행 , 튜플 , 가로단위) 삭제
		1. 전체 레코드 삭제 : delete from 테이블명;	    vs    DDL : truncate table 테이블명;
        2. 특정 조건에 따른 레코드 삭제 : delete from 테이블명 where 조건절;
        
*/

-- [1] insert : 레코드(행 , 튜플 , 가로단위) 삽입
# 1. 모든 필드에 값 대입 : insert into 테이블명 values (값1 , 값2 , 값3 ~~~);
insert into table1 values(1,'박명수');

# 2. 특정 필드에 값 대입 : insert into 테이블명(필드명 ,필드명) values (값1 , 값2);
insert into table1(mno , mname) values (2 , '유재석');
insert into table1(mname , mno) values ('신동엽' , 3);
insert into table1(mname) values('서장훈');

# 3. 여러개의 레코드 삽입 : insert into 테이블명(필드명 , 필드명) values (값1 , 값2) , (값1 , 값2) , (값1 , 값2);
insert into table1 values(4 , '강호동') , (5 , '김희철') , (6 , '민경훈');

-- 확인
select * from table1;

-- [2] select : 레코드(행 , 튜플 , 가로단위) 조회/검색/찾기
# 1. 전체 필드 조회 : select *(와일드카드) from 테이블명; 			# * : 모든 필드 조회하는 전체 레코드 검색 
select * from table1;

# 2. 특정 필드 조회 : select 필드명1 , 필드명2 from 테이블명;	
select mno from table1;
select mname from table1;
select mname , mno from table1;

# 3. 레코드 조건 조회 : select 필드명1 , 필드명2 from 테이블명 where 조건절
select * from table1 where mname = '유재석';					# = 같다. (java , js 처럼 = 대입이 아니다.)
		-- 테이블의 mname 필드내 '유재석'인 데이터의 레코드 검색
        
-- [3] update : 레코드(행 , 튜플 , 가로단위) 필드 값 수정
# 1. 특정 필드의 전체 값 수정 : update 테이블명 set 수정할필드명 = 새로운 값;
update table1 set mno = 10;		# 테이블의 mno필드를 10으로 수정alter

# 2. 특정 필드의 조건에 따른 값 수정 : update 테이블명 set 수정할필드명 = 새로운 값 where 조건절;
update table1 set mno = 3 where mname = '유재석';
		-- 테이블의 mname 필드내 '유재석'인 레코드의 mno 필드의 값을 3으로 수정
update table1 set mname = '유재석B' where mno = 3;
		-- 테이블의 mno 필드내 3인 레코드의 mname 필드의 값을 '유재석B'로 수정

select * from table1;

-- [4] delete : 레코드(행 , 튜플 , 가로단위) 삭제
# 2. 특정 조건에 따른 레코드 삭제 : delete from 테이블명 where 조건절;
delete from table1 where mno = 3;
		-- 테이블의 mno 필드가 3인 레코드를 삭제
delete from table1 where mname = '강호동';
		-- 테이블의 mname 필드가 '강호동'인 레코드를 삭제

# 1. 전체 레코드 삭제 : delete from 테이블명;
delete from table1;			-- 전체 레코드 삭제 (느리다 , 취소가능(복구가능))
	# vs
truncate table table1;		-- 전체 레코드 삭제 (빠르다 , 취소불가능(복구불가))

# update , delete는 workbench 에서 기본적으로 차단.. safe mode
# safe mode 끄기
set sql_safe_updates = 0;	# 0 : safe mode 해제 , 1 : 사용

-- [문제1]
insert into employees (
	employee_id , 
	first_name , 
	last_name , 
	email , 
	hire_date , 
	job_id
) values (
	101 , 
	'John' ,
	'Doe' , 
	'johndoe@example.com' , 
	'2024-06-24',
	'IT_PROG'
);

-- [문제2]
insert into products (
	product_id , 
	product_name , 
	category , 
	price , 
	stock_quantity
) values(
	201 , 
    'Wireless Mouse',
    'Electronics' , 
    29.99 , 
    150
);

-- [문제3]
select first_name , email from employees;

-- [문제4]
select product_name , price from products where price = 1000;

-- [문제5]
update employees set email = 'john.doe@company.com' where employee_id = 101;

-- [문제6]
update products set price = 24.99 where product_id = 201;

-- [문제7]
delete from employees where employee_id = 101;

-- [문제8]
delete from products where product_id = 201;






