package day09.step1;

public class Step1 {
    public static void main(String[] args) {

        // [1] 학생(객체) 2명 생성
        Student studentJames = new Student("James" , 5000);
            // - Student 클래스 내 기본/디폴트 생성자가 없으므로 오류
            // Student studentJames2 = new Student();
        Student studentTomas = new Student("Tomas" , 10000);

        // [2] 버스 1대 생성
        Bus bus100 = new Bus(100);
        studentJames.takeBus(bus100);
        System.out.println(studentJames);
        System.out.println(bus100);
        // bus100.showInfo();

        // [3] 지하철 1대 생성
        Subway subwayGreen = new Subway("2호선");
        studentTomas.takeSubway(subwayGreen);
        System.out.println(studentTomas);
        System.out.println(subwayGreen);
        // subwayGreen.showInfo();

        // [4] p. 180
        Student studentEdward = new Student("Edward" , 15000);

        Taxi taxi2578 = new Taxi(2578);
        studentEdward.takeTaxi(taxi2578);
        System.out.println(studentEdward);
        System.out.println(taxi2578);

    }
}
