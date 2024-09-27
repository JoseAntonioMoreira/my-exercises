package RockPaperScissorsGame;

public class Sandbox {
    public static void main(String[] args) {
        Game RockPaperScissors = new Game();
        Player player1 = new Player("José", Game.Randomizer());
        Player player2 = new Player("João", Game.Randomizer());


        for (int i = 0; i < 3; i++) {
            RockPaperScissors.Comparison(player1.getHand(), player2.getHand());
            player1.setHand(Game.Randomizer());
            player2.setHand(Game.Randomizer());
        }
    }
}
