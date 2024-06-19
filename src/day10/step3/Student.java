package day10.step3;

import java.util.ArrayList;

public class Student {
    int StudentID;
    String studentName;
    ArrayList<Subject> subjectList;

    public Student(int studentID, String studentName) {
        StudentID = studentID;
        this.studentName = studentName;
        subjectList = new ArrayList<Subject>();
    }

    public void addSubject(String name , int score){    // 과목을 추가하는 함수
        Subject subject = new Subject();
        subject.setName(name);
        subject.setScorePoint(score);
        subjectList.add(subject);
    }

    public void showStudentInfo(){
        int total = 0;
        for(Subject s : subjectList){
            total += s.getScorePoint();
            System.out.println("학생 "+studentName+"의 "+s.getName()+"과목 성적은 "+s.getScorePoint()+"입니다.");
        }
        System.out.println("학생 "+studentName+"의 총점은 "+total+"입니다.");
    }

}
