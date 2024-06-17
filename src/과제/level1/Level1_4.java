package 과제.level1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Level1_4 {
    public static void main(String[] args) {

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(">> Level1_4 answer >>");
        System.out.println(">> answer time : "+dateFormat.format(today));
        // 14 자리
        System.out.println("         ,r'\"7");
        System.out.println("r`-_   ,'  ,/");
        System.out.println(" \\. \". L_r'");
        System.out.println("   `~\\/");
        System.out.println("      |");
        System.out.println("      |");
    }
}
