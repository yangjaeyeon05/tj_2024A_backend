package day15.step2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class Step1 {
    public static void main(String[] args) {

        try {
            // 1.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 여기서 오류 발생 시 : 현재 프로젝트 내 라이브러리가 제대로 등록 안될떄
            System.out.println("<< JDBC 드라이버 호출 성공 >>");

            // 2.
            Connection conn; // 인터페이스 타입의 변수 선언
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05" , "root" , "polyketon5!");
            System.out.println("<< DB 연동 성공 >>");
        } catch (Exception e) {
            System.out.println("JDBC 연동 실패" + e);
        }

    }
}
/*
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
                - 비밀번호
                * 연동 성공 시 연동성공한 정보를 가진 객체를 반환 , 해당 연동객체를 가지고 DML(DB) 조작


        - Connection 인터페이스 : DB와 연동 성공한 객체 정보를 가지고 조작기능/메소드 제공하는 인터페이스
            - 추상 메소드
                .prepareStatement();

        - PreparedStatement 인터페이스
            - 추상메소드
                .executeUpdate();

 */
