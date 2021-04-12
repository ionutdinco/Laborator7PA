package com.optional;


import java.util.ArrayList;
import java.util.List;


public class ClosedSequence {
 private static boolean completSolution=false;
    // [t1 ,t2 ,t3 ,t4]

//    ArrayList<ArrayList<Token>> sloutions

//     t1 - t3 - t4 - t1
//        - t2 -t1
//    verificam care e cea mai mare la final
//    DFS + salvare solutii

    public synchronized static void algorithm(List<Token> tokenList, Token currentToken, List<Token> solution, int searchedNr,Token startToken) {
        if (currentToken != null) {
            if (currentToken.getSecond().equals(searchedNr)) {
                completSolution=true;
                return;
            }
        }

        for (var t : tokenList) {
            if (t != null) {
                if (t.getFirst().equals(currentToken.getSecond())) {
                    solution.add(t);
                    algorithm(tokenList, t, solution, searchedNr,startToken);
                }

            }
        }

        return;

    }

    public synchronized static int calculatePointsAlgorithm(List<Token> tokenList) {
        List<Token> sol = new ArrayList<>();
        int partialSum = 0;
        int totalSum = 0;
        for (var t : tokenList) {
            if (t != null) {
                sol.add(t);
                algorithm(tokenList, t, sol, t.getFirst(),t);
                if (sol.size() > 1 && completSolution) {
                    for (var token : sol) {
                        partialSum += token.getValue();

                    }
                    if (partialSum > totalSum)
                        totalSum = partialSum;
                    partialSum=0;
                    completSolution=false;
                }
                sol.clear();
            }
        }

        return totalSum;

    }

    static int calculatePoints(List<Token> tokenList) {

        int sum = 0;
        for (var token : tokenList) {
            if (token != null) {
                sum += token.getFirst();
            }
        }
        return sum;

    }

}
