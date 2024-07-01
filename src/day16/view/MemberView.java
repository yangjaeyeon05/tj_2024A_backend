package day16.view;     // day16 package 안 view package

import day16.controller.MemberController;       // day16 -> controller 패키지 안 MemberController 클래스 불러온다.
import day16.model.dto.MemberDto;               // day16 -> model -> dto 패키지 안 MemberDto 클래스 불러온다.

import java.util.InputMismatchException;        // JAVA에서 만든 InputMismatchException 클래스를 불러온다. 예외처리를 위함.
import java.util.Scanner;                       // JAVA에서 만든 Scanner 클래스 불러온다. 스캐너 기능을 사용하기 위해

public class MemberView {                       // MemberView 클래스 정의

    // - 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static변수에 해당 객체 만들기
        // - static 선언시점 : 프로그램 시작 시 , static 사라짐/초기화 시점 : 프로그램 종료 시
        // - 메소드를 실행하기 위해서는 객체 필요 . static 메소드가 아닌 이상
        // - 멤버변수는 객체 마다 할당 , 메소드는 객체마다 실행을 하지만 코드는 공유
        // - 전역 객체 -> 모든 곳에서 호출 가능한 객체 1개
        // - 싱글톤 : 프로그램내 전역으로 하나의 객체를 생성 , 주로 전역에서 공유할 때
    public static MemberView mView = new MemberView();
    // private MemberView(){}  // 생성자에 private 한다. : 다른 클래스에서 new 를 못한다.  -> 싱글톤패턴

    // 멤버변수 : 입력객체
    Scanner scanner = new Scanner(System.in);

    // 0. 초기화면 함수
    public void index(){

        while(true){        // 메뉴 설정을 종료되거나 오류가 생기기 전까지 반복하기 위해 while문
            System.out.print("1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기 : ");   // 컨셉 상 설정한 메뉴를 입력 받기 위해 먼저 안내해준다.
            try{        // 예기치 못한 상황으로 인해 종료되는 것을 방지하고 어떤 오류인지 파악하기 위해 try
                int ch = scanner.nextInt();     // 위에 안내한 버튼을 정수로 입력 받아 변수에 저장한다.
                if(ch==1){                      // 만약에 ch == 1이면
                    signup();                   // signup();  회원가입 함수 실행
                } else if (ch==2) {             // 만약에 ch == 2이면
                    login();                    // login(); 로그인 함수실행
                } else if (ch==3) {             // 만약에 ch == 3이면
                    findId();                   // findId(); 아이디 찾기 함수 실행
                } else if (ch==4) {             // 만약에 ch == 4이면
                    findPwd();                  // findPwd();  패스워드 찾기 함수 실행
                }else {                         // 위 상황들이 다 아니면
                    System.out.println(">> 없는 기능 번호입니다. ");     // 없는 번호라고 안내해준다.
                }
            }catch (InputMismatchException e ){         // int가 아닌 다른 타입으로 받았을 경우 예외처리 e로 저장
                System.out.println(">> 잘못된 입력입니다. 초기메뉴로 ");     // 잘못됐음을 안내
                scanner = new Scanner(System.in);                       // 스캐너 객체를 초기화 하기 위해 새로운 객체로 생성한다.
            }   // try end

        }   // while end

    }   // index() end

    // 1. 회원가입 화면 함수
    public void signup(){
        // 1. 입력
        System.out.println(">> 회원가입 페이지 <<");                       // 어떤 페이지인지 안내
        // 회원가입 위해 받을 필드 안내 후 sql에 설계해둔 타입에 맞는 타입과 변수명 정해서 입력받아 저장.
        System.out.print(">> 아이디 : "); String mId = scanner.next();     // 아이디 입력 받고 String 타입 변수에 저장.
        System.out.print(">> 비밀번호 : "); String mPwd = scanner.next();   // 비밀번호를 입력 받고 String 타입 변수에 저장.
        System.out.print(">> 이름 : "); String mName = scanner.next();    // 이름 입력받고 String 타입 변수에 저장.
        System.out.print(">> 연락처 : "); String mPhone = scanner.next();  // 연락처 입력받고 String 타입 변수에 저장.
        // 2. 유효성검사
        // 3. 객체화
        MemberDto memberDto = new MemberDto(mId , mPwd , mName , mPhone);
        // 받은 변수들 한번에 전달 위해 묶음 처리 MemberDto 클래스에서 변수에 맞는 생성자 생성해두었기 때문에 바로 대입해 사용 가능.
        // 4. Controller에게 전달
        boolean result = MemberController.mControl.signup(memberDto);   // 전달 후 받은 값을 true or false로 결과 값 저장.

        if(result){         // 만약 result가 true이면
            System.out.println(">> 회원가입성공");    // 회원가입 성공
        }else {             // 만약 result가 false이면
            System.out.println(">> 회원가입실패");    // 회원가입 실패
        }   // if end
    }   // signup() end

