/*
	제약조건
		1. not null			: 해당 필드에 null 값을 포함하지 않는다.
        2. default			: 해당 필드의 기본값 설정
        3. unique 			: 해당 필드내 중복된 값을 허용하지 않는다.[중복제거]
        4. auto_increment 	: 레코드 삽입시 해당 필드내 자동번호 부여 , (MYSQL)
*/

-- 데이터베이스생성
drop database if exists day03;
create database day03;

-- 테이블생성
use day03;
drop table if exists member;
create table member(
	회원번호 int , 아이디 varchar(30) , 비밀번호 varchar(30) , 
    연락처 char(13) , 광고전송여부 boolean , 가입일 datetime
);
show tables;				-- 현재 DB내 모든 테이블 확인
select * from member;		-- 태이블 검색

-- 제약조건
-- 1. not null : 해당 필드에 null 값을 포함하지 않는다.
	-- 레코드(insert) 등록 시 해당 필드에 대입 값이 없을 때 기본적으로 null이 대입
create table t1( tno int not null , tname varchar(10) );
	-- 레코드/행/튜플 추가
		-- values(값1 , 값2) 만약에 앞에 필드명을 생략 시 필드명 순서대로 값 대입
insert into t1 value( 1 , '유재석' );
		-- values(값1 , 값2) 만약에 앞에 필드명을 작성 시 명시된 순서대로 값 대입
insert into t1 (tno , tname) values(2 , '강호동');
insert into t1 (tname , tno) values('하하' , 3);

insert into t1 (tname) values ('서장훈');		-- 오류	: 값을 대입하지 않는 필드가 not null 이기 때문에
insert into t1 (tno) values(4);				-- 오류X  : 값을 대입하지 않는 필드가 not null 하지 않았기 때문에
-- 확인
select * from t1;

-- 2. default : 해당 필드의 기본값 설정
	-- 만약에 레코드 삽입 시 해당 필드에 값을 대입하지 않으면 기본값으로 설정할 값
create table t2(
	tno int not null , tname varchar(20) , 
    tdate datetime default now() , tstate int default 10
);
	-- 레코드 추가
insert into t2(tno , tname) values(1 , '유재석');		-- 생략된 tdate , tstate ???
insert into t2 values(1 , '강호동' , '2024-06-21 11:00:30' , 3);

select * from t2;

-- 3. unique : 해당 필드내 중복된 값을 허용하지 않는다. (중복제거)
	-- 만약에 레코드 삽입 시 해당 필드에 값을 대입할 때 기존 레코드 내 동일값이 있으면
drop table if exists t3;
create table t3( tno int not null unique, tname varchar(10) , tpoint int default 100 );
	-- 
    insert into t3 (tno) values (1);
    insert into t3 ( tno , tname ) values ( 1 , '유재석');	-- tno에 동일한 값이 존재해서 오류
    
select * from t3;

-- 4. auto_increment : 레코드 삽입 시 해당 필드내 자동번호 부여
create table t4( tno int not null unique auto_increment , tname varchar(10) default '아무개');
insert into t4 (tname) values ('유재석');		-- 실행 * 4 , 자동으로 tno가 1씩 증가하면서 대입,
delete from t4 where tno = 3;	-- tno가 '3'인 레코드 삭제
		-- 레코드 삭제 후 레코드 생성 : 삭제된 자동 번호는 더이상 생성되지 않고 마지막 번호에 이어서 1씩 증가
select * from t4;

-- 5. primary key : 기본(primary) 키 , 레코드내 식별 가능한 고유값 가진 키 , 참조 당하는 키
	-- unique 포함 , not null 포함
    -- primary key(선정할필드명)
create table t5(
	tno_pk int , 
    tname varchar(30) , 
    primary key(tno_pk)
);
select * from t5;

-- 6. foreign key : 외래(foreign) 키 , 다른 테이블내 기본키를 참조하는 키 , 참조하는 키
create table t6(
	title text , tno_fk int , 
    foreign key(tno_fk) references t5(tno_pk)
);
select * from t6;
-- 워크벤치 상단 메뉴 -> database -> reverse engineer Ctrl+R

-- 예시

-- 1. 회원
drop table if exists m;
create table m(
	mno_pk int auto_increment, 
	mname varchar(10) ,
	mphone char(13) , 
	primary key(mno_pk)		-- 해당 필드를 pk로 설정
	 );
-- 2. 게시물
drop table if exists b;
create table b(
	bno_pk int auto_increment, 
	btitle varchar(100) , 
	bcontent longtext , 
	bdate datetime default now() , 
	primary key(bno_pk) , 		-- 해당 필드를 pk로 설정
    mno_fk int , foreign key(mno_fk) references m(mno_pk)	-- 해당 필드를 fk로 설정
	);
-- 3. 댓글
drop table if exists r;
create table r(
	rno_pk int auto_increment,
    rcontent text ,
    rpwd varchar(20) , 
	primary key(rno_pk) , 		-- 해당 필드를 pk로 설정
    bno_fk int , foreign key(bno_fk) references b(bno_pk) ,	-- 해당 필드를 fk로 설정
    mno_fk int , foreign key(mno_fk) references m(mno_pk)	-- 해당 필드를 fk로 설정
	);

-- 어제 실습 데이터 베이스

drop table if exists categoryTable;
create table categoryTable(
	categoryCode_pk int auto_increment , 
    categoryName varchar(30) , 
    primary key(categoryCode_pk)	
);

drop table if exists productTable;
create table productTable(
	productCode_pk int auto_increment , 
    productName varchar(30) , 
    productPrice int , 
    primary key(productCode_pk) , 
    categoryCode_fk int , foreign key(categoryCode_fk) references categoryTable(categoryCode_pk)
);
    
drop table if exists orderTable;
create table orderTable(
	orderCode_pk int auto_increment, 
    orderDate datetime default now() , 
    primary key(orderCode_pk)
);

drop table if exists orderDetailTable;
create table orderDetailTable(
	orderDetailTable_pk int auto_increment , 
    orderAmount int , 
    primary key(orderDetailTable_pk) , 
    productCode_fk int , foreign key(productCode_fk) references productTable(productCode_pk) , 
    orderCode_fk int, foreign key(orderCode_fk) references orderTable(orderCode_pk)
);











