package Heroes;

import Abilities.Heal;

public class Cleric extends Hero {
    public Cleric(String name, int health, int mana, int defense, int speed, int damage) {
        super(name, health, mana, defense, speed, damage);
        ability = new Heal(defense);
    }

    @Override
    public void attack(Hero hero) {
        if (checkAbility(this)) {
            return;
        }
        hero.takeDamage(damage);
    }
}
