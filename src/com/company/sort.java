package com.company;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] arr = getRandomArray(10, 0, 50);
        System.out.println(Arrays.toString(arr));
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] getRandomArray(int size, int min, int max) {
        int[] resArr = new int[size];

        for (int i = 0; i < size; i++) {
            resArr[i] = (int)(Math.random()*(max-min+1)+min);
        }
        return resArr;
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
}
