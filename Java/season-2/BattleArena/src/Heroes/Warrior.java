package Heroes;

import Abilities.ShieldBlock;

public class Warrior extends Hero {
    public Warrior(String name, int health, int mana, int defense, int speed, int damage) {
        super(name, health, mana, defense, speed, damage);
        ability = new ShieldBlock(defense);
    }

    @Override
    public void attack(Hero hero) {
        if (checkAbility(this)) {
            return;
        }
        hero.takeDamage(damage);
    }
}
