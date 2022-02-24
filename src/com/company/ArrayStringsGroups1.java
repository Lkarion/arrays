package com.company;

import java.util.Arrays;
import java.util.Random;

public class ArrayStringsGroups1 {
    public static void main(String[] args) {
        //Imagine that you have an array of strings of random length. Implement the method that
        // returns how many groups of strings grouped by the same length are present.
        // For example, there are 5 lines in the array: 2 are 10 characters long,
        // 2 are 18 characters long and one is 4 characters long.
        // So in this array there are 3 different groups.

        //String[] arr = getRandomStrArray(5, 15);
        String[] arr = {"dfn","öasf","skfjfb","whedfgjtt","sdjl"};
        System.out.println(Arrays.toString(arr));
        System.out.println("There are " + getStringsGroups(arr) + " groups of strings");

    }

    private static int getStringsGroups(String[] arr) {
        sortArrayLengths(arr);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() != arr[i-1].length()){
                count++;
            }
        }
        return count;
    }

    public static void sortArrayLengths(String[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            String temp = arr[findMinIndex(arr,i)];
            arr[findMinIndex(arr,i)] = arr[i];
            arr[i] = temp;
        }
    }

    public static int findMinIndex(String[] array, int indexNotSorted){
        int minIndex = indexNotSorted;
        int min = array[indexNotSorted].length();
        for (int i = indexNotSorted; i < array.length; i++) {
            if (min > array[i].length()){
                min = array[i].length();
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static String[] getRandomStrArray(int lengthArr, int maxLengthStr) {
        String[] arr = new String[lengthArr];
        for (int i = 0; i < lengthArr; i++) {
            arr[i] = getRandomString(maxLengthStr);
        }
        return arr;
    }

    private static String getRandomString(int maxLengthStr) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int lengthStr = 0;
        while(lengthStr<=0){
            lengthStr = random.nextInt(maxLengthStr);
        }
        for (int j = 0; j < lengthStr; j++) {
            sb.append((char) (random.nextInt(26)+'a'));
        }
        return sb.toString();
    }
}
