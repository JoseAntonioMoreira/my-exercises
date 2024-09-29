package io.codeforall.bootcamp.exercise;

public class Ai {
    private String creationDate;
    private String name;

    public Ai(String creationDate, String name){
        this.creationDate = creationDate;
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] doubleArray(int[] undoubleArray){
        int[] tempArray = new int[undoubleArray.length];
        for (int i = 0; i < undoubleArray.length; i++) {
            tempArray[i] = undoubleArray[i] * 2;
        }
        return tempArray;
    }

    public int factorialIterative(int factorial){
        int result = 1;
        
        if (factorial < 0) {
            throw new IllegalArgumentException("Factorial method only takes non-negative numbers");
        }

        if(factorial == 0){
            return 1;
        }

        for (int i = factorial; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public int factorialRecursive(int factorial){
        if (factorial < 0) {
            throw new IllegalArgumentException("Factorial method only takes non-negative numbers");
        }

        if(factorial == 0){
            return 1;
        }

        return factorial * factorialRecursive(factorial - 1);
    }

    public String palindromeReplace(String palindromePhrase){
        String result ="";
        String[] splicedPhrase = palindromePhrase.split(" ");
        for (int i = 0; i < splicedPhrase.length; i++) {
            String invertedString = "";
            for (int j = splicedPhrase[i].length() -1 ; j >= 0; j--) {
                invertedString += (splicedPhrase[i].charAt(j));
            }

            if(splicedPhrase[i].equalsIgnoreCase(invertedString)){
                splicedPhrase[i]= "palindrome";
            }
            result = result.concat(splicedPhrase[i]) + " ";
        }
        result = result.trim();
        return result;
    }

    public String emailValidator(){
        return "";
    }
}

