drop database if exists day07;
create database day07;
use day07;

drop table if exists table1;
create table table1(
	mno_pk int , 
    primary key(mno_pk)
);
drop table if exists table2;
create table table2(
	bno_pk int , 
    mno_fk int , 
    primary key(bno_pk) , 
    foreign key(mno_fk) references table1(mno_pk) 
    -- on delete restrict
    -- on delete cascade
    on delete set null
    -- on update restrict
    -- on update cascade
    on update set null
);
-- 샘플
insert into table1 values(1) , (2) , (3) , (4) , (5);
select * from table1;	-- 확인

insert into table2 values(1 , 1) , (2 , 1) , (3 , 2) , (4 , 2) , (5 , 3);
select * from table2;	-- 확인

delete from table1 where mno_pk = 1;	-- 회원번호가 1인 회원삭제 > 삭제 안됨 [해당 pk 값이 다른 테이블에 존재하기 때문에]
delete from table1 where mno_pk = 4;	-- 회원번호가 4인 회원삭제 > 삭제 됨	[해당 pk 값이 다른 테이블에 존재하지 않기 때문에]

update table1 set mno_pk = 6 where mno_pk = 1;	-- 회원번호가 1인 pk 값을 6으로 수정

select * from table1;	-- 확인
select * from table2;

-- 제약조건
	# foreign key() references 테이블명() 제약조건옵션
    # 1. on delete restrict : pk-fk 데이터가 서로 참조하고 있는 데이터/개체가 존재하면 pk 삭제 불가능 [기본값]
    # 2. on delete cascade : pk-fk 데이터가 서로 참조하고 있는 데이터/개체가 존재하면 pk - fk 같이 삭제
    # 3. on delete set null : pk-fk 데이터가 서로 참조하고 있는 데이터/개체가 존재하면 pk 삭제 시 fk는 null 대입/변경
	# 4. on update restrict : 						//						pk 수정 불가능	[기본값]
    # 5. on update cascade	:						//						pk - fk 같이 수정
    # 6. on update set null : 						//						pk 수정 시 fk는 null 대입/변경







