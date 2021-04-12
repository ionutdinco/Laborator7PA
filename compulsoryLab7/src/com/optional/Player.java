package com.optional;

import java.util.ArrayList;
import java.util.List;

public class Player extends Thread {
private String name;
private int victoryPoints;
private List<Token> playerList=new ArrayList<>();

    public Player() {
        this.name = null;
        this.victoryPoints = 0;
    }

    public Player(String name, int victoryPoints) {
        this.name = name;
        this.victoryPoints = victoryPoints;
    }

    public void extractBoard(int index,Board board)
{
    playerList.add(board.getToken(index));
}

public int scorPlayer(){
        int scor=ClosedSequence.computePoints(this.playerList);
}

    @Override
    public void run() {

    }

}
