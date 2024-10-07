package io.codeforall.bootcamp.GameObjects.Enemies;

import io.codeforall.bootcamp.GameObjects.Destroyable;

public class SoldierEnemy extends Enemy implements Destroyable{

    public SoldierEnemy(){
        setHealth(3);
    }

    @Override
    public boolean isDestroyed(){
        return isDead();
    }

    @Override
    public String getMessage() {
        return "I'm a normal soldier";
    }

}
