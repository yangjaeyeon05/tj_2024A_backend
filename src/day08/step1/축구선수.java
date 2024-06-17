package day08.step1;

public class 축구선수 {

    private int no;
    private String name;
    private int age;
    private String position;
    private String team;

    축구선수(){}

    축구선수( int no ){
        this.no = no;
    }
    축구선수( int no , String name ){
        this.no = no;
        this.name = name;
    }
    축구선수( int no, String name , int age ){
        this.no = no;
        this.name = name;
        this.age = age;
    }
    축구선수( int no, String name , int age , String position ){
        this.no = no;
        this.name = name;
        this.age = age;
        this.position = position;
    }
    축구선수( int no, String name , int age , String position , String team ){
        this.no = no;
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "축구선수{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
