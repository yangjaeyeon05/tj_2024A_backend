package day05;

public class Step1 {    // class s

    public static void main(String[] args) {    // main s

        // p. 94
        int age = 7;
        if(age >= 8){
            System.out.println("학교에 다닙니다.");
        }else {
                System.out.println("학교에 다니지 않습니다.");
        }

        // p.97
        int age2 = 9;
        int charge;
        if(age2 < 8){
            charge = 1000;
            System.out.println("취학 전 아동입니다.");
        } else if (age2 < 14) {
            charge = 2000;
            System.out.println("초등학생입니다.");
        } else if (age2 < 20) {
            charge = 2500;
            System.out.println("중,고등학생입니다.");
        } else {
            charge = 3000;
            System.out.println("일반인입니다.");
        }
        System.out.println("입장료는"+charge+"원 입니다.");
        // console.log(`입장료는 ${charge}원 입니다.`);

        // p. 102
            // switch : 하나의 값을 비교할 때 주로 , 논리[ > < >= <= && || ] 비교할때는 적합하지 않다.
            // break(키워드) : for , switch  문에서 사용되는 키워드
                // switch 에서 해당 case가 충족해서 실행문이 실행될 때 해당 switch 종료 / 탈출
        int ranking = 1;
        char medalColor;

        switch (ranking){   // switch(검사대상)
            case 1 : medalColor = 'G'; break;   // case 검사결과 : 실행문;
            case 2 : medalColor = 'S'; break;   // case 검사결과 : 실행문;
            case 3 : medalColor = 'B'; break;   // case 검사결과 : 실행문;
            default: medalColor = 'A';          // default(그외) : 실행문;
        }
        System.out.println( ranking+"등 메달 색깔은"+medalColor+"입니다." );

        if(ranking == 1){
            medalColor = 'G';
        } else if (ranking == 2) {
            medalColor = 'S';
        } else if (ranking ==3) {
            medalColor = 'B';
        }else {
            medalColor = 'A';
        }
        System.out.println( ranking+"등 메달 색깔은"+medalColor+"입니다." );

        // p. 105
        String medal = "Gold";

        switch (medal){ // switch(누구를){}
            case "Gold":    // case 결과비교    // break : switch 탈출
                System.out.println("금메달입니다.");
                break;
            case "Silver":
                System.out.println("은메달입니다.");
                break;
            case "Bronze":
                System.out.println("동메달입니다.");
                break;
            default:
                System.out.println("메달이 없습니다.");
                break;
        }


    }   // main e

}   // class e
