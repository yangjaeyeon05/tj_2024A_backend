package day15.step3_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
    // - 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수
    static Dao dao = new Dao();
    // 1. 멤버변수
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    // 2. 생성자
    Dao(){  // 연동 코드
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05" , "root" , "1234");
            System.out.println("연동성공");
        }catch (Exception e){
            System.out.println(">> 연동실패 : "+ e);
        }
    }
    // -- 각 기능별 함수 구현
    // 1. 등록 SQL 함수 , 매개변수 : 저장할 값 String , 리턴 : 등록성공여부 boolean
    public boolean signupC(String name){
        try {
            // 2. DB SQL 레코드 저장 : insert into table1 values('유재석');
            String sql = "insert into table1 values('" + name + "')";
            System.out.println("sql : " + sql);
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;        // 성공했다는 의미 부여한 결과를 전달
        }catch (Exception e) {
            System.out.println(e);
            return false;       // 실패했다는 의미 부여한 결과를 전달
        }
    }
    // 2. 출력 SQL 함수 , 매개변수 : x , 리턴 : 회원목록 ArrayList<String>
    public ArrayList<String > printC(){
        ArrayList<String> list = new ArrayList<>(); // 리스트(비어있는)선언
        try {
            String sql = "select * from table1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) { // 레코드 하나씩 호출
                list.add(rs.getString("name")); // 현재 레코드의 name 필드 값을 호출하여 리스트에 저장
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    // 3. 수정 SQL 함수 , 매개변수 : 기존이름 String , 새로은 이름 String , 리턴 : 수정성공여부 boolean
    public boolean updateC(String oldName , String newName){
        try {
            // 2. DB SQL 레코드 수정 : update table1 set name = '신동엽2' where name = '신동엽';
            String sql = "update table1 set name = '" + newName + "' where name = '" + oldName + "'";
            System.out.println("sql : " + sql);
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    // 4. 삭제 SQL 함수 , 매개변수 : 삭제할이름 String , 리턴 : 삭제성공여부 boolean
    public boolean deleteC(String name){
        try {
            // 2.DB SQL 레코드 삭제 delete from table1 where name = '유재석';
            String sql = "delete from table1 where name = '" + name + "'";
            System.out.println("sql : " + sql);
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
