package day16.model.dao;

import day16.controller.MemberController;
import day16.model.dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

    // - 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static변수에 해당 객체 만들기
    public static MemberDao mDao = new MemberDao();

    // DB 연동
        // JDBC 인터페이스 3개
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
        // 생성자 연동 코드
    MemberDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06" , "root" , "1234");
        }catch (Exception e){
            System.out.println(">> 연동 실패"+e);
        }
    }

    // 1. 회원가입 화면 함수
    public boolean signup(MemberDto memberDto){
        try {
            // 1. SQL 작성한다.
            String sql = "insert into member( mid , mpwd , mname , mphone ) values( ? , ? , ? , ?)";
            System.out.println("sql : "+sql);
            // 2. SQL 기재한다.
            ps = conn.prepareStatement(sql);
            // 2. SQL 문법의 ? (와일드카드) 매개변수 기재한다.
            ps.setString(1 , memberDto.getMid() );
            ps.setString(2 , memberDto.getMpwd());
            ps.setString(3 , memberDto.getMname());
            ps.setString(4 , memberDto.getMphone());
            // 3. SQL 실행한다. // 4. SQL 실행결과
            int count = ps.executeUpdate(); // .executeUpdate(); 등록된 레코드 수 반환
            if(count == 1){
                return true;    // 1개 레코드 등록되면 성공
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;   // 5. 메소드 반환
    }   // signup() end

    // 2. 로그인 화면 함수 : 로그인 성공한 회원번호 반환
    public int login(MemberDto memberDto){
        try {
            String sql = "select * from member where mid = ? and mpwd = ?";  // 1. SQL 작성한다.
            ps = conn.prepareStatement(sql);    // DB 연동 객체에 SQL를 기재
            ps.setString(1 , memberDto.getMid() );  // 3. SQL의 ? 매개변수에 변수값 대입
            ps.setString(2 , memberDto.getMpwd());
            // 4. 실행
            rs = ps.executeQuery(); // 5. 쿼리 실행 후 결과를 rs로 받는다.
            // 6. 다음 레코드 : 로그인 성공 시 레코드 1개 로그인 실패 시 레코드 0개
            if(rs.next()){  // 다음 레코드가 1개라도 존재하면 로그인 성공
                return rs.getInt("mno");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;   // 로그인 실패
    }   // login() end

    // 3. 아이디찾기 함수
    public String findId(MemberDto memberDto){
        String findId = null;
        try {
            String sql = "select * from member where mname = ? and mphone = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1 , memberDto.getMname() );
            ps.setString(2 , memberDto.getMphone());

            rs = ps.executeQuery();
            if(rs.next()){
                findId = rs.getString("mid");
                return findId;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }   // findId() end

    // 4. 비밀번호찾기 함수
    public String findPwd(MemberDto memberDto ){
        String findPwd = null;
        try {
            String sql = "select * from member where mid = ? and mphone = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1 , memberDto.getMid() );
            ps.setString(2 , memberDto.getMphone());

            rs = ps.executeQuery();
            if(rs.next()){
                findPwd = rs.getString("mpwd");
                return findPwd;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }   // findPwd() end

    // 5. 회원탈퇴 함수
    public boolean mDelete(int loginMno , String confirmPwd){
        try {
            String sql = "delete from member where mno = ? and mpwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1 , loginMno);
            ps.setString(2 , confirmPwd );
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // mDelete() end

    // 2. 회원수정 함수
    public boolean mUpdate(MemberDto memberDto){
        try{
            String sql = "update member set mname = ? , mphone = ? where mno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1 , memberDto.getMname());
            ps.setString(2 , memberDto.getMphone() );
            ps.setInt(3, memberDto.getMno());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // mUpdate() end

    // * 비밀번호 확인 함수
    public boolean confirmPw(String confirmPwd , int loginMno){
        try{
            String sql = "select * from member where mno = ? and mpwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno );
            ps.setString(2 , confirmPwd );
            rs = ps.executeQuery();
            if(rs.next()){  // 다음 레코드가 1개라도 존재하면 로그인 성공
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
