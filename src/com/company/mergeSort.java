package com.company;

import java.util.Arrays;
import java.util.Random;

public class mergeSort {
    public static void main(String[] args) {
        int[] array = getNewRandomArray(20, -10, 50);
        System.out.println(Arrays.toString(array));
        makeMergeSort(array);
        System.out.println(Arrays.toString(array));

    }
    public static int[] getNewRandomArray(int size, int min, int max){
        int[] array = new int[size];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max-min+1)+min;
        }
        return array;
    }

    private static void makeMergeSort(int[] inputArray) {
        if (inputArray.length < 2) return;
        
        int midIndex = inputArray.length/2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputArray.length-midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputArray.length; i++) {
            rightHalf[i-midIndex] = inputArray[i];
        }

        makeMergeSort(leftHalf);
        makeMergeSort(rightHalf);

        makeFinalMerge(inputArray,leftHalf,rightHalf);
    }

    private static void makeFinalMerge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int i=0, j=0, k=0;

        while (i < leftHalf.length && j < rightHalf.length){
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k++] = leftHalf[i++];
            }else{
                inputArray[k++] = rightHalf[j++];
            }
        }
        while (i< leftHalf.length){
            inputArray[k++] = leftHalf[i++];
        }
        while (j< rightHalf.length){
            inputArray[k++] = rightHalf[j++];
        }
    }

}
