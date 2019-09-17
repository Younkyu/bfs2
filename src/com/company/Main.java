package com.company;
//소들의 줄

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static ArrayList<String[]> box = new ArrayList<>();

    public static String[] zz = {"1", "-", "2" ,".","3", "+", "4", "+", "5", "+", "6", "+", "7" };
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //총 몇개의 숫자를 입력 받을 것인지
        int a;
        int b = 1;
        int c = 0;

        a = sc.nextInt();

        String[] x = new String[(2*a)-1];

        for(int i = 0 ; i < x.length ; i = i+2) {
            x[i]  = String.valueOf(b);
            b++;
        }

        dessert(x,0,a-1);
        System.out.println(count);
    }

    public static void dessert(String[] input,int a, int max) {

        if(a == max) {
            if(operationSum(input) == 0) {
                count++;
                if(count <= 20)printString(input);
            }
        }else {
            input[(2*a)+1] = "+";
            dessert(input,a+1,max);
            input[(2*a)+1] = "-";
            dessert(input,a+1,max);
            input[(2*a)+1] = ".";
            dessert(input,a+1,max);
        }
    }

    public static void printString(String[] input) {

        for(int i = 0 ; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
        System.out.println("");
    }

    public static String[] deepcopy(String[] input) {
        String[] result = new String[input.length];

        for(int i = 0 ; i < input.length; i++) {
            result[i] = input[i];
        }
        return result;
    }

    public static int operationSum(String[] in) {

        //ex 1 + 2 - 3 + 4 - 5 - 6 + 7
        int sum = 0;
        int plus = 0;
        String operation = "+";
        String[] input = deepcopy(in);

        // 처리
        for(int i = 0; i < input.length; i++) {
            String z = input[i];
            if(z.equals(".")) {
                int a = Integer.parseInt(input[i-1]);
                input[i-1] = "0";
                if(Integer.parseInt(input[i+1]) < 10) {
                    input[i+1] = String.valueOf(a*10 + Integer.parseInt(input[i+1]));
                }else {
                    input[i+1] = String.valueOf(a*100 + Integer.parseInt(input[i+1]));
                }
                input[i] = operation;
            }else if(z.equals("+") || z.equals("-")) {
                operation = z;
            }
        }
        operation = "+";


        for(int i = 0; i < input.length; i++) {
            String z = input[i];
            switch (z) {
                case "+" :
                    operation = z;
                    break;
                case "-" :
                    operation = z;
                    break;
                default:
                    plus = Integer.parseInt(z);
                    if(operation.equals("+")) sum = sum+plus;
                    else if(operation.equals("-")) sum = sum-plus;
            }
        }

        return sum;
    }

}





