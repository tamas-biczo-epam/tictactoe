package com.epam.training.tictactoe;

import java.util.ArrayList;

public class Row {

    private ArrayList<Coordinate> row;

    public Row() {
        super();
        row = new ArrayList<>();
    }

    public ArrayList<Coordinate> getRow() {
        return row;
    }

    public void setRow(ArrayList<Coordinate> row) {
        this.row = row;
    }

    public void addCoordinate(Coordinate coordinate) {
        row.add(coordinate);
    }

    public Coordinate getFirstCoordinate() {
        int minX = row.get(0).getX();
        int minY = row.get(0).getY();
        Coordinate result = null;

        if (isVertical()) {
            for (Coordinate coordinate : row) {
                if (coordinate.getY() < minY) {
                    result = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
                    minY = coordinate.getY();
                }
            }
        } else if (isHorizontal()) {
            for (Coordinate coordinate : row) {
                if (coordinate.getX() < minX) {
                    result = new Coordinate(coordinate.getX() - 1, coordinate.getY());
                    minX = coordinate.getX();
                }
            }
        } else {
            for (Coordinate coordinate : row) {
                if (coordinate.getX() < minX) {
                    result = coordinate;
                    minX = coordinate.getX();
                }
            }
        }
        return result;
    }

    public Coordinate getLastCoordinate() {
        int maxX = row.get(0).getX();
        int maxY = row.get(0).getY();
        Coordinate result = null;

        if (isVertical()) {
            for (Coordinate coordinate : row) {
                if (coordinate.getY() > maxY) {
                    result = coordinate;
                    maxY = coordinate.getY();
                }
            }
        } else {
            for (Coordinate coordinate : row) {
                if (coordinate.getX() > maxX) {
                    result = coordinate;
                    maxX = coordinate.getX();
                }
            }
        }
        return result;
    }

    public boolean isHorizontal() {
        boolean result = true;
        for (Coordinate coordinate : row) {
            if (coordinate.getY() != row.get(0).getY()) {
                result = false;
            }
        }
        return result;
    }

    public boolean isVertical() {
        boolean result = true;
        for (Coordinate coordinate : row) {
            if (coordinate.getX() != row.get(0).getX()) {
                result = false;
            }
        }
        return result;
    }

    public boolean isDiagonal() {
        boolean result = false;
        Coordinate minCordinate = row.get(0);
        int minX = row.get(0).getX();
        if (row.size() > 1) {
            
        }
        else if(!isHorizontal() || !isVertical()){
            for (Coordinate coordinate : row) {
                if (coordinate.getX() < minX) {
                    minCordinate = coordinate;
                    minX = coordinate.getX();
                }
            }
            for (Coordinate coordinate : row) {
                if(coordinate.getX() == minCordinate.getX()+1 || coordinate.getY() == minCordinate.getY()+1){
                    result = true;
                }
            }
        }
        return result;
    }

}
