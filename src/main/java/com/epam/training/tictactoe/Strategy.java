package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strategy {

    private List<Coordinate> table = new ArrayList<>();
    private boolean isMyTurn = false;
    private Coordinate nextMove = null;
    private String type;
    private int size = 10;

    public Coordinate nextMove(){
        if(table.isEmpty()){
            nextMove = new Coordinate(0, 0, type);
            table.add(nextMove);
        }
        else if(table.size()==1){
            Coordinate singleCoordinate = table.get(0);
            nextMove = new Coordinate(singleCoordinate.getX(), singleCoordinate.getY()+1, type);
            table.add(nextMove);
        }
        else{
            nextMove = randCoordinate();
            table.add(nextMove);
        }
        setTableSize(nextMove);
        return nextMove;         
    }
    
    public Coordinate randCoordinate(){
        Random rand = new Random();
        Coordinate randCoord = new Coordinate(rand.nextInt(100000)-50000, rand.nextInt(100000)-50000, type);
        if(table.contains(randCoord)){
            randCoord = randCoordinate();
        }
        return randCoord;
    }
    
    public void setTableSize(Coordinate coordinate){ 
            if(Math.abs(coordinate.getX()) >= size-1){
                size = coordinate.getX()+10;
            }
            else if(Math.abs(coordinate.getY()) >= size-1){
                size = coordinate.getY() + 10;
            }
    }
    
    public boolean isMyTurn() {
        return isMyTurn;
    }

    public void setIsMyturn(boolean parseBoolean) {
        isMyTurn = parseBoolean;
    }

    public void setEnemyLastMove(Coordinate enemyLastMove) {
        table.add(enemyLastMove);
        setTableSize(enemyLastMove);
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
