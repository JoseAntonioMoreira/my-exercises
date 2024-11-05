package Abilities;

import Heroes.Hero;

public class ShieldBlock extends AbstractAbility{
    public ShieldBlock(int defense) {
        skill = defense * 3;
        manaConsumption = 5;
    }

    @Override
    public void use(Hero hero) {

    }
}
