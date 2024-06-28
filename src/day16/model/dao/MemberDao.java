package day16.model.dao;        // day16 -> model 패키지 안 dao 패키지

import day16.model.dto.MemberDto;   // day16 -> model -> dto 패키지 안 MemberDto 클래스를 불러온다.

import java.sql.Connection;         // sql 라이브러리 Connection 인터페이스 불러오기
import java.sql.DriverManager;      // sql 라이브러리 DriverManager 클래스 불러오기
import java.sql.PreparedStatement;  // sql 라이브러리 PreparedStatement 인터페이스 불러오기
import java.sql.ResultSet;          // sql 라이브러리 ResultSet 인터페이스 불러오기

public class MemberDao {            // MemberDao class 정의

    // - 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static변수에 해당 객체 만들기
    public static MemberDao mDao = new MemberDao();

    // DB 연동
        // JDBC 인터페이스 3개
    Connection conn;        // 데이터베이스와의 연결을 관리하기 위한 변수
    PreparedStatement ps;   // SQL 쿼리를 실행하기 위해 사용되는 인터페이스
    ResultSet rs;
    // 데이터베이스에서 쿼리를 실행한 결과를 저장하고, 그 결과를 행 단위로 순회하며 데이터에 접근할 수 있게 하는 인터페이스

