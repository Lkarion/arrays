package com.company;

import java.util.Arrays;

public class names {
    public static void main(String[] args) {
        //Imagine you have an array of first names, for example {“Olga”, ”Andrey”, “Sergey”, “Oleg”, “Elena”}
        // and you have an array of persons {“Olga Sergeeva”, “Nikolaev Andrey”, “Elena Maers”, “Nina Umova”, “Tarasova Elena”}.
        // You should implement the method that normalizes the persons array: the first name should be first, the last
        // name the second. If there is no information about first name in the names array the leave this person
        // as is and print the message.
        //Input:
        //{“Olga”, ”Andrey”, “Sergey”, “Oleg”, “Elena”}
        //{“Olga Sergeeva”, “Nikolaev Andrey”, “Elena Maers”, “Nina Umova”, “Tarasova Elena”, “Lavrov Oleg”}
        //
        //Output: {“Olga Sergeeva”, “Andrey Nikolaev”, “Elena Maers”, “Nina Umova”, “Elena Tarasova”,”Oleg Lavrov”}
        //and message: Nina Uvarova – there is no data about first name “Nina” or first name “Uvarova”
        String[] firstNames = {"Olga","Andrey", "Sergey", "Oleg", "Elena"};
        String[] persons = {"Sergeeva Olga", "Nikolaev Andrey", "Elena Maers", "Igrin Roman", "Nina Umova", "Tarasova Elena", "Lavrov Oleg"};
        normalizePersons(firstNames, persons);
    }

    private static void normalizePersons(String[] firstNames, String[] persons) {
        for (int i = 0; i < persons.length; i++) {
            String[] name = persons[i].split(" ");
            if (isName(persons[i], firstNames)){
                persons[i] = normalName(persons[i], name, firstNames);
            }else{
                System.out.println(persons[i]+ " – there is no data about first name “"+ name[0]+
                        "” or first name “"+name[1]+"”");
            }
        }
        System.out.println(Arrays.toString(persons));
    }
    public static String normalName(String person, String[] name, String[] firstNames){
        for (int j = 0; j < firstNames.length; j++) {
                if (name[1].equals(firstNames[j])){
                    person = name[1] + " " + name[0];
                    // StringBuilder newName = new StringBuilder();
                    // newName.append(name[1]).append(' ').append(name[0]);
                }
        }
        return person;
    }

    public static boolean isName (String person, String[] firstNames){
        for (int j = 0; j < firstNames.length; j++) {
            if (person.contains(firstNames[j])) return true;
        }
        return false;
    }
}
