package com.epam.training.tictactoe;

import java.util.ArrayList;
import java.util.List;

class PointsAndScores {
    int score;
    Coordinate coordinate;

    PointsAndScores(int score, Coordinate coordinate) {
        this.score = score;
        this.coordinate = coordinate;
    }
}

public class TibiStrategy {

    private List<Coordinate> availablePoints;
    private int[][] board = new int[3][3];

    private List<PointsAndScores> rootsChildrenScores;
    private int size = 10;
    //Map<Coordinate, String> boardmap = new HashMap<>();

    public void setTableSize(Coordinate coordinate) {
        if (Math.abs(coordinate.getX()) >= size - 1) {
            size = coordinate.getX() + 10;
        } else if (Math.abs(coordinate.getY()) >= size - 1) {
            size = coordinate.getY() + 10;
        }
    }

    public List<Coordinate> getAvailableStates() {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Coordinate(i, j));
                }
            }
        }
        return availablePoints;
    }

    public void placeAMove(Coordinate coordinate, int player) {
        board[coordinate.getX()][coordinate.getY()] = player;
    }

    public Coordinate returnBestMove() {
        int MAX = -100000;
        int best = -1;

        for (int i = 0; i < rootsChildrenScores.size(); ++i) {
            if (MAX < rootsChildrenScores.get(i).score) {
                MAX = rootsChildrenScores.get(i).score;
                best = i;
            }
        }
        return rootsChildrenScores.get(best).coordinate;
    }

    public int returnMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    public int returnMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    public void callMinimax(int depth, int turn) {
        rootsChildrenScores = new ArrayList<>();
        minimax(depth, turn);
    }

    public int minimax(int depth, int turn) {

        List<Coordinate> pointsAvailable = getAvailableStates();
        if (pointsAvailable.isEmpty())
            return 0;

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Coordinate coordinate = pointsAvailable.get(i);

            if (turn == 1) {
                placeAMove(coordinate, 1);
                int currentScore = minimax(depth + 1, 2);
                scores.add(currentScore);

                if (depth == 0)
                    rootsChildrenScores.add(new PointsAndScores(currentScore, coordinate));

            } else if (turn == 2) {
                placeAMove(coordinate, 2);
                scores.add(minimax(depth + 1, 1));
            }
            board[coordinate.getX()][coordinate.getY()] = 0;
        }
        return turn == 1 ? returnMax(scores) : returnMin(scores);
    }
}
