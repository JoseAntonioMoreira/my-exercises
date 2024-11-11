package Abilities;

import Heroes.Hero;

public class Fireball extends AbstractAbility {

    public Fireball(int damage) {
        baseCooldown = 3;
        skill = damage * 3;
        manaConsumption = 75;
    }

    @Override
    public void use(Hero hero) {
        super.use(hero);
        System.out.println("Cast fireball: " + skill + " true damage");
        hero.takeDamage(skill);
    }
}
