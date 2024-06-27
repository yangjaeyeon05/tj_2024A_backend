drop database if exists day06;
create database day06;
use day06;

-- 1. 회원테이블
drop table if exists member;
create table member(	-- 아이디 , 비밀번호 , 이름 , 연락처 , 가입일 , 회원번호(pk , ai)
	mid varchar(30) not null unique , 
    mpwd varchar(30) not null , 
    mname varchar(20) not null , 
    mphone varchar(15) not null ,
    mdate datetime default now() , 
    mno int auto_increment , 
    primary key(mno)
);
select * from member;	-- 확인용

-- 2. 게시물테이블
drop table if exists board;
create table board(		-- 글제목 , 글내용 , 글작성일 , 글작성자 , 글조회수
	btitle varchar(100) not null , 
    bcontent longtext ,
    bdate datetime default now() , 
    bview smallint default 0 ,
    mno int ,
    bno int auto_increment ,
    primary key(bno) , 
    foreign key(mno) references member(mno)
);
select * from board;

-- 3. 댓글 테이블
drop table if exists reply;
create table reply(		-- 댓글 내용 , 댓글 작성일 , 댓글 작성자
	rcontent varchar(200) not null ,
    rdate datetime default now() , 
    mno int , 
    bno int , 
    rno int auto_increment , 
    primary key(rno) , 
    foreign key(mno) references member(mno) , 
    foreign key(bno) references board(bno)
);
select * from reply;

-- ERR 다이어그램 확인

-- 샘플 데이터 등록
-- 회원 5명
insert into member( mid , mpwd , mname , mphone ) values( 'qwer' , '1234' , '유재석' , '010-0000-0000' );
insert into member( mid , mpwd , mname , mphone ) values( 'asdf' , '4567' , '강호동' , '010-1235-4567' );
insert into member( mid , mpwd , mname , mphone ) values( 'zxcv' , '8910' , '신동엽' , '010-4653-7894' );
insert into member( mid , mpwd , mname , mphone ) values( 'rtuy' , '1112' , '하하' , '010-7897-4652' );
insert into member( mid , mpwd , mname , mphone ) values( 'fghj' , '1314' , '양세찬' , '010-6582-1635' );
select *from member;
-- 게시물 5개
insert into board( btitle , bcontent , mno ) values('안녕하세요1' , '안녕하세요내용1' , 1);
insert into board( btitle , bcontent , mno ) values('안녕하세요2' , '안녕하세요내용2' , 2);
insert into board( btitle , bcontent , mno ) values('안녕하세요3' , '안녕하세요내용3' , 3);
insert into board( btitle , bcontent , mno ) values('안녕하세요4' , '안녕하세요내용4' , 1);
insert into board( btitle , bcontent , mno ) values('안녕하세요5' , '안녕하세요내용5' , 5);
select *from board;
-- 댓글 5개
insert into reply( rcontent , mno , bno ) values( 'ㅋㅋㅋㅋㅋㅋ' , 1 , 2 );		# 2번 게시물에 1번 회원이 쓴 글
insert into reply( rcontent , mno , bno ) values( '재미있다' , 1 , 1 );
insert into reply( rcontent , mno , bno ) values( 'ㅎㅎㅎㅎㅎㅎㅎㅎ' , 1 , 5 );
insert into reply( rcontent , mno , bno ) values( '댓글내용4' , 3 , 2 );
insert into reply( rcontent , mno , bno ) values( '댓글내용5' , 4 , 1 );
select * from reply;

-- 검색
# 1. 전체 검색
select * from member;
# 2. 조건 검색
select * from member where mno = 1;			-- mno가 1인 회원 레코드 검색
select * from member where mid = 'qwer';	-- mid가 qwer 인 회원 레코드 검색
select * from member where mphone = '010-5710-2605';	
# 아이디 [비교] 찾기 (회원명과 연락처가 동일한 회원 검색)
# 비교연산자 : > 초과 < 미만 >= 이상 <= 이하 = 같다 != 같지않다
# 관계연산자 : and or not     vs java : && || !
select * from member where mname = '유재석' and mphone = '010-0000-0000'; # mysql : a = 1 and b = 2  vs  java : a == 1 && b == 2  
	# JDBC 매개변수 대입 : select * from member where mname = ? and mphone = ?;
# 비밀번호 [비교] 찾기 ( 아이디와 연락처가 동일한 회원 검색)
select * from member where mid = 'qwer' and mphone = '010-0000-0000';
	# JDBC 매개변수 대입 : select * from member where mid = ? and mphone = ?;
# 로그인[비교]
select * from member where mid = 'qwer' and mpwd = '1234';
	# JDBC 매개변수 대입 : select * from member where mid = ? and mpwd = ?;
    

