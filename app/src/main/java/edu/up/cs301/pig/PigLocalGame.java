package edu.up.cs301.pig;

import android.util.Log;

import java.util.Random;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState official;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        official = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(official.getTurn() == playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        int turn = official.getTurn();
        if(action instanceof PigHoldAction){
            if(turn == 1){
                official.setP1Score(official.getP1Score() + official.getRun());
                official.setTurn(0);
            }
            else {
                official.setP0Score(official.getP0Score() + official.getRun());
                if (players.length > 1) {
                    official.setTurn(1);
                }
            }
            official.setRun(0);
            return true;
        }
        else if(action instanceof PigRollAction){
            Random rand = new Random(); //instance of random class
            //generate random values from 1-6
            official.setDice(rand.nextInt(6) + 1);
            Log.i("Rolled", " "+ official.getDice());
            if(official.getDice() != 1){
                official.setRun(official.getRun() + official.getDice());
            }
            else{
                official.setRun(0);
                if(turn == 1){
                    official.setTurn(0);
                }
                else if (players.length > 1){
                    official.setTurn(1);
                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState updated = new PigGameState(official);
        p.sendInfo(updated);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(official.getP0Score() >= 50){
            return playerNames[0] + " is the winner with " + official.getP0Score() + " points!";
        }
        if(official.getP1Score() >= 50){
            return playerNames[1] + " is the winner with " + official.getP1Score() + " points!";
        }
        return null;
    }

}// class PigLocalGame
