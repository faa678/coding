package com.faa.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/4/25 14:23
 */

public class TestInput {


    public static void main(String[] args) {
        //读取键盘输入方法1：字节流
        Scanner input1 = new Scanner(System.in);
        String s1 = input1.next();
        System.out.println("读取键盘输入方法1：使用字节流的输入为：" + s1);
//        input1.close();

        //读取键盘输入方法2：字符流
        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s2 = input2.readLine();
            System.out.println("读取键盘输入方法2：使用字符流的输入为：" + s2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
