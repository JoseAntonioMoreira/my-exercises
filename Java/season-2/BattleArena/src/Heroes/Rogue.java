package Heroes;

import Abilities.SneakAttack;

public class Rogue extends Hero{
    public Rogue(int health, int mana, int defense, int speed, int damage) {
        super(health, mana, defense, speed, damage);
        ability = new SneakAttack(damage);
    }
}
