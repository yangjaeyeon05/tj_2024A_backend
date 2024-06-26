package day15.step2_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        Connection conn = null;
        // DB 연동
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05" , "root" , "polyketon5!");
        }catch (Exception e){
            System.out.println(">> 연동실패 : "+ e);
        }

        Scanner scanner = new Scanner(System.in);   // 입력 객체
        // ArrayList<String> nameList = new ArrayList<>();     // 여러개 String객체(문자열)를 저장하는 리스트 객체

        while(true){

            try {
                System.out.println("1. 등록 2. 출력 3. 수정 4. 삭제 : ");
                int ch = scanner.nextInt();

                if(ch == 1){
                    // 1. 입력받고
                    System.out.print(">> [저장C] 이름 : ");    String name = scanner.next();
                    // 2. DB SQL 레코드 저장 : insert into table1 values('유재석');
                    String sql = "insert into table1 values('"+name+"')";
                    System.out.println("sql : "+sql);
                   PreparedStatement ps = conn.prepareStatement(sql);
                   ps.executeUpdate();

                }else if(ch == 2){
                    System.out.println("===== 이름 명단 =====");
                    // 2. DB SQL 레코드 전체 검색/조회 : select * from table1;
                    String sql = "select * from table1";
                    System.out.println("sql : "+sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){   // 첫번째 레코드부터 마지막 레코드까지 순화
                        System.out.println(rs.getString("name"));
                    }

                } else if (ch == 3) {
                    System.out.print(">> [수정U] 기존 이름 : ");      String oldName = scanner.next();
                    System.out.print(">> [수정U] 새로운 이름 : ");     String newName = scanner.next();
                    // 2. DB SQL 레코드 수정 : update table1 set name = '신동엽2' where name = '신동엽';
                    String sql = "update table1 set name = '"+newName+"' where name = '"+oldName+"'";
                    System.out.println("sql : "+sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();
                } else if (ch == 4) {
                    // 1. 입력받기
                    System.out.print(">> [삭제D] 삭제할 이름 : ");     String name = scanner.next();
                    // 2.DB SQL 레코드 삭제 delete from table1 where name = '유재석';
                    String sql = "delete from table1 where name = '"+name+"'";
                    System.out.println("sql : "+sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();
                }else {
                    System.out.println(">> 없는 기능 번호입니다.");
                }

            }catch (InputMismatchException e){
                System.out.println(">> 잘못된 입력입니다. ");
                scanner = new Scanner(System.in);   // 잘못 입력받은 값을 가지고 있는 객체를 초기화
            }catch (SQLException e){
                System.out.println(">> SQL 구문이 틀렸습니다" + e);
            }
        }   // while end
    }   // main end
}   // class end
