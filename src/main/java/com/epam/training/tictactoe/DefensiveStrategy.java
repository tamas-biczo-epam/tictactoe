package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class DefensiveStrategy {

    private List<Coordinate> table = new ArrayList<>();
    private String type;
    private boolean isMyTurn = false;

    private List<Coordinate> getTable() {
        return table;
    }

    public Coordinate nextMove() {
        int x = 0;
        int y = 0;

        Coordinate enemyLastMove = table.get(table.size() - 1);

        return getPossibleEnemyStep(enemyLastMove);
    }

    public void setEnemyLastMove(Coordinate enemyLastMove) {
        table.add(enemyLastMove);
    }

    private Coordinate getPossibleEnemyStep(Coordinate enemyLastMove) {
        int enemyX = enemyLastMove.getX();
        int enemyY = enemyLastMove.getY();
        String enemyType = enemyLastMove.getType();

        for (Coordinate coordinate : table) {
            if (coordinate.getX() == enemyX - 1 && coordinate.getY() == enemyY // left
                    && coordinate.getType().equals(enemyType)) {
                return new Coordinate(enemyX + 1, enemyY, type);
            } else {
                if (coordinate.getX() == enemyX + 1 && coordinate.getY() == enemyY //right
                        && coordinate.getType().equals(enemyType)) {
                    return new Coordinate(enemyX - 1, enemyY,  type);
                } else {
                    if (coordinate.getX() == enemyX && coordinate.getY() - 1 == enemyY //down
                            && coordinate.getType().equals(enemyType)) {
                        return new Coordinate(enemyX, enemyY + 1, type);
                    } else {
                        if (coordinate.getX() == enemyX && coordinate.getY() + 1 == enemyY //up
                                && coordinate.getType().equals(enemyType)) {
                            return new Coordinate(enemyX, enemyY - 1, type);
                        } else {
                            if (coordinate.getX() == enemyX - 1 && coordinate.getY() + 1 == enemyY //up - left
                                    && coordinate.getType().equals(enemyType)) {
                                return new Coordinate(enemyX + 1, enemyY - 1, type);
                            } else {
                                if (coordinate.getX() == enemyX + 1 && coordinate.getY() + 1 == enemyY //up - right
                                        && coordinate.getType().equals(enemyType)) {
                                    return new Coordinate(enemyX - 1, enemyY - 1, type);
                                } else {
                                    if (coordinate.getX() == enemyX - 1 && coordinate.getY() - 1 == enemyY //down - left
                                            && coordinate.getType().equals(enemyType)) {
                                        return new Coordinate(enemyX + 1, enemyY + 1, type);
                                    } else {
                                        if (coordinate.getX() == enemyX + 1 && coordinate.getY() - 1 == enemyY //down - right
                                                && coordinate.getType().equals(enemyType)) {
                                            return new Coordinate(enemyX - 1, enemyY + 1, type);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new Coordinate(enemyX, enemyY, type);
    }

    public static void main(String[] args) {
        DefensiveStrategy strategy = new DefensiveStrategy();
        Coordinate mycoord = new Coordinate(0, 0, "O");

        strategy.setEnemyLastMove(new Coordinate(10, 10, "x"));
        strategy.setEnemyLastMove(new Coordinate(11, 10, "x"));
        strategy.setEnemyLastMove(strategy.nextMove());
        System.out.println(strategy.getTable().toString());
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIsMyturn(boolean parseBoolean) {
        isMyTurn  = parseBoolean;
    }
}
