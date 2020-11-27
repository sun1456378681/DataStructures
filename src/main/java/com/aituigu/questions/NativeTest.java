package com.aituigu.questions;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/11 15:02
 */
public class NativeTest {

    public static void main(String[] args) {

        String str2 = new StringBuffer().append("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

        String str1 = new StringBuffer().append("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());



    }
}
