package 과제.level4;

public class Member {
    int no;
    String id;
    String password;
    String name;

    @Override
    public String toString() {
        return "Member{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
