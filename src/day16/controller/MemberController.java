package day16.controller;

import day16.model.dao.MemberDao;
import day16.model.dto.MemberDto;

public class MemberController {

    // - 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static변수에 해당 객체 만들기
    public static MemberController mControl = new MemberController();

    // 1. 회원가입 화면 함수
    public boolean signup(MemberDto memberDto){
        boolean result = MemberDao.mDao.signup(memberDto);
        return result;
    }   // signup() end

    // 2-1. 로그인 성공한 회원의 번호 저장하는 멤버변수
        // - 글쓰기 , 댓글쓰기 할 때 로그인된 회원을 식별하기 위해서
        // - 초기값: 0 비로그인 상태 , 1~ : 로그인된 회원번호(로그인된상태)
    public int loginMno = 0;

    // 2-2. 로그아웃 함수
    public void logout(){
        loginMno = 0;
    }

    // 2. 로그인 화면 함수
    public boolean login(MemberDto memberDto){
        int result = MemberDao.mDao.login(memberDto);
        if(result != 0){
            loginMno = result;
        }else {
            result = 0;
        }
        return result == 0 ? false : true;
    }   // login() end

    // 3. 아이디찾기 함수
    public String findId(MemberDto memberDto){
        return MemberDao.mDao.findId(memberDto);
    }   // findId() end

    // 4. 비밀번호찾기 함수
    public String findPwd(MemberDto memberDto){
        return MemberDao.mDao.findPwd(memberDto);
    }   // findPwd() end

    // 5. 회원탈퇴 함수
    public boolean mDelete(String confirmPwd){
        return MemberDao.mDao.mDelete(loginMno , confirmPwd);
        // view로부터 받은 확인 비밀번호와 로그인 회원번호를 dao에게 전달
    }   // mDelete() end

    // 2. 회원수정 함수
    public boolean mUpdate(MemberDto memberDto){
        memberDto.setMno(loginMno);
        return MemberDao.mDao.mUpdate(memberDto);
    }   // mUpdate() end

    // * 비밀번호 확인 함수
    public boolean confirmPw(String confirmPwd){
        return MemberDao.mDao.confirmPw(confirmPwd , loginMno);
    }

}   // class end
