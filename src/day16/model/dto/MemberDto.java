package day16.model.dto;        // day16 -> model package 안 dto package

public class MemberDto {    // 이동객체를 생성하기 위한 class 정의

    // - DB테이블의 회원마다 레코드/행 1개고  레코드/행 1개 당 DTO1개
    // -> 회원이 여러개이면 --> DTO 여러개 --> ArryList<MemberDto>

    // 1. 멤버변수 <---> DB 필드와 동일 , private 권장
    private String mid;     // 아이디타입 String  DB : vachar
    private String mpwd;    // 비밀번호타입 String  DB : vachar
    private String mname;   // 이름타입 String  DB : vachar
    private String mphone;  // 연락처타입 String  DB : vachar
    private String mdate;   // 회원가입일 String  DB : datetime
    private int mno;        // 회원번호타입 int  DB : int

    // 2. 생성자 : 기본생성자 , 풀생성자
    public MemberDto(){}    // 기본생성자
    public MemberDto(String mid, String mpwd, String mname, String mphone, String mdate, int mno) {
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
        this.mdate = mdate;
        this.mno = mno;
    }   // 풀생성자
    // -- 회원가입용 생성자
    public MemberDto(String mid, String mpwd, String mname, String mphone) {
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
    }
    // 3. 메소드 : 1. getter and setter 2. toString
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    @Override
    public String toString() {                  // 주소가 아닌 값을 보기 위한 toString 기능
        return "MemberDto{" +
                "mid='" + mid + '\'' +
                ", mpwd='" + mpwd + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mno=" + mno +
                '}';
    }
}
