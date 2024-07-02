package 프로젝트.model.dao;

import 프로젝트.model.dto.MyAccountDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyAccountDao {
    private static MyAccountDao myAccountDao = new MyAccountDao();
    // JDBC 인터페이스 3개
    Connection conn;        // 데이터베이스와의 연결을 관리하기 위한 변수
    PreparedStatement ps;   // SQL 쿼리를 실행하기 위해 사용되는 인터페이스
    ResultSet rs;
    // 생성자 연동 코드
    private MyAccountDao(){
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            Class.forName("com.mysql.cj.jdbc.Driver");     // (JDBC 구현체) 드라이버 클래스 호출
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testbase" , "root" , "1234");
            //  DriverManager.getConnection(" DB SEVER URL" , "계정명" , "비밀번호")
        }catch (Exception e){   // 예외가 발생하면
            System.out.println(">> 연동 실패"+e);   // 발생한 이유 출력
        }   // try end
    }
    // 3. 해당 객체(싱글톤)를 외부로부터 접근할 수 있도록 간접 호출 메소드
    public static MyAccountDao getInstance(){
        return myAccountDao;
    }
    // 1. 회원가입
    public boolean signup(MyAccountDto myAccountDto){
        try{
            // sql 작성
            String sql = "insert into myaccount(aid,apwd,aname,anum,abirth) values (?,?,?,?,?)";
            // sql 기재
            ps = conn.prepareStatement(sql);
            ps.setString(1,myAccountDto.getAid());
            ps.setString(2,myAccountDto.getApwd());
            ps.setString(3,myAccountDto.getAname());
            ps.setString(4,myAccountDto.getAnum());
            ps.setString(5,myAccountDto.getAbirth());
            int count = ps.executeUpdate();
            if(count==1){
                return true;
            }
            // 처리
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // signup() end

    // 2. 로그인
    public int login(MyAccountDto myAccountDto){
        try{
            String sql = "select * from myaccount where aid = ? and apwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,myAccountDto.getAid());
            ps.setString(2,myAccountDto.getApwd());
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("akey");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }   // login() end

    // 3. 아이디찾기
    public String findID(MyAccountDto myAccountDto){
        try{
            String sql = "select * from myaccount where aname = ? and anum = ? and abirth = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, myAccountDto.getAname());
            ps.setString(2, myAccountDto.getAnum());
            ps.setString(3, myAccountDto.getAbirth());
            rs = ps.executeQuery();
            if(rs.next()){
                String result = rs.getString("aid");
                return result;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }   // findID() end

    // 4. 비밀번호찾기
    public String findPWD(MyAccountDto myAccountDto){
        try{
            String sql = "select * from myaccount where aid = ? and anum = ? and abirth = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, myAccountDto.getAid());
            ps.setString(2, myAccountDto.getAnum());
            ps.setString(3, myAccountDto.getAbirth());
            rs = ps.executeQuery();
            if(rs.next()){
                String result = rs.getString("apwd");
                return result;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }   // findPWD() end

}   // class end
