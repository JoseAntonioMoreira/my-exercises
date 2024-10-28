package io.codeforall.bootcamp.GameObjects;

public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel() {
        int random = (int) (Math.random() * BarrelType.values().length);
        switch (random) {
            case 0:
                barrelType = BarrelType.METAL;
                break;
            case 1:
                barrelType = BarrelType.WOOD;
                break;
            case 2:
                barrelType = BarrelType.PLASTIC;
                break;
        }
        currentDamage = barrelType.getMaxDamage();
    }

    @Override
    public void hit(int damage) {
        currentDamage -= damage;
        if (currentDamage <= 0) {
            destroyed = true;
        }
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public String getMessage() {
        return "I'm a barrel";
    }

}
