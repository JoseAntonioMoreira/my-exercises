package Heroes;

import Abilities.SneakAttack;

public class Rogue extends Hero{
    public Rogue(String name, int health, int mana, int defense, int speed, int damage) {
        super(name, health, mana, defense, speed, damage);
        ability = new SneakAttack(damage);
    }

    @Override
    public void regainMana() {
       mana += 5;
    }
}
