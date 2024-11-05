package Heroes;

import Abilities.AbstractAbility;

public abstract class Hero {
    protected String name;
    protected int health;
    protected int mana;
    protected int defense;
    protected int speed;
    protected int damage;
    protected AbstractAbility ability;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Hero(String name, int health, int mana, int defense, int speed, int damage) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        if(health <= 0){
            System.out.println(name + " is already dead");
            return;
        }

        if (defense < damage) {
            System.out.println(name + " took " + (damage - defense) + " damage");
            health -= damage - defense;
            return;
        }

        System.out.println(name + " resisted the " + damage + " damage because is defense is " + defense);
    }

    public void attack(Hero hero) {
        System.out.println(name + " turn:");

        if (checkAbility(hero)) {
            return;
        }

        System.out.println("normal attack " + damage + " true damage");
        hero.takeDamage(damage);
    }

    protected boolean checkAbility(Hero hero) {
        ability.refreshCooldown();

        if (ability.getCooldown() <= 0 || mana >= ability.getManaConsumption()) {
            ability.use(hero);
            mana -= ability.getManaConsumption();
            return true;
        }
        System.out.println("Ability still on cooldown " + ability.getCooldown());
        return false;
    }
}
