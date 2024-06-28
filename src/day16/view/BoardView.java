package day16.view;

import day16.controller.MemberController;
import day16.model.dto.MemberDto;

import java.util.Scanner;

public class BoardView {

    // 0.
    public static BoardView bView = new BoardView();
    Scanner scanner = new Scanner(System.in);

    // 0. 로그인 성공 시 초기화면
    public void index2(){

        while(true){
            System.out.print(">> 1. 로그아웃 2. 회원수정 3. 회원탈퇴 4. 게시판 : ");
            int ch = scanner.nextInt();

            if(ch==1){
                logout();   return;
            } else if (ch==2) {
                mUpdate();
            } else if (ch==3) {
                if(mDelete()){
                    logout();   return;
                }
            } else if (ch==4) {
                bPrint();
            }else {
                System.out.println(">> 없는 기능번호입니다.");
            }

        }   // while end


    }   // index2() end

    // 1. 로그아웃 함수
    public void logout( ){
        // 회원 컨트롤러에 로그아웃 메소드 호출
        MemberController.mControl.logout();
        System.out.println(">> 로그아웃 성공 [초기메뉴로]");
    }

    // 2. 회원수정 함수
    public void mUpdate(){
        System.out.print(">> 비밀번호 입력 : ");
        String confirmPwd = scanner.next();

        boolean confirm = MemberController.mControl.confirmPw(confirmPwd);

        if(confirm){
            System.out.print(">> 새로운 이름을 입력해주세요 : ");
            String newMName = scanner.next();
            System.out.print(">> 새로운 연락처를 입력해주세요 : ");
            String newMPhone = scanner.next();

            MemberDto memberDto = new MemberDto();
            memberDto.setMname(newMName);
            memberDto.setMphone(newMPhone);

            boolean result = MemberController.mControl.mUpdate(memberDto);

            if(result){
                System.out.println(">> 회원수정 성공");
            }else {
                System.out.println(">> 회원수정 실패");
            }
        }else {
            System.out.println("비밀번호 불일치");
        }
    }

    // 3. 회원탈퇴 함수
    public boolean mDelete(){
        System.out.print("[정말 탈퇴할까요?]");
        System.out.print(">> 비밀번호 입력 : ");
        String confirmPwd = scanner.next();
        boolean result = MemberController.mControl.mDelete(confirmPwd);
        if(result){
            System.out.println(">> 회원탈퇴 성공");
            return true;
        }else {
            System.out.println(">> 비밀번호 불일치");
            return false;
        }
    }

    // 4. 게시판(게시물전체출력) 함수
    public void bPrint(){

    }
}
