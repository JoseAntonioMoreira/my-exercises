package Heroes;

import Abilities.Heal;

import java.util.ArrayList;
import java.util.Queue;

public class Cleric extends Hero {
    public Cleric(String name, int health, int mana, int defense, int speed, int damage) {
        super(name, health, mana, defense, speed, damage);
        ability = new Heal(defense);
    }

    @Override
    public void regainMana() {
        mana += 35;
    }

    @Override
    public Hero attack(ArrayList<Hero> heroes, Queue<Hero> ddd) {
        System.out.println(name + " turn:");

        if (getHealth() <= 0) {
            System.out.println("I'm dead");
            return this;
        }

        int enemy = selectEnemy(heroes, ddd);

        if (tryCastingAbility(this)) {
            return heroes.get(enemy);
        }

        normalAttack(heroes.get(enemy));
        return heroes.get(enemy);
    }
}
