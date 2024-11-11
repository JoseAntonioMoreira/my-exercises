import Heroes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Hero> heroes = new ArrayList<>();

        heroes.add(new Mage("Mage",1000,500,40,1,300));
        heroes.add(new Cleric("Cleric",1500,350,60,2,200));
        heroes.add(new Rogue("Rogue",1250,100,50,4,225));
        heroes.add(new Warrior("Warrior",2000,100,100,3,175));

        new Arena(heroes).start();
    }
}