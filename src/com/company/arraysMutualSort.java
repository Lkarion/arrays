package com.company;

import java.util.Arrays;

public class arraysMutualSort {
    public static void main(String[] args) {
        //Given two big arrays of integers from 10 to 99 (it’s a result of some of test).
        // You should implement the method that mutually sorts these arrays.
        // You could use any algorithm you know
        //Example {13,78,12,18,12,36} {14,18,11,70} -> {11,12,12,13,14,18} {18,36,70,78}
        int[] arr1 = {13,78,12,18,12,36}, arr2 = {14,18,11,70};
        System.out.println("mutual sort:\nbefore\t"+Arrays.toString(arr1)+"\t"+Arrays.toString(arr2));
        mutualSort(arr1, arr2);
        System.out.println("after\t"+Arrays.toString(arr1)+"\t"+Arrays.toString(arr2));

        //** Implement the previous task, but think in your system there is not enough memory
        // for the resulting array[arr1.lenght+arr2.length] for merge like mergeSort does.
        int[] arr3 = {13,12,1,36}, arr4 = {158,14,70,0};
        System.out.println("mutual sort for less memory:\nbefore\t"+Arrays.toString(arr3)+"\t"+Arrays.toString(arr4));
        mutualSortLessMemory(arr3, arr4);
        System.out.println("after\t"+Arrays.toString(arr3)+"\t"+Arrays.toString(arr4));
    }


    private static void mutualSort(int[] arr1, int[] arr2) {
        int[] arrTemp = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arrTemp[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arrTemp[arr1.length+i] = arr2[i];
        }
        sortArr(arrTemp);
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arrTemp[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arrTemp[arr1.length+i];
        }
    }

    static int findMinIndex(int[] array, int indexNotSorted){
        int minIndex = indexNotSorted;
        int min = array[indexNotSorted];
        for (int i = indexNotSorted; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void sortArr(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int temp = array[findMinIndex(array,i)];
            array[findMinIndex(array,i)] = array[i];
            array[i] = temp;
        }
    }

    private static void mutualSortLessMemory(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            int min1 = findMinElem(arr1,i);
                int min2 = findMinElem(arr2,0);
                if (min1 <= min2){
                    int index = findMinIndex(arr1,i);
                    int temp = arr1[index];
                    arr1[index] = arr1[i];
                    arr1[i] = temp;
                }else{
                    int index = findMinIndex(arr2,0);
                    int temp = arr1[i];
                    arr1[i] = arr2[index];
                    arr2[index] = temp;
                }
        }

        sortArr(arr2);

    }
    public static int findMinElem(int[] array, int indexNotSorted){
        int min = array[indexNotSorted];
        for (int i = indexNotSorted; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
            }
        }
        return min;
    }
}
