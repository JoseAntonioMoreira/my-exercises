import Heroes.Hero;

import java.util.ArrayList;

public class Arena {
    private final TurnManager turnManager;

    public Arena(ArrayList<Hero> heroes){
        turnManager = new TurnManager(heroes);
    }

    public void start(){
        turnManager.start();
    }
}
