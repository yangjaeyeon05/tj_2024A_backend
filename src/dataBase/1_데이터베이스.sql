/* 여러줄 주석 */
# 한줄 주석
-- 한줄 주석
/* SQL질의어 */
/*
	1. 주의할 점
		- sql명령어 문장을 입력 후; (세미클론) 마침 , 자바와 비슷
        - 문자 처리 ' ' 혹은 " "
        - 명령어/키워드 에서는 대소문자 구분을 안함 , 데이터/자료는 당연히 구분함.
    2. 실행
		- 명령어 단위 실행 , 전체 실행
        - 명령어 단위 실행 : 싱행 명령어 커서 두고 ctrl+enter , 상단 번개모양의 I
        - 전체 명령어 실행 : ctrl+shift+enter , 상단 번개모양의 I 없는
	3. 실행 결과
		- 하단에 result 창
        - 하단에 output 창 : 실행 결과 창
	------------------------------------------------------------------
    
    DDL( data Definition Lauguage ) 데이터 정의어
		1. create
			- create database 새로운 DB명;					: 데이터베이스 생성
        2. drop
			- drop database 삭제할 DB명;					: 데이터베이스 삭제
				- drop database if exists 삭제할 DB명;
        - 그 외
        show
			show databases								: DBSEVER내 데이터베이스 목록 확인
            show variable like 'datadir';				: DBSEVER내 데이터베이스 local 위치 확인
		use
			use 사용할 DB명;								: DBSEVER내 조작/사용할 DB 선택
    DML( data Manipulation Lauguage ) 데이터 조작어
    
    DCL( data Control Lauguage ) 데이터 제어어
*/
-- 1. 현재 DB SEVER 존재하는 데이터베이스 확인 
show databases;

-- 2. 현재 DB SEVER 존재하는 로컬(C:드라이브) 위치 확인
show variables like 'datadir'; -- C:\ProgramData\MySQL\MySQL Server 8.0\Data\ [숨김폴더]

-- 3. 현재 DB SEVER내 데이터 베이스 생성
create database myDB;

-- 4. 데이터베이스 삭제
drop database myDB;

-- 4-2 만약에 해당 데이터베이스 존재하면 삭제
drop database if exists myDB;

-- 5.DB SEVER에는 여러개의 데이터베이스 존재.
use myDB;

drop database if exists test2;
create database test2;
show databases;
show variables like 'datadir';		-- C:\ProgramData\MySQL\MySQL Server 8.0\Data\
use test2;









