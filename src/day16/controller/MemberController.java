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

    // 2. 로그인 화면 함수
    public boolean login(MemberDto memberDto){
        return MemberDao.mDao.login(memberDto);
    }   // login() end

    // 3. 아이디찾기 함수
    public String  findId(MemberDto memberDto){
        return MemberDao.mDao.findId(memberDto);
    }   // findId() end

    // 4. 비밀번호찾기 함수
    public String findPwd(MemberDto memberDto){
        return MemberDao.mDao.findPwd(memberDto);
    }   // findPwd() end

}   // class end
