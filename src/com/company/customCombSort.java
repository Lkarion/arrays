package com.company;

import java.util.Arrays;
import java.util.Random;

public class customCombSort {
    public static void main(String[] args) {
        String[] strings = new String[6];
        getRandomArray(strings);

        System.out.println(Arrays.toString(strings));
        combSort(strings);
        System.out.println(Arrays.toString(strings));

    }

    public static void getRandomArray(String[] strings){
        Random random = new Random();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder str = new StringBuilder();
            int strSize = 0;
            while(strSize <= 0)
                strSize = random.nextInt(10);
            for (int j = 0; j < strSize; j++) {
                str.append((char) (random.nextInt(26)+'a'));
            }
            strings[i] = str.toString();
        }
    }

    public static String[] combSort(String[] array){
        int length = array.length;
        int gap = length;
        boolean flag = true;

        while(gap>1 || flag) {
            flag = false;
            gap = (int) (gap / 1.247330950103979);

            for (int i = 0; i < length - gap; i++) {
                if (array[i].compareTo(array[i+gap]) > 0){
                    String temp = array[i];
                    array[i] = array[i+gap];
                    array[i+gap] = temp;
                    flag = true;
                }
            }
        }

        return array;
    }
}
