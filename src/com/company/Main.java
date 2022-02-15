package com.company;

public class Main {

    public static void main(String[] args) {
	// 1. массив {5,4,3,2,1,0}
        int n=8;
        printArray(getArrayBack(n));
        // 2. есть ли в массиве отрицательные элементы
        System.out.println();
        int[] array1 = {5,3,-3,7,4};
        System.out.println("2. There are negative elements - "+checkIfNeg(array1));

        //3. есть ли в массиве нечентные элементы
        System.out.println();
       // int[] array1 = {5,3,-3,7};
        System.out.println("3. There are not even elements - "+checkIfNotEven(array1));

        //4. есть ли в массиве заданное число
        System.out.println();
        System.out.println("4. There is an element "+n+" - "+checkIfN(array1, n));

        //5. вернуть сумму всех четных чисел из массива
        System.out.println();
        System.out.println("5. Sum of all odd numbers = "+getSumOddNumbers(array1));

        //6. развернуть массив (5,3,4) -> (4,3,5)
        System.out.println("\n 6. Array:");
        printArray(array1);
        System.out.println("\n Reversed array:");
        printArray(getArrayReverse(array1));

        //7. заполнить массив элементами 3 * номер элемента
        System.out.println("\n 7. Array multiple 3:");
        // int[] array1 = {5,3,-3,7};
        printArray(getArrayMult3(n));
        System.out.println();

        //8. заменить все отрицат элементы абс значениями
        System.out.println("\n 8. Array abs:");
        printArray(arrayAbs(array1));
        System.out.println();
    }

    public static void printArray(int[] array){
        for (int i=0; i< array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

    private static int[] getArrayBack(int n) {
        int[] array = new int[n];
        for (int i=0; i< array.length; i++){
            array[i] = n;
            n--;
        }
        return array;
    }

    //2. есть ли отрицательные
    public static boolean checkIfNeg(int[] array){
        for (int i=0; i< array.length; i++) {
            if (array[i] < 0) {
                return true;
            }
        } return false;
    }

    //3. есть ли нечетные
    public static boolean checkIfNotEven(int[] array){
        for (int i=0; i< array.length; i++) {
            if (array[i] % 2 != 0) {
                return true;
            }
        } return false;
    }

    //4. есть ли в массиве заданное число
    public static boolean checkIfN(int[] array, int n){
        for (int i=0; i< array.length; i++) {
            if (array[i] == n) {
                return true;
            }
        } return false;
    }

    //5. вернуть сумму всех четных чисел из массива
    private static int getSumOddNumbers(int[] array) {
        int sum = 0;
        for (int i=0; i< array.length; i++){
           if (array[i] % 2 == 0) {
               sum+=array[i];
           }
        }
        return sum;
    }

    //6. развернуть массив (5,3,4) -> (4,3,5)
    private static int[] getArrayReverse(int[] array) {
        int[] arrayReversed = new int[array.length];
        int j=0;
        for (int i= array.length-1; i>=0; i--){
            arrayReversed[j] = array[i];
            j++;
        }
        return arrayReversed;
    }

    //7. заполнить массив элементами 3 * номер элемента
    private static int[] getArrayMult3(int n) {
        int[] array = new int[n];
        for (int i=0; i< array.length; i++){
            array[i] = 3*i;
        }
        return array;
    }

    //8. заменить отриц значения пол
    private static int[] arrayAbs(int[] array) {
        for (int i=0; i< array.length; i++){
            array[i] = Math.abs(array[i]);
        }
        return array;
    }
}

