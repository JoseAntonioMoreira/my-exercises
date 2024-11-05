package Abilities;

import Heroes.Hero;

public class SneakAttack extends AbstractAbility{
    public SneakAttack(int damage) {
        skill = damage * 5;
        manaConsumption = 50;
    }

    @Override
    public void use(Hero hero) {
        
    }
}
