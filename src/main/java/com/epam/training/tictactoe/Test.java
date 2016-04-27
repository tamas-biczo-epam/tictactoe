package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    
    public static void main(String[] args) throws InterruptedException {
        JsonParserResponse responseParser = new JsonParserResponse();
        
       Strategy strategy1 = new Strategy();
       DefensiveStrategy strategy2 = new DefensiveStrategy();
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
            System.out.println("Enemy move: "+nextMove);
            table.add(nextMove);
            strategy1.setEnemyLastMove(nextMove);
            strategy2.setIsMyturn(false);
            strategy1.setIsMyturn(true);
        }
        
        for (Coordinate coordinate : table) {
            System.out.println(coordinate.toString());
        }
        
        System.out.print("\033[H\033[2J");
        boolean isReserved = false;
        
        for (int i = -25; i < 25; i++) {
            for (int j = -25; j < 25; j++) {
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
        System.out.println();
        Thread.sleep(1000);
       }
    }
}
