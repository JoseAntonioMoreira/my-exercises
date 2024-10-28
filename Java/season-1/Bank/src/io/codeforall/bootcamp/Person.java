package io.codeforall.bootcamp;

public class Person {
    private int accountID;
    private Wallet wallet;

    public Person() {
        accountID = MainBank.instance.createAccount(500);
        wallet = new Wallet(50);
    }

    public int getAccountID() {
        return accountID;
    }

    public void checkMoney() {
        System.out.println("You have " + wallet.getMoney() + "in your wallet and in your bank:");
        MainBank.instance.checkMoney(accountID);
    }

    public void depositMoney(int depositAmount) {
        if (wallet.getMoney() < 0 || wallet.getMoney() < depositAmount) {
            System.out.println("Invalid amount");
            return;
        }
        wallet.removeMoney(depositAmount);
        MainBank.instance.depositMoney(accountID, depositAmount);
        System.out.println(wallet.getMoney());
    }

    public void withdraw(int withdrawAmount) {
        if (MainBank.instance.withdrawMoney(accountID, withdrawAmount)) {
            wallet.addMoney(withdrawAmount);
            System.out.println(wallet.getMoney());
        }
    }

    public void transferMoney(int otherAccountID, int value) {
        MainBank.instance.transferMoney(accountID, otherAccountID, value);
    }
}
