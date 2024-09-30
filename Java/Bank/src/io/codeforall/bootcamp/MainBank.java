package io.codeforall.bootcamp;

public class MainBank {
    public static MainBank instance = new MainBank();

    private Wallet[] accounts;

    private MainBank() {
        if (instance != null) {
            return;
        }
        accounts = new Wallet[1];
    }

    public int createAccount(int startingMoney) {
        Wallet[] tempAccounts = new Wallet[accounts.length];
        for (int i = 0; i < tempAccounts.length; i++) {
            tempAccounts[i] = accounts[i];
        }

        accounts = new Wallet[tempAccounts.length + 1];

        for (int i = 0; i < tempAccounts.length; i++) {
            accounts[i] = tempAccounts[i];
        }

        accounts[accounts.length - 1] = new Wallet(startingMoney);
        return accounts.length - 1;
    }

    public void checkMoney(int id) {
        System.out.println("You have " + accounts[id].getMoney());
    }

    public void depositMoney(int id, int depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        accounts[id].addMoney(depositAmount);
        checkMoney(id);
    }

    public void withdrawMoney(int id, int withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (withdrawAmount > accounts[id].getMoney()) {
            System.out.println("Not enough money");
            return;
        }
        accounts[id].removeMoney(withdrawAmount);
        checkMoney(id);
    }

    public void transferMoney(int idAccount1, int idAccount2, int value) {
        if (value <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (idAccount1 > accounts.length - 1 || idAccount2 > accounts.length - 1) {
            System.out.println("Invalid account id");
            return;
        }

        if (accounts[idAccount1].getMoney() < value) {
            System.out.println("Not enough money");
            return;
        }

        accounts[idAccount1].removeMoney(value);
        MainBank.instance.accounts[idAccount1].getMoney();
        accounts[idAccount2].addMoney(value);
        MainBank.instance.accounts[idAccount2].getMoney();
    }
}

