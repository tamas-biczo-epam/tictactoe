package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

    List<Coordinate> table = new ArrayList<>();
    private boolean isMyTurn = false;
    
    public Coordinate nextMove(){
        
        return null;
    }

    public void setMyturn(boolean parseBoolean) {
        isMyTurn = parseBoolean;
    }

    public void setEnemyLastMove(Coordinate enemyLastMove) {
        // TODO Auto-generated method stub
        
    }
    
}
