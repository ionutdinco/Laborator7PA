package com.optional;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable{
    private String name;
    private int totalPoints;
    private int PointsDemo;
    private List<Token> playerTokenList;
    private Board board;
    private Integer ordNr;
    private static Integer nrPlayer = 1;
    public static Integer nrPlayers = 0;
    private boolean isBot = false;


    public Player(String name, Board board) {
        this.name = name;
        totalPoints = 0;
        playerTokenList = new ArrayList<>();
        this.board = board;
        ordNr = 0;
    }

    public Player(String name, Board board, boolean isBot) {
        this.name = name;
        totalPoints = 0;
        playerTokenList = new ArrayList<>();
        this.board = board;
        ordNr = 0;
        this.isBot = isBot;
    }

    public Token playerChooseToken() {

        playerTokenList.add(board.getToken(this));
        return  playerTokenList.get(playerTokenList.size()-1);
    }


    public int playerScore(){
        totalPoints = ClosedSequence.calculatePoints(playerTokenList);
        return totalPoints;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<Token> getPlayerTokenList() {
        return playerTokenList;
    }

    public void setPlayerTokenList(List<Token> playerTokenList) {
        this.playerTokenList = playerTokenList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public Integer getOrdNr() {
        return ordNr;
    }

    public void setOrdNr(Integer ordNr) {
        this.ordNr = ordNr;
    }

    public static Integer getNrPlayer() {
        return nrPlayer;
    }

    public static void setNrPlayer(Integer nrPlayer) {
        Player.nrPlayer = nrPlayer;
    }

    public static Integer getNrPlayers() {
        return nrPlayers;
    }

    public static void setNrPlayers(Integer nrPlayers) {
        Player.nrPlayers = nrPlayers;
    }

    public int getPointsDemo() {
        return PointsDemo;
    }

    private boolean endGame(){
        if(board.endGame())
            return true;
        return false;
    }

    @Override
    public void run() {
        while(!endGame()) {
            playerChooseToken();
        }

//        calculez puncte
        totalPoints = ClosedSequence.calculatePoints(playerTokenList);
        PointsDemo = ClosedSequence.calculatePointsAlgorithm(playerTokenList);
//        apalez functia care spune cine are cele mai multe puncte
        board.determineWinner(this);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + " - "
                + playerTokenList +  "  !!!!!  " + PointsDemo;
    }
}
