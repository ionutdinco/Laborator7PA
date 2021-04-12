package com.optional;

import java.sql.Time;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Token t1 = new Token(1,2,10);
        Token t2 = new Token(5,6,10);
        Token t3 = new Token(9,3,10);
        Token t4 = new Token(6,10,10);
        Token t5 = new Token(4,1,10);
        Token t6 = new Token(2,4,10);
        Token t7 = new Token(2,10,10);
        Token t8 = new Token(3,9,10);
        Token t9 = new Token(1,6,10);
        Token t10 = new Token(6,7,10);
        Token t11 = new Token(10,5,10);
        Token t12 = new Token(5,6,10);
        Token t13 = new Token(2,3,10);
        Token t14 = new Token(3,2,10);

//        (1,2) (5,6) (9,3) (6,10) (4,1) (2,4) (2,10)
        ArrayList<Token> myList= new ArrayList<>();
        myList.add(t1);
        myList.add(t2);
        myList.add(t3);
        myList.add(t4);
        myList.add(t5);
        myList.add(t6);
        myList.add(t7);
        myList.add(t8);
        myList.add(t9);
        myList.add(t10);
        myList.add(t11);
//        myList.add(t12);
//        myList.add(t13);
//        myList.add(t14);

        Board b = new Board(myList.size(),myList);

        Player.nrPlayers = 3;

        TimeKeeper cronometru = new TimeKeeper(1);
        cronometru.setDaemon(true);
        cronometru.start();

        Runnable Player1 = new Player("Vasile",b);
         new Thread(Player1).start();
        Runnable Player2 = new Player("Bot",b, true);
        new Thread(Player2).start();
        Runnable Player3 = new Player("Claudiu",b);
        new Thread(Player3).start();
//        Runnable Player4 = new Player("Ionut",b);
//        new Thread(Player4).start();

        System.out.println("\n\nThe Winner is ::::: " + b.showWinner() + " !!!");


    }
}
