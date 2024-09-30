package io.codeforall.bootcamp;

public class Person {
    private int accountID;

    public Person(){
        accountID = MainBank.instance.createAccount(200);
    }

    public int getAccountID() {
        return accountID;
    }

    public void checkMoney(){
        MainBank.instance.checkMoney(accountID);
    }

    public void depositMoney(int depositAmount){
        MainBank.instance.depositMoney(accountID,depositAmount);
    }

    public void withdraw(int withdrawAmount){
        MainBank.instance.withdrawMoney(accountID,withdrawAmount);
    }

    public void transferMoney(int otherAccountID, int value){
        MainBank.instance.transferMoney(accountID,otherAccountID,value);
    }
}
