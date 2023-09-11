import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {


            Scanner scan = new Scanner(System.in);

            String func = scan.nextLine();

            if (func.equals("a")) {
                System.out.println("기능1");

            } else if (func.equals("b")) {
                System.out.println("기능2");

            } else if (func.equals("도움말")) {
                System.out.println("a : 기능1");
                System.out.println("b : 기능2");

            }
            else if(func.equals("exit")){
                break;

            }

            //숫자 비교
            //int n = 3;
            //System.out.println(n == 3);

            //문자열 비교
            //String str = "hello";
            //System.out.println(str.equals("hello"));


        }
    }
}
