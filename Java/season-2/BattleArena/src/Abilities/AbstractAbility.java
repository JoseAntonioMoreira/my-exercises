package Abilities;

public abstract class AbstractAbility implements Ability {
    protected int manaConsumption;
    protected int cooldown;
    protected int skill;

    public int getManaConsumption() {
        return manaConsumption;
    }

    public int getCooldown() {
        return cooldown;
    }

    @Override
    public void refreshCooldown() {
        if (cooldown > 0) {
            cooldown--;
        }
    }
}
