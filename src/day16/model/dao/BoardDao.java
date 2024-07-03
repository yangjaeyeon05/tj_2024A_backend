package day16.model.dao;        // day16 -> model 패키지 안 dao 패키지

import day16.model.dto.BoardDto;
import day16.model.dto.ReplyDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {     // BoardDao class 정의
    private static BoardDao bDao = new BoardDao();
    // DB 연동
    // JDBC 인터페이스 3개
    Connection conn;        // 데이터베이스와의 연결을 관리하기 위한 변수
    PreparedStatement ps;   // SQL 쿼리를 실행하기 위해 사용되는 인터페이스
    ResultSet rs;
    // 데이터베이스에서 쿼리를 실행한 결과를 저장하고, 그 결과를 행 단위로 순회하며 데이터에 접근할 수 있게 하는 인터페이스
    // 생성자 연동 코드
    private BoardDao(){
        try {   // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
            Class.forName("com.mysql.cj.jdbc.Driver");     // (JDBC 구현체) 드라이버 클래스 호출
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06" , "root" , "1234");
            //  DriverManager.getConnection(" DB SEVER URL" , "계정명" , "비밀번호")
        }catch (Exception e){   // 예외가 발생하면
            System.out.println(">> 연동 실패"+e);   // 발생한 이유 출력
        }   // try end
    }
    public static BoardDao getInstance(){
        return bDao;
    }
    // 4. 게시판(게시물전체출력) 함수 : 매개변수 x , 리턴값 : 여러개 게시물 -> 여러개 레코드 -> 여러개DTO
    public ArrayList<BoardDto> bPrint(){
        // - 여러개 Dto 담을 리스트 선언
        ArrayList<BoardDto> list = new ArrayList<>();
        try {   // 예외처리
            // 1. sql 작성
            // String sql = "select * from board";
            String sql = "select * from board inner join member on board.mno = member.mno order by bno desc";
            // 2. 작성한 sql 기재한다.
            ps = conn.prepareStatement(sql);
            // 3. SQL 실행하고 결과 반환
            rs = ps.executeQuery();
            // 4. 결과 레코드 전체 하나씩 순회하기
            while (rs.next()){
                // rs.next() : 다음 레코드 이동 , 존재하면 true , 없으면 false
                // 레코드 1개당 --> Dto 1개
                    // rs.getString("필드명") : 현재 레코드의 해당 필드명 값호출
                String btitle = rs.getString("btitle");
                String bcontent = rs.getString("bcontent");
                String bdate = rs.getString("bdate");
                int bview = rs.getInt("bview");
                int mno = rs.getInt("mno");
                int bno = rs.getInt("bno");
                // Dto 만들기
                BoardDto boardDto = new BoardDto(btitle,bcontent,bdate,bview,mno,bno);
                boardDto.setMid(rs.getString("mid"));
                // 리스트에 Dto담기
                list.add(boardDto);
                // return list ; // 여기에 return을 쓰게 되면 반복이 되지 않을 채 나가버려 한개의 레코드만 반환하게 된다.
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;    // 여러개 담긴 Dto 리스트를 반환
    }   // bPrint() end

    // 5. 게시물 쓰기 함수
    public boolean bWrite(BoardDto boardDto){
        try{    // 예외처리
            // sql 작성
            String sql = "insert into board( btitle , bcontent , mno ) values(? , ? , ?)";
            // sql 기재
            ps = conn.prepareStatement(sql);
            // 기재한 sql에 매개변수 대입
            ps.setString(1 , boardDto.getBtitle());
            ps.setString(2 , boardDto.getBcontent());
            ps.setInt(3, boardDto.getMno());
            int count = ps.executeUpdate();
            // 실행 후 처리
            if(count==1){  // 실행한 레코드 수가 1이면 true 반환
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;   // 오류 발생 또는 게시물 등록 실패 시 false 반환
    }   // bWrite() end

    // 6. 게시물 개별조회 함수
    public BoardDto bView(int bno){
        try{    // 예외처리
            // 1. sql 작성
            String sql = "select * from board b inner join member m on b.mno = m.mno where b.bno = ?";
            // 2. sql 기재한다.
            ps = conn.prepareStatement(sql);
            // - 기재된 sql 매개변수 대입
            ps.setInt(1 , bno);
            // 3. sql 실행 후 결과 값을 반환.
            rs = ps.executeQuery();
            // 4. 결과에 따른 처리
            if(rs.next()){
                BoardDto boardDto = new BoardDto(rs.getString("btitle"),rs.getString("bcontent"),rs.getString("bdate"),rs.getInt("bview"),rs.getInt("mno"),rs.getInt("bno"));
                boardDto.setMid(rs.getString("mid"));
                return boardDto;    // 생성된 boardDto 반환;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;    // 오류 또는 게시물이 존재하지 않을 때 null 반환
    }   // bView() end

    // 7. 게시물 삭제 함수
    public boolean bDelete(int bno , int mno ){
        try{
            String sql = "delete from board where bno = ? and mno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1 , bno);
            ps.setInt(2 , mno);
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // bDelete() end

    // 8. 게시물 수정 함수
    public boolean bUpdate(BoardDto boardDto){
        try {
            String sql = "update board set btitle = ? , bcontent = ? where mno = ? and bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1 , boardDto.getBtitle());
            ps.setString(2 , boardDto.getBcontent());
            ps.setInt(3 , boardDto.getMno());
            ps.setInt(4 , boardDto.getBno());
            int count = ps.executeUpdate();
            if(count==1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // bUpdate() end

    // 9. 댓글 출력 함수
    public ArrayList<ReplyDto> rPrint(int bno){
        // - 여러개 Dto 담을 리스트 선언
        ArrayList<ReplyDto> list = new ArrayList<>();
        try{
            // sql 작성
            String sql = "select * from reply r inner join member m on r.mno = m.mno where r.bno = ?";
            // sql 기재
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            rs = ps.executeQuery();
            // 결과 레코드 전체 하나씩 순회하기
            while (rs.next()){
                // rs.next() : 다음 레코드 이동 , 존재하면 true , 없으면 false
                // - rs.get타입("필드명") or rs.get타입(필드번호) : 두가지 방법 가능
                // Dto 만들기
                ReplyDto replyDto = new ReplyDto(rs.getString(1) , rs.getString(2), rs.getInt(3) , rs.getInt(4) , rs.getInt(5) );
                replyDto.setMid(rs.getString("mid"));
                // 리스트에 Dto담기
                list.add(replyDto);
                // return list ; // 여기에 return을 쓰게 되면 반복이 되지 않을 채 나가버려 한개의 레코드만 반환하게 된다.
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;    // list 반환
    }   // rPrint() end

    // 10. 댓글 쓰기 함수
    public boolean rWrite(ReplyDto replyDto){
        try{
            String sql = "insert into reply(rcontent , mno , bno) values( ? , ? , ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1 , replyDto.getRcontent());
            ps.setInt(2 , replyDto.getMno());
            ps.setInt(3 , replyDto.getBno());
            int count = ps.executeUpdate();
            if(count==1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // rWrite() end

    // 11. 조회 수 증가 처리 함수
    public boolean viewIncrease(int bno){
        try{
            String sql = "update board set bview = bview + 1 where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1 , bno);
            int count = ps.executeUpdate();
            if(count==1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // viewIncrease() end

    // 12. 제목 검색 함수
    public ArrayList<BoardDto> search(String keyword){
        // list 출력할 ArrayList 객체 생성
        ArrayList<BoardDto> list = new ArrayList<>();
        try{
            // sql 작성
            // String sql = "select * from board inner join member on board.mno = member.mno where btitle like '%제%' order by bno desc";           [o]
            // String sql = "select * from board inner join member on board.mno = member.mno where btitle like '%?%' order by bno desc";           [ x 파라미터가 인식 불가능 ]
            // String sql = "select * from board inner join member on board.mno = member.mno where btitle like ? order by bno desc";                [ ? -> "%"+keyword+"%"
            // String sql = "select * from board inner join member on board.mno = member.mno where btitle like '%"+keyword+"%' order by bno desc";  [ 연결연산자 o ]
            // String sql = "select * from board inner join member on board.mno = member.mno where btitle like %?% order by bno desc";              [ x ]
            // String sql = "select * from board inner join member on board.mno = member.mno where bview like %3% order by bno desc";               [ x ]
            String sql = "select * from board inner join member on board.mno = member.mno where btitle like CONCAT( '%' , ? , '%') order by bno desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keyword);
            // ps.setString(1,"%"+keyword+"%");
            // ps.setInt(1,3);
            rs = ps.executeQuery();
            while (rs.next()){
                // rs.next() : 다음 레코드 이동 , 존재하면 true , 없으면 false
                // 레코드 1개당 --> Dto 1개
                // rs.getString("필드명") : 현재 레코드의 해당 필드명 값호출
                String btitle = rs.getString("btitle");
                String bcontent = rs.getString("bcontent");
                String bdate = rs.getString("bdate");
                int bview = rs.getInt("bview");
                int mno = rs.getInt("mno");
                int bno = rs.getInt("bno");
                // Dto 만들기
                BoardDto boardDto = new BoardDto(btitle,bcontent,bdate,bview,mno,bno);
                boardDto.setMid(rs.getString("mid"));
                // 리스트에 Dto담기
                list.add(boardDto);
                // return list ; // 여기에 return을 쓰게 되면 반복이 되지 않을 채 나가버려 한개의 레코드만 반환하게 된다.
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }   // search() end

}   // BoardDao class end
