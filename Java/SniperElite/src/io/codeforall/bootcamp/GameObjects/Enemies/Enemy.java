package io.codeforall.bootcamp.GameObjects.Enemies;

import io.codeforall.bootcamp.GameObjects.GameObject;

public abstract class Enemy extends GameObject {
    private int health;

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public boolean isDead(){
        if(health > 0){
            return false;
        }
        return true;
    }

    public void hit(int damage){
        health -= damage;
    }
}
