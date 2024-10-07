package io.codeforall.bootcamp;

import io.codeforall.bootcamp.GameObjects.Enemies.Enemy;

public class SniperRifle {
    private final int BULLETDAMAGE = 1;
    private final float HIT_PERCENTAGE = 0.9f;

    public void shoot(Enemy gameObject) {
        if (Math.random() <= HIT_PERCENTAGE) {
            gameObject.hit(BULLETDAMAGE);
            System.out.println("Bullseye");
        } else {
            System.out.println("Missed shot");
        }
    }
}
