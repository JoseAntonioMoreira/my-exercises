package RockPaperScissorsGame;

public class Game {
    public static Hand Randomizer() {
        int number = (int) Math.floor(Math.random() * 3);

        switch (number) {
            case 0:
                return Hand.ROCK;                     // dar return a Hand.ROCK para pooder receber e neste switch case n ha breaks , porque tem returns;
            case 1:
                return Hand.PAPER;
            default:
                return Hand.SCISSORS;                  // redudancia do compilador | compilador exige mas nc vai ser default

        }
    }




    public void Comparison(Hand Player1, Hand Player2){
        if(Player1==Player2){
            System.out.println("Draw!  "+"Player 1 gets "+Player1+" Player 2 gets "+Player2);
            return;
        }

        if((Player1 == Hand.ROCK && Player2 == Hand.SCISSORS) ||(Player1 == Hand.PAPER && Player2 == Hand.ROCK)||(Player1==Hand.SCISSORS && Player2==Hand.PAPER)){
            System.out.println("Player 1 wins!  "+"Player 1 gets "+Player1+" Player 2 gets "+Player2);

        }
        else{
            System.out.println("Player 2 wins!  "+"Player 1 gets "+Player1+" Player 2 gets "+Player2);
        }
    }



}
