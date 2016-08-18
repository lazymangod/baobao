package com.example.api.str;

/**
 * Created by lazygod on 2016/8/15 ${Time}.
 */
public class StringDemo {


    public static void main(String[] args) {

//
//        String name = "慧敏";
//        System.out.println(name.charAt(0));
//        System.out.println(name.codePointAt(0));
//        int length = name.length();
//        System.out.println("length = " + length);
//
//        // print str1
//        String str1 = "self";
//        System.out.println(str1);
//
//        // print str2 concatenated with str1
//        String str2 = str1.concat(" learning");
//        System.out.println(str2);
//
//
//        System.out.println("What's your name ?");
//
//        Scanner in = new Scanner(System.in);
//        //不读取空格后的字符
//        String next = in.next();
//
//        String s = in.nextLine();
//        System.out.println("s = " + s);
//
//        System.out.println("next = " + next);
//        if (next.equals("xiaoyu")) {
//            System.out.println("You are the best !");
//        } else {
//            System.out.println("foo you!");
//        }
//
//        System.out.println("How old are you ?");
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//
//        System.out.println("i = " + i);

//        Console terminal = System.console();
//        String username = terminal.readLine("User name: ");
//        String password = terminal.readLine("Password: ");

        System.out.println(1000.0/3.0);
        System.out.println(1000/3);
        System.out.printf("%1.2f \n",1000/3.0);
        System.out.printf("Hello,%s,Next year,you'll be %d.\n","xiaoyu",12);
        System.out.printf("%,+.2f\n",10000.0/3.0);
        System.out.printf("%,d\n",System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(String.format("%,d", System.currentTimeMillis()));

        System.out.printf("%,+.2f",10000.0/3.0);
    }


}