    // 2. 로그인 화면 함수
    public void login(){
        System.out.println(">> 로그인 페이지 <<");    // 로그인 페이지라고 안내
        System.out.print(">> 아이디 : "); String mId = scanner.next();     // 아이디 입력 받고 String 타입 변수에 저장.
        System.out.print(">> 비밀번호 : "); String mPwd = scanner.next();   // 비밀번호를 입력 받고 String 타입 변수에 저장.

        MemberDto memberDto = new MemberDto();      // 매개변수 전달을 위한 묶음 객체 새로 생성. 동일한 매개변수 타입과 개수를 갖는 생성자를 중복 정의가 안됨.
        memberDto.setMid(mId);                      // memberDto 객체 속성이 private 이기때문에 set을 써서 아이디값을 넣어준다.
        memberDto.setMpwd(mPwd);                    // memberDto 객체 속성이 private 이기때문에 set을 써서 비밀번호값을 넣어준다.

        boolean result = MemberController.mControl.login(memberDto);    // 컨트롤러에 매개변수 전달하고 받은 값은 로그인 성공 여부를 확인 하기 위해 boolean 타입에 저장.

        if(result){     // 만약 result가 true이면
            System.out.println(">> 로그인성공");     // 로그인 성공 안내
            // 로그인 성공 시 로그인된 메뉴로 이동
            BoardView.bView.index2();
        }else {         // 만약 result가 false이면
            System.out.println(">> 로그인실패");     // 로그인 실패 안내
        }   // if end

    }   // login() end

    // 3. 아이디찾기 함수
    public void findId(){
        System.out.println(">> 아이디찾기 페이지 <<");      // 아이디찾기 페이지임을 안내
        // 찾을 아이디를 가진 회원의 정보를 입력받아 매개변수로 전달한다.
        System.out.print(">> 이름 : "); String mName = scanner.next();    // 이름 입력받아 String 타입 변수에 저장
        System.out.print(">> 연락처 : "); String mPhone = scanner.next(); // 연락처 입력받아 String 타입 변수에 저장

        MemberDto memberDto = new MemberDto();      // 매개변수 전달을 위한 묶음 객체 새로 생성.
        memberDto.setMname(mName);                  // memberDto 객체 속성이 private 이기때문에 set을 써서 이름값을 넣어준다.
        memberDto.setMphone(mPhone);                // memberDto 객체 속성이 private 이기때문에 set을 써서 연락처값을 넣어준다.

        // 찾은 아이디를 알려줘야 하기 때문에 boolean 이 아닌 String 결과 값을 받아 변수에 저장
        String result = MemberController.mControl.findId(memberDto);    // 컨트롤러에 전달

        if(result != null){     // 만약 result 값이 null이 아니면
            System.out.println("회원아이디 : "+ result);     // result에 찾은 아이디를 넣어놨으니까 찾은 아이디 출력
        }else {                 // 만약 result 값이 null이면
            System.out.println("동일한 회원 정보가 없습니다.");  // 입력한 회원 정보가 없어 오류임을 알려준다.
        }   // if end
    }   // findId() end

    // 4. 비밀번호찾기 함수
    public void findPwd(){
        System.out.println(">> 비밀번호찾기 페이지 <<");     // 비밀번호찾기 페이지 임을 안내
        // 찾을 비밀번호를 가진 회원의 정보를 입력받아 변수 저장 후 매개변수로 전달한다.
        System.out.print(">> 아이디 : "); String mId = scanner.next();         // 아이디 입력받아 String 타입 변수에 저장.
        System.out.print(">> 연락처 : "); String mPhone = scanner.next();      // 연락처 입력받아 String 타입 변수에 저장.

        MemberDto memberDto = new MemberDto();      // 매개변수 전달을 위한 묶음 객체 새로 생성.
        memberDto.setMid(mId);                      // memberDto 객체 속성이 private 이기때문에 set을 써서 아이디값을 넣어준다.
        memberDto.setMphone(mPhone);                // memberDto 객체 속성이 private 이기때문에 set을 써서 연락처값을 넣어준다.

        // 찾은 비밀번호를 알려줘야하기때문에 String 타입에 저장.
        String result = MemberController.mControl.findPwd(memberDto);   // 컨트롤러에 전달

        if(result != null){     // 만약 result 값이 null이 아니면
            System.out.println("회원비밀번호 : "+ result);    // 찾은 비밀번호가 들어가 있는 것이기 때문에 찾은 값 출력
        }else {                 // 만약 result 값이 null 이면
            System.out.println("동일한 회원 정보가 없습니다."); // 찾은 비밀번호가 없기 때문에 못찾은 이유 출력
        }   // if end
    }   // findPwd() end

}   // MemberView class end
