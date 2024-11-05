package Heroes;

import Abilities.ShieldBlock;

public class Warrior extends Hero{
    public Warrior(int health, int mana, int defense, int speed, int damage) {
        super(health, mana, defense, speed, damage);
        ability = new ShieldBlock(defense);
    }

    @Override
    public void attack(Hero enemy){
        ability.use(this);
        enemy.takeDamage(damage);
    }
}
