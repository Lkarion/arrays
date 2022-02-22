package com.company;

import java.util.Arrays;
import java.util.Random;

public class ArrayStringsGroups1 {
    public static void main(String[] args) {
        String[] arr = getRandomStrArray(5, 15);
       // String[] arr = {"dfn","öasfdngläa","skfj","whe","sdjl"};
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
        Random random = new Random();
        String[] arr = new String[lengthArr];
        for (int i = 0; i < lengthArr; i++) {
            StringBuilder sb = new StringBuilder();
            int lengthStr = 0;
            while(lengthStr<=0){
                lengthStr = random.nextInt(maxLengthStr);
            }
            for (int j = 0; j < lengthStr; j++) {
                sb.append((char) (random.nextInt(26)+'a'));
            }
            arr[i] = sb.toString();
        }
        return arr;
    }
}
