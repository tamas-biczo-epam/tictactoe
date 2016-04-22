package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    
    public static void main(String[] args) throws InterruptedException {
        JsonParserResponse responseParser = new JsonParserResponse();
        
       Strategy strategy1 = new Strategy();
       Strategy strategy2 = new Strategy();
       List<Coordinate> table = new ArrayList<>();
       
       strategy1.setType("x");
       strategy2.setType("o");
       
       strategy1.setIsMyturn(true);
       strategy2.setIsMyturn(false);
       
       while(true){
        if(strategy1.isMyTurn()){
            Coordinate nextMove = strategy1.nextMove();
            table.add(nextMove);
            strategy2.setEnemyLastMove(nextMove);
            strategy1.setIsMyturn(false);
            strategy2.setIsMyturn(true);
        }
        else{
            Coordinate nextMove = strategy2.nextMove();
            table.add(nextMove);
            strategy1.setEnemyLastMove(nextMove);
            strategy2.setIsMyturn(false);
            strategy1.setIsMyturn(true);
        }
        
        System.out.print("\033[H\033[2J");
        boolean isReserved = false;
        
        for (int i = -5; i < 5; i++) {
            for (int j = -5; j < 5; j++) {
                for (Coordinate coordinate : table) {
                    if(coordinate.getX()==i && coordinate.getY()==j){
                        System.out.print(coordinate.getType());
                        System.out.print("   ");
                        isReserved = true;
                        break;
                    }
                    else {
                        isReserved = false;
                    }
                }
                if(!isReserved){
                    System.out.print("-");
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        
        System.out.println();
        for (Coordinate coordinate : table) {
            System.out.print(coordinate.toString()+" ,");
        }
        System.out.println();
        Thread.sleep(2000);
       }
    }
}
