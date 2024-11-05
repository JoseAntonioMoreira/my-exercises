package Abilities;

import Heroes.Hero;

public class Heal extends AbstractAbility {
    public Heal(int baseDefense) {
        baseCooldown = 5;
        skill = baseDefense * 2;
        manaConsumption = 15;
    }

    @Override
    public void use(Hero hero) {
        super.use(hero);
        System.out.println("Cast heal: " + skill + " health healed");
        hero.setHealth(hero.getHealth() + skill);
    }
}
