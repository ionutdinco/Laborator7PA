package com.optional;


public class Token {

    private Integer first;
    private Integer second;
    private int value;


    public Token() {
        first = 0;
        second = 0;
        value = 0;
    }

    public Token(Integer first, Integer second, int value) {
        this.first = first;
        this.second = second;
        this.value = value;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public synchronized String toString() {
        return "Token{" +
                "first=" + first +
                ", second=" + second +
                ", value=" + value +
                '}';
    }
}
