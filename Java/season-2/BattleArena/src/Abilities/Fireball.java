package Abilities;

import Heroes.Hero;

public class Fireball extends AbstractAbility {

    public Fireball(int damage) {
        skill = damage * 3;
        manaConsumption = 25;
    }

    @Override
    public void use(Hero hero) {

    }
}
