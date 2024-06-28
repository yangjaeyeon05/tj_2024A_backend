package day16.controller;   // day16 패키지 안 -> controller 패키지

import day16.model.dao.MemberDao;       // day16 -> model -> dao 패키지 안 MemberDao 클래스를 불러온다.
import day16.model.dto.MemberDto;       // day16 -> model -> dto 패키지 안 MemberDto 클래스를 불러온다

public class MemberController {         // view에게 받은 값을 (타입변경 과 같은 상황이 있기에)dao에 전달하기 위한 class MemberController 정의

    // - 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static변수에 해당 객체 만들기
    public static MemberController mControl = new MemberController();

    // 1. 회원가입 화면 함수
    // view가 성공 여부를 따져야하기 때문에 반환타입은 boolean
    public boolean signup(MemberDto memberDto){     // view 에서 전달한 매개변수 값 MemberDto타입 memberDto변수
        // view에서 받은 값을 dao함수 실행하면서 전달
        boolean result = MemberDao.mDao.signup(memberDto);  // 함수 실행 후 받은 값을 boolean 타입으로 저장
        return result;          // 결과 값을 함수 호출한 곳으로 전달 view signup() 함수
    }   // signup() end

    // 2-1. 로그인 성공한 회원의 번호 저장하는 멤버변수
        // - 글쓰기 , 댓글쓰기 할 때 로그인된 회원을 식별하기 위해서
        // - 초기값: 0 비로그인 상태 , 1~ : 로그인된 회원번호(로그인된상태)
    public int loginMno = 0;

    // 2-2. 로그아웃 함수
    public void logout(){
        loginMno = 0;   // 로그아웃 시 변수에 0을 넣어준다. => 비로그인 상태
    }

    // 2. 로그인 화면 함수
    // view가 성공 여부를 따져야하기 때문에 반환타입은 boolean
    public boolean login(MemberDto memberDto){      // view 에서 전달한 매개변수 값 MemberDto타입 memberDto변수
        // view에서 받은 값을 dao함수 실행하면서 전달
        int result = MemberDao.mDao.login(memberDto);   // 함수 실행 후 받은 결과 값ㅇ르 int 타입으로 저장.
        if(result != 0){    // 만약 result 값이 0이 아니면
            loginMno = result;  // 로그인 성공한 회원의 번호 저장하는 멤버변수에 결과값을 저장해준다.(회원번호)
        }else {         // 만약 result 값이 0이면
            result = 0; // 로그인 실패이므로 변수에 0 저장
        }   // if end
        return result == 0 ? false : true;      // 만약 result 값이 0이면 false를 전달하고 (로그인실패) 아니면 true 전달(로그인성공)
    }   // login() end

    // 3. 아이디찾기 함수
    // view가 찾은 아이디를 출력해야하기 때문에 반환타입은 String
    public String findId(MemberDto memberDto){      // view 에서 전달한 매개변수 값 MemberDto타입 memberDto변수
        // view에서 받은 값을 dao함수 실행하면서 전달
        return MemberDao.mDao.findId(memberDto); // 함수 실행 후 받은 값을 함수 호출 한 곳으로 보내기
    }   // findId() end

    // 4. 비밀번호찾기 함수
    // view가 찾은 비밀번호를 출력해야하기 때문에 반환타입은 String
    public String findPwd(MemberDto memberDto){     // view 에서 전달한 매개변수 값 MemberDto타입 memberDto변수
        // view에서 받은 값을 dao함수 실행하면서 전달
        return MemberDao.mDao.findPwd(memberDto);   // 함수 실행 후 받은 값을 함수 호출 한 곳으로 보내기
    }   // findPwd() end

    // 5. 회원탈퇴 함수
    // view가 성공 여부를 따져야하기 때문에 반환타입은 boolean
    public boolean mDelete(String confirmPwd){  // view 에서 전달한 매개변수 값 String타입 confirmPwd 변수
        // view에서 받은 값을 dao함수 실행하면서 전달
        return MemberDao.mDao.mDelete(loginMno , confirmPwd);
        // view로부터 받은 확인 비밀번호와 컨트롤러에 있는 로그인 회원번호를 dao에게 전달 , 함수 실행 후 받은 값을 함수 호출 한 곳으로 보내기
    }   // mDelete() end

    // 2. 회원수정 함수
    // view가 성공 여부를 따져야하기 때문에 반환타입은 boolean
    public boolean mUpdate(MemberDto memberDto){    // view 에서 전달한 매개변수 값 MemberDto타입 memberDto변수
        // 회원 수정을 위해서 현재 로그인 한 사람의 정보를 수정해야하기 때문에 전달할 값에 loginMno 변수값 추가
        memberDto.setMno(loginMno);
        return MemberDao.mDao.mUpdate(memberDto);   // 함수 실행 후 받은 값을 함수 호출 한 곳으로 보내기
    }   // mUpdate() end

    // * 비밀번호 확인 함수
    // view가 비밀번호가 있는지 없는지만 판단하면 되므로 반환타입은 boolean
    public boolean confirmPw(String confirmPwd){    // view 에서 전달한 매개변수 값 String타입 confirmPwd변수
        // 현재 로그인한 회원이랑 비밀번호가 맞는지 판단해야하므로 loginMno 같이 전달
        return MemberDao.mDao.confirmPw(confirmPwd , loginMno);
        // view로부터 받은 확인 비밀번호와 컨트롤러에 있는 로그인 회원번호를 dao에게 전달 , 함수 실행 후 받은 값을 함수 호출 한 곳으로 보내기
    }   // confirmPw() end

}   // class end
