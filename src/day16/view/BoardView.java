package day16.view;     // day16 package 안 view package

import day16.controller.MemberController;       // day16 -> controller 패키지 안 MemberController 클래스 불러온다.
import day16.model.dto.MemberDto;               // day16 -> model -> dto 패키지 안 MemberDto 클래스 불러온다.

import java.util.Scanner;                       // JAVA에서 만든 Scanner 클래스 불러온다. 스캐너 기능을 사용하기 위해

public class BoardView {                        // BoardView 클래스 정의

    // - 해당 클래스의 함수들을 다른 클래스에서 호출 할 수 있도록 static변수에 해당 객체 만들기
    public static BoardView bView = new BoardView();
    // 스캐너 기능을 사용하기 위해 스캐너 객체 생성
    Scanner scanner = new Scanner(System.in);

    // 0. 로그인 성공 시 초기화면
    public void index2(){

        while(true){        // 메뉴 설정을 종료되거나 오류가 생기기 전까지 반복하기 위해 while문
            System.out.print(">> 1. 로그아웃 2. 회원수정 3. 회원탈퇴 4. 게시판 : ");   // 컨셉 상 설정한 메뉴를 입력 받기 위해 먼저 안내해준다.
            int ch = scanner.nextInt();     // 위에 안내한 메뉴를 정수로 입력 받아 변수에 저장한다.

            if(ch==1){          // 만약 ch == 1이면
                logout();   return;     // logout(); 로그아웃 함수 실행 후 index2 함수 빠져나와 index함수로 이동
            } else if (ch==2) {         // 만약 ch == 2 이면
                mUpdate();              // mUpdate(); 회원수정 함수 실행
            } else if (ch==3) {         // 만약 ch == 3이면
                if(mDelete()){          // 3을 입력했을 때 mDelete() 회원 삭제 함수를 실행하는데 만약 실행 후 결과 값이 true이면
                    logout();   return; // 로그아웃 후 초기화면으로
                }                       // 작은 if end
            } else if (ch==4) {         // 만약 ch == 4 이면
                bPrint();               // bPrint(); 게시판 출력 함수 실행
            }else {                     // 만약 다른 숫자를 입력하면
                System.out.println(">> 없는 기능번호입니다.");   // 오류 안내
            }   // if end

        }   // while end


    }   // index2() end

    // 1. 로그아웃 함수
    public void logout( ){
        // 회원 컨트롤러에 로그아웃 메소드 호출
        MemberController.mControl.logout();
        System.out.println(">> 로그아웃 성공 [초기메뉴로]");   // 결과 안내
    }

    // 2. 회원수정 함수
    public void mUpdate(){
        System.out.print(">> 비밀번호 입력 : ");      // 회원 수정을 위한 현재 로그인 한 회원의 비밀번호 입력
        String confirmPwd = scanner.next();         // 입력 받은 값 String 타입에 저장
        // 결과 값을 boolean으로 받아 유효성 검사를 위해 변수 저장
        boolean confirm = MemberController.mControl.confirmPw(confirmPwd);  // 입력받은 비밀번호 값을 컨트롤러에 전달

        if(confirm){    // 만약 입력한 비밀번호가 맞으면
            System.out.print(">> 새로운 이름을 입력해주세요 : ");   // 변경할 새로운 이름을 입력받는다.
            String newMName = scanner.next();                   // 입력받은 값을 String 타입 변수에 저장한다.
            System.out.print(">> 새로운 연락처를 입력해주세요 : ");  // 변경할 새로운 연락처를 입력받는다.
            String newMPhone = scanner.next();                  // 입력받은 값을 String 타입 변수에 저장한다.

            MemberDto memberDto = new MemberDto();              // 매개변수 전달을 위한 memberDto 객체 생성
            memberDto.setMname(newMName);                       // memberDto 객체 속성이 private 이기때문에 set을 써서 이름을 넣어준다.
            memberDto.setMphone(newMPhone);                     // memberDto 객체 속성이 private 이기때문에 set을 써서 연락처를 넣어준다.
            // 컨트롤러에 전달
            boolean result = MemberController.mControl.mUpdate(memberDto);  // 전달하고 함수 실행 후 받은 값을 boolean 타입으로 저장한다.

            if(result){     // 만약 result 값이 true 이면
                System.out.println(">> 회원정보 수정 성공");   // 회원정보 수정 성공 안내
            }else {         // 만약 result 값이 false이면
                System.out.println(">> 회원정보 수정 실패");    // 회원정보 수정 실패 안내
            }
        }else {     // 만약 입력한 비밀번호가 틀리면
            System.out.println("비밀번호 불일치"); // 틀렸다고 안내
        }   // if end
    }   // mUpdate() end

    // 3. 회원탈퇴 함수
    public boolean mDelete(){
        System.out.print("[정말 탈퇴할까요?]");        // 정말 탈퇴할 것인지 한번더 안내
        System.out.print(">> 비밀번호 입력 : ");      // 탈퇴를 위해 회원 정보 비교 위한 비밀번호 입력
        String confirmPwd = scanner.next();         // 받은 값을 String 타입 변수에 저장
        // 컨트롤러에 전달
        boolean result = MemberController.mControl.mDelete(confirmPwd);     // 함수 실행 후 받은 결과 값을 boolean 타입 변수에 저장.
        if(result){ // 만약 result 가 true이면
            System.out.println(">> 회원탈퇴 성공");   // 회원탈퇴 성공 안내
            return true;    // 함수 실행 곳으로 true값을 전달한다.
        }else {     // 만약 result가 false이면
            System.out.println(">> 비밀번호 불일치");  // 회원탈퇴 실패 안내
            return false;   // 함수 실행 곳으로 false값을 전달한다.
        }   // if end
    } // mDelete() end

    // 4. 게시판(게시물전체출력) 함수
    public void bPrint(){

    }   // bPrint() end
}   // BoardView class end
