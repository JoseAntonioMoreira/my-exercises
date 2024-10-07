package io.codeforall.bootcamp.GameObjects;

public enum BarrelType {
    PLASTIC(1),
    WOOD(2),
    METAL(3);

    BarrelType(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    private int maxDamage;

    public int getMaxDamage() {
        return maxDamage;
    }
}
