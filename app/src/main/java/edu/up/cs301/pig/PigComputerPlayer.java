package edu.up.cs301.pig;

import android.util.Log;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState curr = new PigGameState((PigGameState) info);
        if (curr.getTurn() == playerNum){
            sleep(2000);
            int rand;
            Random r = new Random();
            rand = r.nextInt(100);
            if(rand < 50){
                PigHoldAction hold = new PigHoldAction(this);
                Log.i("Computer Move", "HOLD");
                game.sendAction(hold);
            }
            else{
                PigRollAction roll = new PigRollAction(this);
                Log.i("Computer Move", "ROLL");
                game.sendAction(roll);
            }
            return;
        }
    }//receiveInfo

}
