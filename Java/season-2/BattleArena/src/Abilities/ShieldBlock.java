package Abilities;

import Heroes.Hero;

public class ShieldBlock extends AbstractAbility {
    public int activeTurns;
    public int turnsPassed;

    public int getActiveTurns() {
        return activeTurns;
    }

    public int getTurnsPassed() {
        return turnsPassed;
    }

    public void setTurnsPassed(int turnsPassed) {
        this.turnsPassed = turnsPassed;
    }

    public ShieldBlock(int defense) {
        activeTurns = 3;
        turnsPassed = 0;
        baseCooldown = 5;
        skill = defense * 3;
        manaConsumption = 5;
    }

    @Override
    public void use(Hero hero) {
        super.use(hero);
        System.out.println("Cast shield block: +" + skill + " lasting " + activeTurns + " turns");
        hero.setDefense(hero.getDefense() + skill);
        turnsPassed = 0;
    }

    public int checkBuff() {
        if (getTurnsPassed() < getActiveTurns()) {
           setTurnsPassed(getTurnsPassed() + 1);
        } else {
            System.out.println("buff lost");
            setTurnsPassed(0);
            return 5;
        }
        return skill;
    }

}
