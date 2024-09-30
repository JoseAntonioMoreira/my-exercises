package io.codeforall.bootcamp;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person();

        person.depositMoney(1500);
        person.checkMoney();

        person.transferMoney(person1.getAccountID(),500);
        person1.checkMoney();
        person.checkMoney();
    }
}
