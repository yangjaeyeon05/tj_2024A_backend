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
    # 회원의 pk 값이 삭제되거나 수정되면 게시물 fk 어떻게 할건지 .. 제약조건옵션 설정하기
    on delete cascade on update cascade
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
    foreign key(mno) references member(mno) on delete cascade on update cascade , 
    foreign key(bno) references board(bno) on delete cascade on update cascade
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
    
-- 탈퇴
# 1. 회원번호가 '1'인 회원 삭제
delete from member where mno = 1;
# 2. 회원번호사 1이면서 비밀번호가 1234 인 회원 삭제
delete from member where mno = 1 and mpwd = '1234';
	# JDBC 매개변수 대입 : delete from member where mno = ? and mpwd = ?;
    
-- 수정
# 1. 회원번호가 0인 회원 레코드의 이름을 '유재석'으로 수정
update member set mname = '유재석' where mno = 0; 
# 2. 회원번호가 0인 회원 레코드의 이름을'유재석' ,(쉼표)구분해서 연락처 '010-9999-9999'로 수정
update member set mname = '유재석' , mphone = '010-9999-9999' where mno = 0; 
	# JDBC 매개변수 대입 : update member set mname = ? , mphone = ? where mno = ?;
    
-- 조회
# 1. 전체 조회
select * from board;
# 2. 개별 조회 ( 조건 )
select * from board where bno = 3;	-- 3번 게시물 개별 조회

-- 삭제
delete from board where bno = 0;	
delete from board where bno = 0 and mno = 0;	-- 작성자 번호가 0이면서 게시물 번호가 0인 게시물/레코드 삭제

-- 수정
update board set btitle = '' , bcontent = '0' where mno = 0 and bno = 0;

-- 댓글 확인
select * from reply;				-- 댓글 전체 출력
select * from reply where bno = 1;	-- 게시물 번호가 1번인 게시물에 작성된 댓글들
select * from reply where mno = 1;	-- 회원번호가 1인 회원이 작성한 댓글들

-- 댓글 쓰기
insert into reply(rcontent , mno , bno) values('댓글내용6' , 3 , 1);

-- 게시물 출력
select* from board;
-- 게시물 출력 시 mno가 아닌 mid출력
	-- 1. 두 테이블을 출력한다.
select * from board , member;
	-- 2. 두 테이블의 관계 기준으로 (내부/교집합)조인한다.
select * from board , member where board.mno = member.mno;
select * from board natural join member;
select * from board join member on board.mno = member.mno;
select * from board join member using(mno);
select * from board inner join member on board.mno = member.mno;
	-- 테이블명을 간소화 할때 : 별칭 , 테이블명 뒤에 별칭/별명 작성
select * from board b inner join member m on b.mno = m.mno;

# 댓글 출력
select * from reply;
select * from reply r inner join member m on r.mno = m.mno;
# 조건
select * from reply r inner join member m on r.mno = m.mno where r.bno = 1;

-- 조회 수 증가 처리 , 조회 수 1증가 , 기존 칠드 값을 변경 , update
update board set bview = 1; # 전체 레코드의 필드값을 수정
update board set bview = bview + 1;
update board set bview = bview + 1 where bno = 1;
select * from board;













