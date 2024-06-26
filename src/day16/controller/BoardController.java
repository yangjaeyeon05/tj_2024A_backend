package day16.controller;   // day16 패키지 안 controller 패키지

import day16.model.dao.BoardDao;
import day16.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {  // BoardController 클래스 정의

    // ========== 싱글톤 만들기 ========== //
    // 싱글톤 : 프로그램내 해당 클래스의 하나의 객체만 갖는 패턴
        // 1. private static 변수에 해당 클래스의 객체 생성해서 대입 , private
    private static BoardController bControl = new BoardController();
        // 2. 해당 클래스의 생성자에 private 한다. 다른 클래스에서 new 사용하지 못하게
    private BoardController(){}
        // 3. 해당 객체(싱글톤)를 외부로부터 접근할 수 있도록 간접 호출 메소드
    public static BoardController getInstance(){
        // ----- 유효성검사 ------ // 왜 private을 사용하는지 public이 아니라 // 유효성 검사를 하기 위해 // 객체가 지나갈 수 있는 어떤 조건을 만들기 위해
        return bControl;
    }
    // ================================= //
    // 4. 게시판(게시물전체출력) 함수
    public ArrayList<BoardDto> bPrint(){
        // dao에게 전체 게시물 출력요청 후 결과를 반환
        return BoardDao.getInstance().bPrint();
    }   // bPrint() end

    // 5. 게시물 쓰기 함수
    public boolean bWrite( BoardDto boardDto){
        // 회원넘버도 넣어주어야하기때문에 멤버컨트롤러에서 가져오고 boardDto에 대입
        boardDto.setMno(MemberController.mControl.loginMno);
        // - boardDto(제목 , 내용 , 작성자번호) 을 다오에게 전달 후 결과 받기
        return BoardDao.getInstance().bWrite(boardDto);
    }   // bWrite() end

    // 6. 게시물 개별조회 함수
    public BoardDto bView(int bno){
        // dao에게 게시물번호 넘겨준 후 결과를 반환
        return BoardDao.getInstance().bView(bno);
    }   // bView() end

    // 7. 게시물 삭제 함수
    public boolean bDelete(int bno){
        int mno = MemberController.mControl.loginMno;
        return BoardDao.getInstance().bDelete(bno , mno);
    }

    // 8. 게시물 수정 함수
    public boolean bUpdate(BoardDto boardDto){
        int mno = MemberController.mControl.loginMno;
        boardDto.setMno(mno);
        return BoardDao.getInstance().bUpdate(boardDto);
    }
}   // BoardController class end
