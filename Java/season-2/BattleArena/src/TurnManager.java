import Heroes.Hero;

import java.util.*;

public class TurnManager {
    private int round;
    private final ArrayList<Hero> heroes;
    private final Queue<Hero> ranking;

    public TurnManager(ArrayList<Hero> heroes) {
        this.round = 0;
        this.heroes = heroes;
        ranking = new LinkedList<>();
    }

    public void start() {
        attackOrder();

        while (ranking.size() != 4) {
            round++;
            roundRecap();
            System.out.println("---Round " + round + " start---");
            attackRound();
        }

        LeaderBoard();
    }

    private void attackOrder() {
        heroes.sort(Comparator.comparingInt(Hero::getSpeed).reversed());
    }

    private void attackRound() {
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).regainMana();

            Hero enemy = heroes.get(i).attack(heroes,ranking);

            checkEnemyDead(enemy);

            if(ranking.size() == 3){
                ranking.add(heroes.get(i));
                return;
            }
        }
    }

    private void checkEnemyDead(Hero hero) {
        if (hero.getHealth() <= 0 && !ranking.contains(hero)) {
            ranking.add(hero);
        }
    }

    private void roundRecap() {
        System.out.println("---Round " + round + "---");
        for (Hero currentHero : heroes) {
            System.out.println("Name:" + currentHero.getName() + "/ HP: " + currentHero.getHealth() + "/ Mana: " + currentHero.getMana());
        }
    }

    private void LeaderBoard() {
        if (!ranking.isEmpty()) {
            System.out.println("---Scoreboard---");
            do {
                Hero currentHero = ranking.poll();
                if (currentHero != null) {
                    System.out.println((ranking.size()+1) + "º- Name:" + currentHero.getName() + "/ HP: " + currentHero.getHealth() + "/ Mana: " + currentHero.getMana());
                }
            } while (!ranking.isEmpty());
        }
    }
}
