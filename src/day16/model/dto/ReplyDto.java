package day16.model.dto;    // day16 -> model package 안 dto package

public class ReplyDto {     // 이동객체를 생성하기 위한 class 정의
    // DTO : Data Transfer Object ,
    // MVC패턴에서의 DTO 역할 : 각 구역별(V , C , DAO) 데이터 변수들을 묶어서 (구역간)이동하는 객체
        // 1. 멤버변수는 private 2. 생성자 : 빈생성자 , 풀생성자 + n개 3. 메소드 : getter and setter , toString()
    // 1. 멤버변수
    private String rcontent;
    private String rdate;
    private int mno;
    private int bno;
    private int rno;
    // - 작성자 아이디
    private String mid;

    // 2. 생성자
    public ReplyDto(){}

    public ReplyDto(String rcontent, String rdate, int mno, int bno, int rno) {
        this.rcontent = rcontent;
        this.rdate = rdate;
        this.mno = mno;
        this.bno = bno;
        this.rno = rno;
    }

    // 3. 메소드
        // 1. getter and setter

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "ReplyDto{" +
                "rcontent='" + rcontent + '\'' +
                ", rdate='" + rdate + '\'' +
                ", mno=" + mno +
                ", bno=" + bno +
                ", rno=" + rno +
                '}';
    }
}       // ReplyDto class end
