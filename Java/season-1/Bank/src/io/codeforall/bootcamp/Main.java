package io.codeforall.bootcamp;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person();

        person.depositMoney(50);
        person.checkMoney();
        person.withdraw(450);
        person.checkMoney();
        person.transferMoney(person1.getAccountID(), 1000);

    }
}
