package day16.view;

import day16.controller.MemberController;
import day16.model.dto.MemberDto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberView {

    // - 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static변수에 해당 객체 만들기
    public static MemberView mView = new MemberView();

    // 멤버변수 : 입력객체
    Scanner scanner = new Scanner(System.in);

    // 0. 초기화면 함수
    public void index(){
        while(true){
            System.out.print("1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기 : ");
            try{
                int ch = scanner.nextInt();
                if(ch==1){
                    signup();
                } else if (ch==2) {
                    login();
                } else if (ch==3) {
                    findId();
                } else if (ch==4) {
                    findPwd();
                }else {
                    System.out.println(">> 없는 기능 번호입니다. ");
                }
            }catch (InputMismatchException e ){
                System.out.println(">> 잘못된 입력입니다. 초기메뉴로 ");
                scanner = new Scanner(System.in);
            }

        }   // while end
    }   // index() end

    // 1. 회원가입 화면 함수
    public void signup(){
        // 1. 입력
        System.out.println(">> 회원가입 페이지 <<");
        System.out.print(">> 아이디 : "); String mId = scanner.next();
        System.out.print(">> 비밀번호 : "); String mPwd = scanner.next();
        System.out.print(">> 이름 : "); String mName = scanner.next();
        System.out.print(">> 연락처 : "); String mPhone = scanner.next();
        // 2. 유효성검사
        // 3. 객체화
        MemberDto memberDto = new MemberDto(mId , mPwd , mName , mPhone);
        // 4. Controller에게 전달
        boolean result = MemberController.mControl.signup(memberDto);

        if(result){
            System.out.println(">> 회원가입성공");
        }else {
            System.out.println(">> 회원가입실패");
        }
    }   // signup() end

    // 2. 로그인 화면 함수
    public void login(){
        System.out.println(">> 로그인 페이지 <<");
        System.out.print(">> 아이디 : "); String mId = scanner.next();
        System.out.print(">> 비밀번호 : "); String mPwd = scanner.next();

        MemberDto memberDto = new MemberDto();
        memberDto.setMid(mId);
        memberDto.setMpwd(mPwd);

        boolean result = MemberController.mControl.login(memberDto);

        if(result){
            System.out.println(">> 로그인성공");
        }else {
            System.out.println(">> 로그인실패");
        }

    }   // login() end

    // 3. 아이디찾기 함수
    public void findId(){
        System.out.println(">> 아이디찾기 페이지 <<");
        System.out.print(">> 이름 : "); String mName = scanner.next();
        System.out.print(">> 연락처 : "); String mPhone = scanner.next();

        MemberDto memberDto = new MemberDto();
        memberDto.setMname(mName);
        memberDto.setMphone(mPhone);

        String result = MemberController.mControl.findId(memberDto);

        if(result != null){
            System.out.println("회원아이디 : "+ result);
        }else {
            System.out.println("동일한 회원 정보가 없습니다.");
        }
    }   // findId() end

    // 4. 비밀번호찾기 함수
    public void findPwd(){
        System.out.println(">> 비밀번호찾기 페이지 <<");
        System.out.print(">> 아이디 : "); String mId = scanner.next();
        System.out.print(">> 연락처 : "); String mPhone = scanner.next();

        MemberDto memberDto = new MemberDto();
        memberDto.setMid(mId);
        memberDto.setMphone(mPhone);

        String result = MemberController.mControl.findPwd(memberDto);

        if(result != null){
            System.out.println("회원비밀번호 : "+ result);
        }else {
            System.out.println("동일한 회원 정보가 없습니다.");
        }
    }   // findPwd() end

}
