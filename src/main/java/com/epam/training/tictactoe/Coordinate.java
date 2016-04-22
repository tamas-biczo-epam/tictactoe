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
    
    


    public Coordinate(int x, int y) {
        super();
        this.x = x;
        this.y = y;
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


    @Override
    public String toString() {
        return "Coordinate [x=" + x + ", y=" + y + ", type=" + type + "]";
    }
    
    
    
}
