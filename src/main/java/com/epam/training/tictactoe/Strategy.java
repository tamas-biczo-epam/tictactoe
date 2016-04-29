package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strategy {

    private List<Coordinate> table = new ArrayList<>();
    private List<Row> rows = new ArrayList<>();
    private boolean isMyTurn = false;
    private Coordinate nextMove = null;
    private String type;
    private int size = 10;

    public Coordinate nextMove() {
        if (table.isEmpty()) {
            nextMove = new Coordinate(0, 0, type);
            table.add(nextMove);
            Row row = new Row();
            row.addCoordinate(nextMove);
            rows.add(row);
        } else if (table.size() == 1) {
            Coordinate singleCoordinate = table.get(0);
            nextMove = new Coordinate(singleCoordinate.getX(), singleCoordinate.getY() + 1, type);
            table.add(nextMove);
            Row row = new Row();
            row.addCoordinate(nextMove);
            rows.add(row);
        } else {
            nextMove = getNextCoordinate();
            table.add(nextMove);
            //updateRows(nextMove);
        }
       
        setTableSize(nextMove);
        return nextMove;
    }

    private Coordinate getNextCoordinate() {
        //List<Row> copyRows = rows;
        for (Row row : rows) {
            System.out.println(row.toString());
        }
        Row maxRow = null;
        while (!rows.isEmpty()) {
            maxRow = getMaxRow(rows);
            if (!isOccupied(maxRow.getFirstCoordinate(type))) {
                Coordinate result = maxRow.getFirstCoordinate(type);
                System.out.println("First: "+result);
               maxRow.addCoordinate(result);
                return result;
            } else if (!isOccupied(maxRow.getLastCoordinate(type))) {
                Coordinate result = maxRow.getLastCoordinate(type);
                System.out.println("Last: "+result);
               maxRow.addCoordinate(result);
                return result;
            }
            rows.remove(maxRow);
        }
        Coordinate result = randCoordinate();
        Row newRow = new Row();
        newRow.addCoordinate(result);
        rows.add(newRow);
        return result;
    }

    private Row getMaxRow(List<Row> rows) {
        int maxRowSize = 0;
        Row result = new Row();
        for (Row row : rows) {
            if (row.getRow().size() > maxRowSize) {
                result = row;
                maxRowSize = row.getRow().size();
            }
        }
        return result;
    }

    private void updateRows(Coordinate nextMove) {
        int nextMoveX = nextMove.getX();
        int nextMoveY = nextMove.getY();
        boolean isAdded = false;
        for (Row row : rows) {
            for (Coordinate coordinate : row.getRow()) {
                int x = coordinate.getX();
                int y = coordinate.getY();
                if (isNeighbour(nextMoveX, nextMoveY, x, y)) {
                    if (!row.getRow().contains(coordinate)) {
                        row.addCoordinate(coordinate);
                        isAdded = true;
                    }
                }
            }
        }
        if (!isAdded) {
            Row newRow = new Row();
            newRow.addCoordinate(nextMove);
			rows.add(newRow);
        }
        
    }

    public boolean isNeighbour(int nextMoveX, int nextMoveY, int x, int y) {
        return x + 1 == nextMoveX || x - 1 == nextMoveX || y + 1 == nextMoveY || y - 1 == nextMoveY || (x + 1 == nextMoveX && y + 1 == nextMoveY)
                || (x - 1 == nextMoveX && y - 1 == nextMoveY) || (x + 1 == nextMoveX && y - 1 == nextMoveY)
                || (x - 1 == nextMoveX && y + 1 == nextMoveY);
    }

    public boolean isOccupied(Coordinate coordinate) {
        for (Coordinate actCoordinate : table) {
            if(actCoordinate.getX() == coordinate.getX() && actCoordinate.getY()==coordinate.getY()){
                return true;
            }
        }
        return false;
    }

    public Coordinate randCoordinate() {
        Random rand = new Random();
        Coordinate randCoord = new Coordinate(rand.nextInt(10) - 5, rand.nextInt(10) - 5, type);
        if (table.contains(randCoord)) {
            randCoord = randCoordinate();
        }
        return randCoord;
    }

    public void setTableSize(Coordinate coordinate) {
        if (Math.abs(coordinate.getX()) >= size - 1) {
            size = coordinate.getX() + 10;
        } else if (Math.abs(coordinate.getY()) >= size - 1) {
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
