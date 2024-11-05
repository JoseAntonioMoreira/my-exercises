package Heroes;

import Abilities.Fireball;

public class Mage extends Hero {

    public Mage(String name, int health, int mana, int defense, int speed, int damage) {
        super(name, health, mana, defense, speed, damage);
        ability = new Fireball(damage);
    }
}
