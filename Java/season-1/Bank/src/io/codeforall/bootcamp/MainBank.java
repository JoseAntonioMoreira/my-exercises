package io.codeforall.bootcamp;

public class MainBank {

    private class Account {
        private int money;

        private Account(int money) {
            this.money = money;
        }
    }

    public static MainBank instance = new MainBank();

    private Account[] accounts;

    private MainBank() {
        if (instance != null) {
            return;
        }
        accounts = new Account[0];
    }

    public int createAccount(int startingMoney) {
        Account[] tempAccounts = new Account[accounts.length];
        for (int i = 0; i < tempAccounts.length; i++) {
            tempAccounts[i] = accounts[i];
        }

        accounts = new Account[tempAccounts.length + 1];

        for (int i = 0; i < tempAccounts.length; i++) {
            accounts[i] = tempAccounts[i];
        }

        accounts[accounts.length - 1] = new Account(startingMoney);
        return accounts.length - 1;
    }

    public void checkMoney(int id) {
        System.out.println("You have " + accounts[id].money);
    }

    public void depositMoney(int id, int depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        accounts[id].money += depositAmount;
        checkMoney(id);
    }

    public boolean withdrawMoney(int id, int withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }

        if (withdrawAmount > accounts[id].money) {
            System.out.println("Not enough money");
            return false;
        }
        accounts[id].money -= withdrawAmount;
        checkMoney(id);
        return true;
    }

    public void transferMoney(int idAccount1, int idAccount2, int value) {
        if (value <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (idAccount1 > accounts.length - 1 || idAccount2 > accounts.length - 1 || idAccount1 < 0 || idAccount2 < 0) {
            System.out.println("Invalid account id");
            return;
        }

        if (accounts[idAccount1].money < value) {
            System.out.println("Not enough money");
            return;
        }

        withdrawMoney(idAccount1, value);
        depositMoney(idAccount2,value);
    }
}

