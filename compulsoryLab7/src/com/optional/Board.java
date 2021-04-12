package com.optional;

import java.util.ArrayList;
import java.util.List;

public class Board extends Thread{

    List<Token> board = new ArrayList<>();
    int nrTokensOnBoard;

    public Board() {
        this.board = new ArrayList<>();
        this.nrTokensOnBoard = 0;
    }
    public Board(List<Token> board, int nrTokensOnBoard) {
        this.board = board;
        this.nrTokensOnBoard = nrTokensOnBoard;
    }

    public List<Token> getBoard() {
        return board;
    }

    public void setBoard(List<Token> board) {
        this.board = board;
    }

    public int getNrTokens() {
        return nrTokensOnBoard;
    }

    public void setNrTokens(int nrTokens) {
        this.nrTokensOnBoard = nrTokens;
    }


    public synchronized  Token getToken(int index)
    {
        Token tokenOnBoard = this.board.get(index-1);
        board.remove(index-1);
        return tokenOnBoard;

    }

    @Override
    public String toString() {
        return "Player{" +
                "board=" + board +
                ", nrTokens=" + nrTokensOnBoard +
                '}';
    }
}
