 JDBC : JAVA DATABASE CONNECT : 자바 데이터베이스 연동

                                        각 DBMS 회사별
    자바                                      구현클래스 제공
    JDBC인터페이스 제공                            - MYSQL : mysql-connector-j-8.4.0.jar
                                                        -> com.mysql.cj.jdbc.Driver
                                                 - ORACLE : ojdbc6.jar
                                                 - 등등 각 회사별 구현 클래스가 있는 라이브러리 파일 필요.
                                          * jar : 여러개 클래스와 라이브러리들을 묶음 패키지

    - JDBC 관련 클래스 / 인터페이스 라이브러리 설치
        MYSQL JDBC/JAR
        1. https://dev.mysql.com/downloads/
        2.
        3. 다운로드 받고 압축푼 폴더 내 mysql-connector-j-8.4.0.jar
        4. 해당 프로젝트내 폴더로 .jar 이동
            - src -> database -> mysql-connector-j-8.4.0.jar
        5. 해당 jar 오른쪽 클릭 -> 메뉴 하단에 라이브러리 추가
        6. [확인] 인텔리제이 상단 메뉴 -> 파일 -> 프로젝트 구조

    - 연동 코드
        1. Class.forName("com.mysql.cj.jdbc.Driver");   : (JDBC 구현체) 드라이버 클래스 호출
                MYSQL : com.mysql.cj.jdbc.Driver
                ORACLE : oracle.jdbc.OracleDriver
        2. 연동
        DriverManager.getConnection(" DB SEVER URL" , "계정명" , "비밀번호")
            - DB SEVER URL : jdbc:mysql:ip주소:port번호/DB명
                - 로컬PC기준 : jdbc:mysql://localhost:3306/DB명
                - 계정명 : 로컬사용시 기본값 : root
                - 비밀번호 : (임의)1234
                * 반환타입 : 연동 성공 시 연동성공한 정보를 가진 객체를 반환 , 해당 연동객체를 가지고 DML(DB) 조작


        - Connection 인터페이스 : DB와 연동 성공한 객체 정보를 가지고 조작기능/메소드 제공하는 인터페이스
            - 추상 메소드
                .prepareStatement("SQL질의어");    : 해당 SQL문을 기재하고 SQL문을 조작할 수 있는 PreparedStatement 반환

        - PreparedStatement 인터페이스   :   SQL 조작/기능/메소드 제공하는 인터페이스
            - 추상메소드
                .executeUpdate();       : insert , update , delete  문법을 실행하고 최신화된 레코드 수 반환
                .executeQuery();        : select 문법을 실행하고 결과를 반환해주는 함수

        - ResultSet 인터페이스   :   select 문법의 실행결과를 조작/기능/메소드 제공하는 인터페이스
            - 추상메소드
                .next();                         : 결과에서 다음 레코드(행) 호출하는데 존재하면 true , 존재하지 않으면 false
                .getString("필드명");             : 현재 레코드의 필드값 (문자열타입) 호출
                .getInt("필드명");                : 현재 레코드의 필드값 (정수형타입) 호출

            - 내부 구조
                ResultSet [ null ]  ---> .next() ---> [ 첫번째레코드 ]
                - 예시)
                    [name필드]    [age필드]<--------- ResultSet
                    신동엽            39
                    하하              48
                    유재석            66
                    1. ResultSet    .next()     ---> 첫번째 레코드    [name필드] 신동엽 [age] 39   -- .getString("name") --> 신동엽
                    2. ResultSet    .next()     ---> 두번째 레코드    [name필드] 하하 [age] 48    -- .getString("name") --> 하하
                    3. ResultSet    .next()     ---> 세번째 레코드    [name필드] 유재석 [age] 66  -- .getInt("age") --> 66
                    4. ResultSet    .next()     ---> 없음 false               , while(rs.next()){}
