package day15.step2_JDBC;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Step2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05" , "root" , "1234");

            String sql = "insert into table1 values('유재석')";
            // (SQL) Statement 기재 Prepare 준비하다  , .prepareStatement() : sql 문자열을 매개변수로 전달 , 해당 sql를 조작할 수 있는 구현체 반환
            PreparedStatement ps = conn.prepareStatement(sql);
            // execute 실행하다 Update 최신화
            ps.executeUpdate();

           sql = "insert into table1 values('강호동')";
           ps = conn.prepareStatement(sql);
           ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("JDBC 연동 실패" + e);
        }
    }
}
