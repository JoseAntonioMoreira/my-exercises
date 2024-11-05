package Abilities;

import Heroes.Hero;

public class SneakAttack extends AbstractAbility{
    public SneakAttack(int damage) {
        baseCooldown = 2;
        skill = damage * 5;
        manaConsumption = 50;
    }

    @Override
    public void use(Hero hero) {
        super.use(hero);
       hero.takeDamage(skill);
        System.out.println("Use sneak attack: " + skill + " true damage");
    }
}
