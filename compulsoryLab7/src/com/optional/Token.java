package com.optional;

import java.util.HashMap;
import java.util.Map;

public class Token {


    int pointsToken;
    int capatStang;
    int capatDrept;

    public Token() {
        this.pointsToken = 0;
        this.capatStang = 0;
        this.capatDrept = 0;
    }
    public Token(int pointsToken, int capatStang, int capatDrept) {
        this.pointsToken = pointsToken;
        this.capatStang = capatStang;
        this.capatDrept = capatDrept;
    }

    public int getPointsToken() {
        return pointsToken;
    }

    public void setPointsToken(int pointsToken) {
        this.pointsToken = pointsToken;
    }

    public int getCapatStang() {
        return capatStang;
    }

    public void setCapatStang(int capatStang) {
        this.capatStang = capatStang;
    }

    public int getCapatDrept() {
        return capatDrept;
    }

    public void setCapatDrept(int capatDrept) {
        this.capatDrept = capatDrept;
    }

    @Override
    public String toString() {
        return "Token{" +
                "pointsToken=" + pointsToken +
                ", capatStang=" + capatStang +
                ", capatDrept=" + capatDrept +
                '}';
    }
}
