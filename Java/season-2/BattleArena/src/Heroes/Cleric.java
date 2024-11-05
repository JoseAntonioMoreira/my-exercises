package Heroes;

import Abilities.Heal;

public class Cleric extends Hero {
    public Cleric(int health, int mana, int defense, int speed, int damage) {
        super(health, mana, defense, speed, damage);
        ability = new Heal(defense);
    }

    @Override
    public void attack(Hero enemy){
        ability.use(this);
        enemy.takeDamage(damage);
    }
}
