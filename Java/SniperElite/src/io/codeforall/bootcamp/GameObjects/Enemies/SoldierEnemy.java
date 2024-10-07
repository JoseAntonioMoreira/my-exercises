package io.codeforall.bootcamp.GameObjects.Enemies;

public class SoldierEnemy extends Enemy{
    public SoldierEnemy(){
        setHealth(3);
    }

    @Override
    public String getMessage() {
        return "I'm a normal soldier";
    }

}
