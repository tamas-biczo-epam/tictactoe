package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

    private List<Coordinate> table = new ArrayList<>();
    private boolean isMyTurn = false;
    private Coordinate nextMove = null;
    private String type;

    public Strategy(String type) {
        super();
        this.type = type;
    }

    public Coordinate nextMove(){
        if(table.isEmpty()){
            nextMove = new Coordinate(0, 0, type);
        }
        else if(table.size()==1){
            Coordinate singleCoordinate = table.get(0);
            nextMove = new Coordinate(singleCoordinate.getX(), singleCoordinate.getY()+1, type);
        }
        
        
        return nextMove;
    }

    public void setMyturn(boolean parseBoolean) {
        isMyTurn = parseBoolean;
    }

    public void setEnemyLastMove(Coordinate enemyLastMove) {
        table.add(enemyLastMove);
    }
    
}
