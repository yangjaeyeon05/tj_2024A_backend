package day10.step3;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        /*Student studentLee = new Student(1001,"Lee");
        studentLee.addSubject("국어",100);
        studentLee.addSubject("수학" , 50);

        Student studentKim = new Student(1002, "Kim");
        studentKim.addSubject("국어" , 70);
        studentKim.addSubject("수학" , 85);
        studentKim.addSubject("영어" , 100);

        studentLee.showStudentInfo();
        System.out.println("=============================");
        studentKim.showStudentInfo();*/

        Scanner scanner = new Scanner(System.in);

        // 학생목록 리스트 추가하기
        ArrayList<Student> studentList = new ArrayList<>();

        while(true){
            System.out.println("1. 학생등록 2. 점수등록 3. 점수확인 4. 학생삭제 선택]");
            int ch = scanner.nextInt();
            if(ch==1){
                // 1번을 누를 때마다
            }
            if(ch==2){

            }
            if(ch==3){

            }
            if(ch==4){

            }

        }
    }
}
/*
* [학생등록]
    1. 학번과 이름을 입력받아 학생객체 생성 후 학생목록 리스트에 저장하기
    * 학생목록 리스트를 만들어주세요.
* [점수등록]
    1. 학번을 입력받아 동일한 학번이 있을 경우
    2. 과목명과 점수를 입력받아 해당 학번 학생의 점수리스트 점수 추가하기
* [점수확인]
    1. 학번을 입력받아 동일한 학번이 있을 경우
    2. 해당 학번의 학생의 모든 점수 리스트를 출력해주세요.
 */