package io.codeforall.bootcamp;

import io.codeforall.bootcamp.GameObjects.Enemies.Enemy;

public class SniperRifle {
    private final float HIT_PERCENTAGE = 0.9f;

    public void shoot(Enemy gameObject) {
        if (Math.random() <= HIT_PERCENTAGE) {
            int bulletDamage = 1;
            gameObject.hit(bulletDamage);
            System.out.println("Bullseye");
        } else {
            System.out.println("Missed shot");
        }
    }
}
