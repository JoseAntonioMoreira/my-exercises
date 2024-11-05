package Abilities;

import Heroes.Hero;

public class Heal extends AbstractAbility{
    public Heal(int baseDefense) {
        skill = baseDefense * 2;
        manaConsumption = 15;
    }

    @Override
    public void use(Hero hero) {

    }
}
