package io.codeforall.bootcamp;

public class Wallet {
    private int money;

    public Wallet(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeMoney(int money){
        this.money -= money;
    }
}
