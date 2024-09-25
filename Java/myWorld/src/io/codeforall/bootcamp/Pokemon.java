package io.codeforall.bootcamp;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private String category;
    private String weakness;
    private Ability[] abilities = new Ability[2];
    private int evolution;
    private int health;

    public Pokemon(String name, String type1, String type2, String category, String weakness, Ability[] abilities, int evolution, int health) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.category = category;
        this.weakness = weakness;
        this.abilities = abilities;
        this.evolution = evolution;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getCategory() {
        return category;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getEvolution() {
        return evolution;
    }

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int attackDamage, String weakness) {
        if (weakness == this.weakness) {
            health -= attackDamage * 2;
        } else {
            health -= attackDamage;
        }
    }

    public Ability[] getAbilities()
    {
        return abilities;
    }

    public Ability getAbility(int index) {
        if (index <= abilities.length) {
            return abilities[index];
        }
        return null;
    }

    public int getAbilityDamage(int index) {
        if (index >= abilities.length) {
            return abilities[index].getDamage();
        }
        return 0;
    }
}
