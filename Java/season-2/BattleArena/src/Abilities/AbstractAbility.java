package Abilities;

import Heroes.Hero;

public abstract class AbstractAbility implements Ability {
    protected int baseCooldown;
    protected int manaConsumption;
    protected int cooldown;
    protected int skill;

    public int getManaConsumption() {
        return manaConsumption;
    }

    public int getCooldown() {
        return cooldown;
    }

    private void putOnCooldown() {
        cooldown = baseCooldown;
    }

    @Override
    public void use(Hero hero) {
        putOnCooldown();
    }

    @Override
    public void refreshCooldown() {
        if (cooldown > 0) {
            cooldown--;
        }
    }
}
