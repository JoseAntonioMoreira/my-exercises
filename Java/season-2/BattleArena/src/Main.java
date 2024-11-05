import Heroes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Hero> heroes = new ArrayList<>();

        heroes.add(new Mage("Mage",100,100,5,1,10));
        heroes.add(new Cleric("Cleric",100,100,5,2,10));
        heroes.add(new Rogue("Rogue",100,100,5,4,10));
        heroes.add(new Warrior("Warrior",100,100,5,3,10));

        new Arena(heroes).start();
    }
}