package day14.step7;

import java.util.ArrayList;

public class Shelf {
    // 1. 멤버변수
    public ArrayList<String> shelf;
        // ArrayList<타입> 리스트 변수명 vs 타입[] 배열

    // 2. 생성자
    public Shelf(){
        shelf = new ArrayList<String>();
    }
    // 3. 메소드
    public ArrayList<String> getShelf(){
        return shelf;
    }

    public int getCount(){
        return shelf.size();
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelf=" + shelf +
                '}';
    }
}