    // 생성자 연동 코드
    MemberDao(){
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            Class.forName("com.mysql.cj.jdbc.Driver");     // (JDBC 구현체) 드라이버 클래스 호출
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06" , "root" , "1234");
            //  DriverManager.getConnection(" DB SEVER URL" , "계정명" , "비밀번호")
        }catch (Exception e){   // 예외가 발생하면
            System.out.println(">> 연동 실패"+e);   // 발생한 이유 출력
        }   // try end
    }   // 생성자 연동 코드 end
    // * 연동 성공 시 연동성공한 정보를 가진 객체를 반환 , 해당 연동객체를 가지고 DML(DB) 조작

    // 1. 회원가입 화면 함수
    // 성공여부를 따져야하는 함수로 반환타입은 boolean
    public boolean signup(MemberDto memberDto){     // 컨트롤러에서 전달받은 MemberDto타입 memberDto변수
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            // 1. SQL 작성한다.
            String sql = "insert into member( mid , mpwd , mname , mphone ) values( ? , ? , ? , ?)";
            // member 테이블 mid , mpwd , mname , mphone 필드에 값 ? , ? , ? , ? 을 넣어준다.
            // System.out.println("sql : "+sql); 작성한 sql이 변수에 잘 들어갔는지 확인하기 위함
            // 2. SQL 기재한다.
            ps = conn.prepareStatement(sql);
            // 2. SQL 문법의 ? (와일드카드) 매개변수 기재한다.
            ps.setString(1 , memberDto.getMid() );  // 첫번째 ? 에 memberDto.getMid() 아이디대입 memberDto은private이기 때문에 get으로 값을 가져온다.
            ps.setString(2 , memberDto.getMpwd());  // 두번째 ? 에 memberDto.getMpwd()) 비밀번호대입
            ps.setString(3 , memberDto.getMname()); // 세번째 ? 에 memberDto.getMname() 이름대입
            ps.setString(4 , memberDto.getMphone());    // 네번째 ?에 memberDto.getMphone() 연락처 대입
            // 3. SQL 실행한다. // 4. SQL 실행결과
            int count = ps.executeUpdate(); // .executeUpdate(); 등록된 레코드 수 반환 int 값으로 반환되기 때문에 변수 타입은 int
            if(count == 1){     // 만약 등록된 레코드수가 1이면
                return true;    // 1개 레코드 등록되면 성공 true 반환
            }   // if end
        }catch (Exception e){   // 오류가 발생하면
            System.out.println(e);  // 발생한 이유 출력한다.
        }   // try end
        return false;   // 5. 메소드 반환
    }   // signup() end

    // 2. 로그인 화면 함수 : 로그인 성공한 회원번호 반환
    // 함수 실행 후 반환된 값이 컨트롤러에 loginMno에 저장되어야하기 때문에 반환타입은 int
    public int login(MemberDto memberDto){       // 컨트롤러에서 전달받은 MemberDto타입 memberDto변수
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            String sql = "select * from member where mid = ? and mpwd = ?";  // 회원정보 조회를 DB에서 조회하기 위해 select로  SQL 작성한다.    // member테이블에서 mid가 ?이고 mpwd가 ?인 회원레코드조회
            ps = conn.prepareStatement(sql);    // DB 연동 객체에 SQL를 기재
            ps.setString(1 , memberDto.getMid() );  // 3. SQL의 ? 매개변수에 변수값 대입
            ps.setString(2 , memberDto.getMpwd());
            // 4. 실행
            rs = ps.executeQuery(); // 5. 쿼리 실행 후 결과를 rs로 받는다.  // DB 업데이트가 아닌 조회를 위한 것으로 executeQuery() 사용 반환타입이 ResultSet이므로 위에 선언한 rs 변수에 저장.
            // 6. 다음 레코드 : 로그인 성공 시 레코드 1개 로그인 실패 시 레코드 0개
            if(rs.next()){  // 다음레코드가 존재하면
                return rs.getInt("mno");    // 해당 레코드의 mno int값을 가져와 반환한다..
            }
        }catch (Exception e){   // 오류가 발생하면
            System.out.println(e);  // 발생한 이유 출력한다.
        }   // try end
        return 0;   // 로그인 실패
    }   // login() end

    // 3. 아이디찾기 함수
    // 찾은 아이디를 출력해줘야하기 때문에 반환 타입은 String
    public String findId(MemberDto memberDto){      // 컨트롤러에서 전달받은 MemberDto타입 memberDto변수
        String findId = null;   // 찾은 값을 넣어줄 깡통 변수를 하나 만들어준다.
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            String sql = "select * from member where mname = ? and mphone = ?"; // sql를 작성한다.
            // member 테이블에 mname이 ?이고 mphone이 ? 인 회원 레코드를 조회한다.
            ps = conn.prepareStatement(sql);    // DB 연동 객체에 SQL를 기재
            ps.setString(1 , memberDto.getMname() );    //  SQL의 ? 매개변수에 변수값 대입
            ps.setString(2 , memberDto.getMphone());

            rs = ps.executeQuery(); // 쿼리 실행 후 결과를 rs로 받는다.
            if(rs.next()){  // 다음레코드가 존재하면
                findId = rs.getString("mid");   // 해당 레코드에서 mid 값을 가져와 변수에 저장한다.
                return findId;      // 저장한 변수를 함수를 호출한 곳으로 반환한다.
            }   // if end
        }catch (Exception e){   // 오류가 발생하면
            System.out.println(e);  // 발생한 이유 출력한다.
        }    // try end
        return null;    // 찾은 값이 없으면 null 을 반환한다.
    }   // findId() end

    // 4. 비밀번호찾기 함수
    // 찾은 비밀번호를 출력해줘야하기 때문에 반환 타입은 String
    public String findPwd(MemberDto memberDto ){    // 컨트롤러에서 전달받은 MemberDto타입 memberDto변수
        String findPwd = null;  // 찾은 값을 넣어줄 깡통 변수를 하나 만들어준다.
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            String sql = "select * from member where mid = ? and mphone = ?";   // sql를 작성한다.
            // member 테이블에 mid이 ?이고 mphone이 ? 인 회원 레코드를 조회한다.
            ps = conn.prepareStatement(sql);        // DB 연동 객체에 SQL를 기재
            ps.setString(1 , memberDto.getMid() );      // SQL의 ? 매개변수에 변수값 대입
            ps.setString(2 , memberDto.getMphone());

            rs = ps.executeQuery();     // 쿼리 실행 후 결과를 rs로 받는다.
            if(rs.next()){  // 다음레코드가 존재하면
                findPwd = rs.getString("mpwd"); // 해당 레코드에서 mpwd 값을 가져와 변수에 저장한다.
                return findPwd;     // 저장한 변수를 함수를 호출한 곳으로 반환한다.
            }   // if end
        }catch (Exception e){   // 오류가 발생하면
            System.out.println(e);  // 발생한 이유 출력한다.
        }   // try end
        return null;    // 찾은 값이 없으면 null 을 반환한다.
    }   // findPwd() end

    // 5. 회원탈퇴 함수
    // 탈퇴성공 여부를 파악해야하기 때문에 반환타입은 boolean
    public boolean mDelete(int loginMno , String confirmPwd){   // 컨트롤러에서 전달받은 int 타입 loginMno변수 , String 타입 confirmPwd변수
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            String sql = "delete from member where mno = ? and mpwd = ?";   // sql를 작성한다.
            // member 테이블에 mno이 ? 이고 mpwd가 ?인 회원레코드를 삭제한다.
            ps = conn.prepareStatement(sql);        // DB 연동 객체에 SQL를 기재
            ps.setInt(1 , loginMno);    // SQL의 ? 매개변수에 변수값 대입
            ps.setString(2 , confirmPwd );

            int count = ps.executeUpdate();     // .executeUpdate(); 등록된 레코드 수 반환 int 값으로 반환되기 때문에 변수 타입은 int
            if(count == 1){     // 만약 삭제한 레코드 수가 1이면
                return true;    // true 값을 반환한다.
            }   // if end
        }catch (Exception e){   // 오류가 발생하면
            System.out.println(e);  // 발생한 이유 출력한다.
        }   // try end
        return false;   // 삭제를 못하면 false값을 반환한다.
    }   // mDelete() end

    // 2. 회원수정 함수
    // 수정성공 여부를 파악해야하기 때문에 반환타입은 boolean
    public boolean mUpdate(MemberDto memberDto){    // 컨트롤러에서 전달받은 MemberDto타입 memberDto변수
        try{    // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            String sql = "update member set mname = ? , mphone = ? where mno = ?";  // sql를 작성한다.
            // member 테이블에 mno ? 인 회원의 레코드에서 mname 를 ?으로 mphone 를 ? 으로 수정한다.
            ps = conn.prepareStatement(sql);    // DB 연동 객체에 SQL를 기재
            ps.setString(1 , memberDto.getMname());     // SQL의 ? 매개변수에 변수값 대입
            ps.setString(2 , memberDto.getMphone() );
            ps.setInt(3, memberDto.getMno());
            int count = ps.executeUpdate();     // .executeUpdate(); 등록된 레코드 수 반환 int 값으로 반환되기 때문에 변수 타입은 int
            if(count == 1){     // 만약 수정한 레코드 수가 1이면
                return true;    // true 값을 반환한다.
            }   // if end
        }catch (Exception e){   // 오류가 발생하면
            System.out.println(e);  // 발생한 이유 출력한다.
        }    // try end
        return false;   // 수정을 못하면 false값을 반환한다.
    }   // mUpdate() end

    // * 비밀번호 확인 함수
    // 비밀번호가 있는지 확인여부이므로 반환 타입은 boolean
    public boolean confirmPw(String confirmPwd , int loginMno){     // 컨트롤러에서 전달받은 String타입 confirmPwd변수 , int타입 loginMno변수
        try{    // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            String sql = "select * from member where mno = ? and mpwd = ?"; // sql를 작성한다.
            // member 테이블에서 mno이 ? 이고 mpwd이 ? 인 회원 레코드를 조회한다.
            ps = conn.prepareStatement(sql);        // DB 연동 객체에 SQL를 기재
            ps.setInt(1, loginMno );    // SQL의 ? 매개변수에 변수값 대입
            ps.setString(2 , confirmPwd );
            rs = ps.executeQuery();     // 쿼리 실행 후 결과를 rs로 받는다.
            if(rs.next()){  // 다음 레코드가 1개라도 존재하면 로그인한 회원과 비밀번호가 일치하다
                return true;    // true 값 반환
            }   //  if end
        }catch (Exception e){   // 오류가 발생하면
            System.out.println(e);  // 발생한 이유 출력한다.
        }   // try end
        return false;   // 비밂번호 일치여부 파악 못하면 false값을 반환한다.
    }   // confirmPw() 함수 end
}   // MemberDao class end
