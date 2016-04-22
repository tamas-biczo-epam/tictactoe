package com.epam.training.tictactoe;

public class Coordinate {
    private int x;
    private int y;
    private String type;
    
    
    public Coordinate(int x, int y, String type) {
        super();
        this.x = x;
        this.y = y;
        this.type = type;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public String getType() {
        return type;
    }
    
    
    
}
