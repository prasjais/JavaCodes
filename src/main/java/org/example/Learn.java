package org.example;
import java.util.*;

public class Learn {

    public static int recu(int n, int i)
    {
        if(i>n)
        {
            return -1;
        }
        System.out.println(i);
        return recu(n, i+1);
    }


    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println(t);

//        recu(10, 1);

//        String str = "James gosling";
//
//        System.out.println(str);
////
////        char[] name = str.toCharArray();
////
////        name[6] = 'G';
////
////        String str_new = "";
////        for(char i : name)
////        {
////            str_new += i;
////        }
////
////        System.out.println(str_new);
//
//        str = str.replace('g','G');
//        System.out.println(str);

//        String s1 = "Sun microsystems";
//        String s3 = new String("Sun Microsystems");
//        String s2 = "Sun Microsystems";

//        if(s1.equalsIgnoreCase(s3))
//        {
//            System.out.println("Equal");
//        }
//        else
//        {
//            System.out.println("not equal");
//        }
//        if(s1.compareTo(s3)==0)
//        {
//            System.out.println("Equal");
//        }
//        else
//        {
//            System.out.println("not equal");
//        }


    }



}
