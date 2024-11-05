import Heroes.Hero;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class TurnManager {
    private int round;
    private ArrayList<Hero> heroes;
    private Stack<Hero> ranking;

    public TurnManager(ArrayList<Hero> heroes) {
        this.round = 0;
        this.heroes = heroes;
        ranking = new Stack<>();
    }

    public void start() {
        while (heroes.size() != 1) {
            round++;
            System.out.println("Round " + round + " start:");
            attackRound();
        }

        LeaderBoard();
    }

    private void attackRound() {
        for (int i = 0; i < heroes.size(); i++) {
            int enemyIndex;

            while (true) {
                enemyIndex = new Random().nextInt(0, heroes.size());
                if (enemyIndex != i) {
                    break;
                }
            }

            heroes.get(i).attack(heroes.get(enemyIndex));
            if (heroes.get(enemyIndex).getHealth() <= 0) {
                ranking.push(heroes.get(enemyIndex));
                heroes.remove(enemyIndex);
            }
        }
    }

    private void roundRecap() {
        if (heroes.size() > 0) {
            for (int i = 0; i < heroes.size(); i++) {

            }
        }

        if (ranking.size() > 0) {
            for (int i = 0; i < ranking.size(); i++) {

            }
        }
    }

    private void LeaderBoard() {
        ranking.push(heroes.get(0));
        heroes.remove(heroes.get(0));
    }
}
