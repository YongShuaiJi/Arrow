package com.algorithm;

public class Examle {
//    public static void sort(Comparable[] a){
//        isSorted();
//    }
    public static void main(String[] args) {
        Comparable[] a = {21,2,12,4,13,6,7};

        // 插入排序
        Comparable[] as = instertSort(a);
        for (Object i : as){
            System.out.print(i+",");
        }
        System.out.print(isSorted(as));

    }
     public static Comparable[]  selectSort(Comparable[] a){


        return null;
     }

    public static Comparable[] instertSort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++){
            for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
                exch(a,j,j-1);
            }
        }
        return a;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]+" ");
        System.out.println();
    }

    /**
     * 判断是否为有序
     * @param a
     * @return boolean
     */
    public static boolean isSorted(Comparable [] a){
        boolean bool = true;
        for (int i = 1; i < a.length; i++)
            if (less(a[i],a[i-1])) bool = false;
        if (bool) return bool;
        for (int i = 1; i < a.length; i++)
            if (less(a[i-1],a[i])) return false;
        return true;
    }

    public static double time(String alg,Double[] a){
        Examle examle = new Examle();
        if (alg.equals("Insertion")) instertSort(a);
        if (alg.equals("Select")) selectSort(a);



        return 0;
    }

    public static double timeRandomInput(String alg, int N, int T){

        return 0;
    }






}
