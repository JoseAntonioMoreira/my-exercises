package Abilities;

import Heroes.Hero;

public interface Ability {
    void use(Hero hero);

    void refreshCooldown();
}
