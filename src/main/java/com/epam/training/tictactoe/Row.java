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

    public Coordinate getFirstCoordinate(String type) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        Coordinate result = null;
        if (row.size() == 1) {
            result = new Coordinate(row.get(0).getX()+1, row.get(0).getY()+1, type);
        } else {
            if (isVertical()) {
                for (Coordinate coordinate : row) {
                    if (coordinate.getY() < minY) {
                        result = new Coordinate(coordinate.getX(), coordinate.getY() - 1, type);
                        minY = coordinate.getY();
                    }
                }
            } else if (isHorizontal()) {
                for (Coordinate coordinate : row) {
                    if (coordinate.getX() < minX) {
                        result = new Coordinate(coordinate.getX() - 1, coordinate.getY(), type);
                        minX = coordinate.getX();
                    }
                }
            } else if (isDiagonal()) {
                for (Coordinate coordinate : row) {
                    if (coordinate.getX() < minX) {
                        result = new Coordinate(coordinate.getX() - 1, coordinate.getY() + 1, type);
                        minX = coordinate.getX();
                    }
                }
            } else {
                for (Coordinate coordinate : row) {
                    if (coordinate.getX() < minX) {
                        result = new Coordinate(coordinate.getX() - 1, coordinate.getY() - 1, type);
                        minX = coordinate.getX();
                    }
                }
            }
        }
        return result;
    }

    public Coordinate getLastCoordinate(String type) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        Coordinate result = null;

        if (isVertical()) {
            for (Coordinate coordinate : row) {
                if (coordinate.getY() > maxY) {
                    result = new Coordinate(coordinate.getX(), coordinate.getY()+1, type);
                    maxY = coordinate.getY();
                }
            }
        } else if (isHorizontal()) {
            for (Coordinate coordinate : row) {
                if (coordinate.getX() > maxX) {
                    result = new Coordinate(coordinate.getX() + 1, coordinate.getY(), type);
                    maxX = coordinate.getX();
                }
            }
        } else if (isDiagonal()) {
            for (Coordinate coordinate : row) {
                if (coordinate.getX() > maxX) {
                    result = new Coordinate(coordinate.getX() + 1, coordinate.getY() - 1, type);
                    maxX = coordinate.getX();
                }
            }
        } else {
            for (Coordinate coordinate : row) {
                if (coordinate.getX() > maxX) {
                    result = new Coordinate(coordinate.getX() + 1, coordinate.getY() + 1, type);
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

    @Override
    public String toString() {
        return "Row [row=" + row + "]";
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

        } else if (!isHorizontal() || !isVertical()) {
            for (Coordinate coordinate : row) {
                if (coordinate.getX() < minX) {
                    minCordinate = coordinate;
                    minX = coordinate.getX();
                }
            }
            for (Coordinate coordinate : row) {
                if (coordinate.getX() == minCordinate.getX() + 1 || coordinate.getY() == minCordinate.getY() - 1) {
                    result = true;
                }
            }
        }
        return result;
    }

}
