package com.easy688.learn;

/**
 * 选择排序
 */
public class ChooseSort {
    public static int[] sort(int[] arrs){
        for (int i = 0; i <arrs.length-1 ; i++) {
            int index=i;
            for (int j = i+1; j <arrs.length ; j++) {
                if(arrs[index]>arrs[j]){
                    index=j;
                }
            }
            if(index!=i){
                int temp=arrs[i];
                arrs[i]=arrs[index];
                arrs[index]=temp;
            }
        }


        return arrs;
    }

    public static void main(String[] args) {
        int[] arrs={6,2,4,7,9};
        ChooseSort.sort(arrs);
        for (int i = 0; i <arrs.length ; i++) {
            System.out.println(arrs[i]);
        }
    }
}
