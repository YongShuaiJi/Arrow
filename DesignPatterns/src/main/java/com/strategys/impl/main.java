package com.strategys.impl;

public class main {
    public static void main(String[] args) {
//        System.out.println(count(11));
//        System.out.println(bosh(1001));
        int[] arr = {2,4,6,7,8,43,233,444,555,666};
//        System.out.println(binary(444,arr,0,arr.length-1));
        System.out.println(binary(777,arr));
    }

    public static int count(int args) {
        if (args == 1) return 1;
        if (args == 2) return 2;

        int sum = count(args -2)+ count(args -1);
        return sum;

    }

    public static boolean bosh(int num){

        boolean mark = true;
        if (num < 2) return mark;
        for(int i = num-1 ;i > 1;i --){
            if (num % i == 0) return false;
        }
        return mark;
    }

    public static int binary(int key,int[] arr,int min,int max){
        if (min > max) return -1;
        int middle = (max+min)/2;
        if(arr[middle] > key) return binary(key,arr,min,middle-1);
        if (arr[middle] < key) return binary(key,arr,middle+1,max);
        if (arr[middle] == key) return middle;
        return -1;
    }

    public static int binary(int key,int[] arr){
        int moddle = (arr.length-1)/2;
        while (arr[moddle] != key){
            if (arr[moddle] > key){
                moddle = moddle/2;
            }else if(arr[moddle] < key) {
                moddle = (moddle+arr.length)/2;
            }else if (moddle < 0 || moddle > arr.length-1){
                return -1;
            }
        }
        return moddle;
    }
}
