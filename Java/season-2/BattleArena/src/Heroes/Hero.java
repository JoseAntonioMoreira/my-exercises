package Heroes;

import Abilities.AbstractAbility;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public abstract class Hero {
    protected String name;
    protected int health;
    protected int mana;
    protected int defense;
    protected int speed;
    protected int damage;
    protected AbstractAbility ability;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Hero(String name, int health, int mana, int defense, int speed, int damage) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.damage = damage;
    }

    public void regainMana(){
        this.mana += 1;
    }
    public void takeDamage(int damage) {
        if (health <= 0) {
            System.out.println(name + " is already dead");
            return;
        }

        if (defense < damage) {
            health -= damage - defense;
            System.out.println(name + " took " + (damage - defense) + " damage. Health: " + getHealth());
            return;
        }

        System.out.println(name + " resisted the " + damage + " damage because is defense is " + defense);
    }

    public Hero attack(ArrayList<Hero> heroes, Queue<Hero> ddd) {
        System.out.println(name + " turn:");

        if(getHealth() <= 0){
            System.out.println("I'm dead");
            return this;
        }

        int enemy = selectEnemy(heroes,ddd);

        if (tryCastingAbility(heroes.get(enemy))) {
            return heroes.get(enemy);
        }

        normalAttack(heroes.get(enemy));
        return heroes.get(enemy);
    }

    protected void normalAttack(Hero hero){
        System.out.println("normal attack " + damage + " true damage at " + hero.getName());
        hero.takeDamage(damage);
    }

    protected boolean tryCastingAbility(Hero hero) {
        ability.refreshCooldown();

        if(mana < ability.getManaConsumption()){
            System.out.println("Not enough mana");
            return false;
        }

        if (ability.getCooldown() <= 0 && mana >= ability.getManaConsumption()) {
            ability.use(hero);
            mana -= ability.getManaConsumption();
            return true;
        }

        System.out.println("Ability still on cooldown " + ability.getCooldown());
        return false;
    }

     protected int selectEnemy(ArrayList<Hero> heroes, Queue<Hero> ddd) {
        int enemyIndex;
        Random random = new Random();

        do {
            enemyIndex = random.nextInt(0, heroes.size());
        } while (heroes.get(enemyIndex) == this || heroes.get(enemyIndex).getHealth() <= 0);

        return enemyIndex;
    }
}
