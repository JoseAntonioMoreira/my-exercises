package io.codeforall.bootcamp.GameObjects.Enemies;

public class ArmouredEnemy extends SoldierEnemy{

    private int armour;

    public ArmouredEnemy() {
        super();
        this.armour = 2;
    }

    @Override
    public void hit(int damage) {

        if(armour > 0){
            armour -= damage;
        }
        else{
            setHealth(getHealth() - damage);
        }

        if (armour < 0) {
            setHealth(getHealth() + armour);
            armour = 0;
        }
    }

    @Override
    public String getMessage() {
        return "I'm an armoured soldier";
    }
}
