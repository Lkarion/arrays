package com.company;

import java.util.Arrays;
import java.util.Random;

public class randomStringArray {
    public static void main(String[] args) {
        //написать метод который заполняет массив строк случайными строками, случайной длины, заданного диапазона.
        // Строки могут ничего не означать, слова в строках - случайный набор букв.
        Random random = new Random();
        String[] strings = new String[3];
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

        System.out.println(Arrays.toString(strings));
    }
}
