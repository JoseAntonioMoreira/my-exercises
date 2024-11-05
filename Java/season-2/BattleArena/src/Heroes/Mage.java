package Heroes;

import Abilities.Fireball;

public class Mage extends Hero {

    public Mage(int health, int mana, int defense, int speed, int damage) {
        super(health, mana, defense, speed, damage);
        ability = new Fireball(damage);
    }
}
