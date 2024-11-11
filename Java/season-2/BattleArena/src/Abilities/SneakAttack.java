package Abilities;

import Heroes.Hero;

public class SneakAttack extends AbstractAbility {
    public SneakAttack(int damage) {
        baseCooldown = 4;
        skill = damage * 5;
        manaConsumption = 35;
    }

    @Override
    public void use(Hero hero) {
        super.use(hero);
        System.out.println("Use sneak attack: " + skill + " true damage");
        hero.takeDamage(skill);

    }
}
