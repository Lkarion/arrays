package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayStringsGroups {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int lengthArr, maxLengthStr;
        do {
            System.out.println("Enter length of an array");
            lengthArr= sc.nextInt();
            System.out.println("Enter maximal length of a string in the array");
            maxLengthStr= sc.nextInt();

        }while (lengthArr<=0 || maxLengthStr<=0);

        String[] arr = getRandomStrArray(lengthArr, maxLengthStr);

      //  String[] arr = {"dfn","öasfdngläa","skfj","whe","sdjl"};
        System.out.println(Arrays.toString(arr));
        System.out.println("There are " + getStringsGroups(arr) + " groups of strings");

    }

    private static int getStringsGroups(String[] arr) {
        int len = arr.length;
        int[] lengths = new int[len];
        for (int i = 0; i < len; i++) {
            lengths[i] = arr[i].length();
        }
        Arrays.sort(lengths);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (lengths[i] != lengths[i-1]){
                count++;
            }
        }
        return count;
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
