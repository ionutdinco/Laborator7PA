package com.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private int nrTokens;
    private List<Token> tokenList;
    private int winnerPoints;
    private String winnerName;
    private boolean finished = false;
    private int counter = 0;


    public Board() {
        winnerPoints = 0;
        this.nrTokens = 0;
        this.tokenList = new ArrayList<>();
    }

    public Board(int nrTokens, List<Token> tokenList) {
        winnerPoints = 0;
        this.nrTokens = nrTokens;
        this.tokenList = new ArrayList<>();
        this.tokenList = tokenList;
    }

    public int getNrTokens() {
        return nrTokens;
    }

    public void setNrTokens(int nrTokens) {
        this.nrTokens = nrTokens;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }


    private boolean haveAcces(Player player) {
        if (player.getOrdNr().equals(0)) {

            player.setOrdNr(Player.getNrPlayer());
            Player.setNrPlayer(Player.getNrPlayer() + 1);

            if (player.getOrdNr().equals(Player.getNrPlayers()))
                Player.setNrPlayer(1);
            return true;
        }
        if (player.getOrdNr().equals(Player.getNrPlayer())) {
            Player.setNrPlayer(Player.getNrPlayer() + 1);
            if (player.getOrdNr().equals(Player.getNrPlayers()))
                Player.setNrPlayer(1);
            return true;
        }
        return false;
    }

    public synchronized Token getToken(Player player) {
        while (!haveAcces(player)) {
            System.out.println(player.getName() + " STA PE WAIT!");
            try {
                wait();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        System.out.println(player.getName() + " a avut acces!");

        if (endGame()) {
            notifyAll();
            return null;
        }
        int index;
        index = readPlayerChoose(player);

        Token result = tokenList.get(index - 1);
        tokenList.remove(index - 1);
        nrTokens--;
        notifyAll();
        return result;
    }

    @Override
    public String toString() {
        return "" + tokenList;
    }

    public boolean endGame() {
        return nrTokens == 0 || TimeKeeper.isFinished();
    }

    public void generateTokens(int nrTokens) {

    }

    //    determine winner
    public synchronized void determineWinner(Player player) {
        if (player.getPointsDemo() > winnerPoints) {
            winnerName = player.getName();
            winnerPoints = player.getTotalPoints();
        }
        counter++;
        if(counter == Player.nrPlayers)
        {
            finished = true;
            notifyAll();
        }
    }

    public synchronized String showWinner() {
        //asteapta sa se termine meciul
        while (!endGame() || !finished) {
            try {
                wait();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return winnerName;
    }

    private synchronized int readPlayerChoose(Player player) {

        int tokenIndex;
        if (!player.isBot()) {
            Scanner keyboard = new Scanner(System.in);
            System.out.print(this + "\nEnter token index, Player " + player.getName() + ": ");
            tokenIndex = keyboard.nextInt();
        } else {
            tokenIndex = (int) (Math.random() * (nrTokens + 1));
            if (tokenIndex <= 0)
                tokenIndex = 1;
        }

        return tokenIndex;
    }
}
