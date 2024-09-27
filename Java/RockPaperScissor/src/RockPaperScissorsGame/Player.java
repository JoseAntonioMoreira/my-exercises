package RockPaperScissorsGame;
public class Player {

    private String name;
    private Hand hand;



    public Player (String name,Hand hand){
        this.name=name;
        this.hand=hand;

    }
    public Hand getHand(){
        return hand;
    }
    public void setHand(Hand newHand){
        this.hand=newHand;

    }
    public String getName(){
        return name;
    }


}
