package com.kodilla.stream.additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseString{

    public static void main(String[] args) {

        String input = "Adam";
        char[] string = input.toCharArray();
        List<Character> newString = new ArrayList<>();

        reverse(string, newString);
        System.out.println();
        reverseTwo(input);
    }

    private static void reverse(char[] string, List<Character> newString) {
        for (char ch : string)
            newString.add(ch);

        //Reverses the order of the elements in the specified list
        Collections.reverse(newString);
        for (Character character : newString)
            System.out.print(character);
    }

    //Other solution
    private static void reverseTwo(String oldString) {

        for (int i = oldString.length()-1; i >= 0; --i) {
            System.out.print(oldString.charAt(i));
        }
    }
}