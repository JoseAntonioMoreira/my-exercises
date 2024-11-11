package Heroes;

import Abilities.ShieldBlock;

import java.util.ArrayList;
import java.util.Queue;

public class Warrior extends Hero {
    public Warrior(String name, int health, int mana, int defense, int speed, int damage) {
        super(name, health, mana, defense, speed, damage);
        ability = new ShieldBlock(defense);
    }


    @Override
    public Hero attack(ArrayList<Hero> heroes, Queue<Hero> ddd) {
        System.out.println(name + " turn:");

       if(ability instanceof ShieldBlock){
           defense = ((ShieldBlock) ability).checkBuff();
       }

        if(getHealth() <= 0){
            System.out.println("I'm dead");
            return this;
        }

        int enemy = selectEnemy(heroes,ddd);

        if (tryCastingAbility(this)) {
            return heroes.get(enemy);
        }

        normalAttack(heroes.get(enemy));
        return heroes.get(enemy);
    }
}
