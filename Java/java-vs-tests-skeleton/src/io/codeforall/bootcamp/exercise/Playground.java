package io.codeforall.bootcamp.exercise;

public class Playground {
    public static void main(String[] args) {
        Ai ai = new Ai("hoje", "Jose");

        int[] doblueArrayContent = {10,20,30,40};
        System.out.println(ai.doubleArray(doblueArrayContent));

        System.out.println(ai.factorialIterative(5));
        System.out.println(ai.factorialIterative(0));
        System.out.println(ai.factorialIterative(1));

        System.out.println(ai.factorialRecursive(5));
        System.out.println(ai.factorialRecursive(0));
        System.out.println(ai.factorialRecursive(1));

        System.out.println(ai.palindromeReplace("racecar race level okay"));
        System.out.println(ai.palindromeReplace("racecar race, level okay"));
        System.out.println(ai.palindromeReplace("racecar race level, okay"));

        System.out.println(ai.emailValidator());
    }
    
}
