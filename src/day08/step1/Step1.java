package day08.step1;

public class Step1 {
    public static void main(String[] args) {

        축구선수 soccer1 = new 축구선수(1, "유재석" , 40 , "공격수" , "인천");
        System.out.println(soccer1.getNo()+soccer1.getName()+soccer1.getAge()+soccer1.getPosition()+soccer1.getTeam());
        축구선수 soccer2 = new 축구선수(2, "박지성" , 40 , "미드필더" , "인천");

        축구선수 soccer3 = new 축구선수(3, "손흥민" , 40 , "공격수" , "토트넘");

        축구선수 soccer4 = new 축구선수(4, "이강인" , 40 , "미드필더" , "파리");

        축구선수 soccer5 = new 축구선수(5, "김민재" , 40 , "수비수" , "독일");

        축구선수 soccer6 = new 축구선수(6, "서장훈" , 40);

        soccer6.setPosition("공격수");
        System.out.println(soccer6.getPosition());

        soccer6.setTeam("서울");
        System.out.println(soccer6.getTeam());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("고유식변번호 이름 나이 선호포지션 소속팀");
        System.out.println(soccer1.getNo()+soccer1.getName()+soccer1.getAge()+soccer1.getPosition()+soccer1.getTeam());
        System.out.println(soccer2.getNo()+soccer2.getName()+soccer2.getAge()+soccer2.getPosition()+soccer2.getTeam());
        System.out.println(soccer3.getNo()+soccer3.getName()+soccer3.getAge()+soccer3.getPosition()+soccer3.getTeam());
        System.out.println(soccer4.getNo()+soccer4.getName()+soccer4.getAge()+soccer4.getPosition()+soccer4.getTeam());
        System.out.println(soccer5.getNo()+soccer5.getName()+soccer5.getAge()+soccer5.getPosition()+soccer5.getTeam());
        System.out.println(soccer6.getNo()+soccer6.getName()+soccer6.getAge()+soccer6.getPosition()+soccer6.getTeam());
    }
}
