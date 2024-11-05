package Abilities;

import Heroes.Hero;

public class ShieldBlock extends AbstractAbility{
    public int activeTurns;
    public ShieldBlock(int defense) {
        activeTurns = 3;
        baseCooldown = 5;
        skill = defense * 3;
        manaConsumption = 5;
    }

    @Override
    public void use(Hero hero) {
        super.use(hero);
        hero.setDefense(hero.getDefense() + skill);
        System.out.println("Cast shield block: +" + skill + " lasting " + activeTurns + " turns");
    }
}
