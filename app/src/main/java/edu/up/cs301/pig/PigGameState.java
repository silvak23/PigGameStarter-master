package edu.up.cs301.pig;

public class PigGameState extends edu.up.cs301.game.infoMsg.GameState {
    private int turn;
    private int p0Score;
    private int p1Score;
    private int run;
    private int dice;
    private String action;

    public PigGameState(){
        turn = 0;
        p0Score = 0;
        p1Score = 0;
        run = 0;
        dice = 0;
        action = "";
    }

    public PigGameState(PigGameState other){
        turn = other.turn;
        p0Score = other.p0Score;
        p1Score = other.p1Score;
        run = other.run;
        dice = other.dice;
        action = other.action;
    }

    /**
     * Getters
     */
    public int getTurn(){ return turn; }
    public int getP0Score(){ return p0Score; }
    public int getP1Score(){ return p1Score; }
    public int getRun(){ return run; }
    public int getDice(){ return dice; }
    public String getAction(){ return action; }

    /**
     * setters
     */
    public void setTurn(int t){ turn = t; }
    public void setP0Score(int score){ p0Score = score; }
    public void setP1Score(int score){ p1Score = score; }
    public void setRun(int r){ run = r; }
    public void setDice(int d){ dice = d; }
    public void setAction(String string){ action = string; }
}
