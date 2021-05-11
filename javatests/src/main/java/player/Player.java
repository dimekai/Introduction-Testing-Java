package player;

import java.util.Random;

/**
 *
 * @author kaimo
 */
public class Player {
    
    private Dice dice;
    private int minNumToWin;
    
    public Player(Dice dice, int minNumToWin) {
        this.dice = dice;
        this.minNumToWin = minNumToWin;
    }
    
    public boolean play() {
        int diceNum = dice.roll();
        return diceNum > this.minNumToWin;
    }
}
