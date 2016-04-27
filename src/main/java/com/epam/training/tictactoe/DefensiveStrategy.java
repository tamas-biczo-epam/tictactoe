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
        String myType;
        if (enemyType.toLowerCase().equals("X".toLowerCase())) {
            myType = "O";
        } else {
            myType = "X";
        }

        for (Coordinate coordinate : table) {
            if (coordinate.getX() == enemyX - 1 && coordinate.getY() == enemyY // left
                    && coordinate.getType().equals(enemyType) && isEmptyCell(enemyLastMove)) {
                System.out.println("Left");
                return new Coordinate(enemyX + 1, enemyY, myType);
            } else {
                if (coordinate.getX() == enemyX + 1 && coordinate.getY() == enemyY //right
                        && coordinate.getType().equals(enemyType) && isEmptyCell(enemyLastMove)) {
                    System.out.println("Right");
                    return new Coordinate(enemyX - 1, enemyY, myType);
                } else {
                    if (coordinate.getX() == enemyX && coordinate.getY() - 1 == enemyY //down
                            && coordinate.getType().equals(enemyType) && isEmptyCell(enemyLastMove)) {
                        System.out.println("Down");
                        return new Coordinate(enemyX, enemyY + 1, myType);
                    } else {
                        if (coordinate.getX() == enemyX && coordinate.getY() + 1 == enemyY //up
                                && coordinate.getType().equals(enemyType) && isEmptyCell(enemyLastMove)) {
                            System.out.println("Up");
                            return new Coordinate(enemyX, enemyY - 1, myType);
                        } else {
                            if (coordinate.getX() == enemyX - 1 && coordinate.getY() + 1 == enemyY //up - left
                                    && coordinate.getType().equals(enemyType) && isEmptyCell(enemyLastMove)) {
                                System.out.println("Up - Left");
                                return new Coordinate(enemyX + 1, enemyY - 1, myType);
                            } else {
                                if (coordinate.getX() == enemyX + 1 && coordinate.getY() + 1 == enemyY //up - right
                                        && coordinate.getType().equals(enemyType) && isEmptyCell(enemyLastMove)) {
                                    System.out.println("Up - Right");
                                    return new Coordinate(enemyX - 1, enemyY - 1, myType);
                                } else {
                                    if (coordinate.getX() == enemyX - 1 && coordinate.getY() - 1 == enemyY //down - left
                                            && coordinate.getType().equals(enemyType) && isEmptyCell(enemyLastMove)) {
                                        System.out.println("Down - Left");
                                        return new Coordinate(enemyX + 1, enemyY + 1, myType);
                                    } else {
                                        if (coordinate.getX() == enemyX + 1 && coordinate.getY() - 1 == enemyY //down - right
                                                && coordinate.getType().equals(enemyType)
                                                && isEmptyCell(enemyLastMove)) {
                                            System.out.println("Down - Right");
                                            return new Coordinate(enemyX - 1, enemyY + 1, myType);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("default");
        return new Coordinate(enemyX + 3, enemyY + 3);
    }

    private boolean isEmptyCell(Coordinate coordinate) {
        if (table.contains(new Coordinate(coordinate.getX(), coordinate.getY(), "X"))) {
            return false;
        } else {
            if (table.contains(new Coordinate(coordinate.getX(), coordinate.getY(), "Y"))) {
                return false;
            }
        }
        return true;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIsMyturn(boolean parseBoolean) {
        isMyTurn  = parseBoolean;
    }
    public boolean isMyTurn() {
        return isMyTurn;
    }
}
