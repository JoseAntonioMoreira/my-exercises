package Heroes;

import Abilities.AbstractAbility;

public abstract class Hero {
    protected int health;
    protected int mana;
    protected int defense;
    protected int speed;
    protected int damage;
    protected AbstractAbility ability;

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getSpeed() {
        return speed;
    }

    public Hero(int health, int mana, int defense, int speed, int damage) {
        this.health = health;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        if (health > 0 && defense < damage) {
            health -= damage - defense;
        }
    }

    public void attack(Hero enemy) {
        if (checkAbility(enemy)) {
            return;
        }
        enemy.takeDamage(damage);
    }

    protected boolean checkAbility(Hero hero) {
        ability.refreshCooldown();

        if (ability.getCooldown() <= 0 || mana >= ability.getManaConsumption()) {
            ability.use(hero);
            return true;
        }
        return false;
    }
}
