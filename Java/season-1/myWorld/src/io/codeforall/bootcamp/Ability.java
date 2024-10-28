package io.codeforall.bootcamp;

public class Ability {
    private String name;
    private int damage;

    private String type;

    public Ability(String name, int damage, String type) {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }
}
