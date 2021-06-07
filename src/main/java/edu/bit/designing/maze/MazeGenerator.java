package edu.bit.designing.maze;

import java.util.Random;

public class MazeGenerator implements Maze {

    /**
     * [ 1, 1, 1, 1, 1]
     * [ 1, 1, 1, 1, 1]
     * [ 1, 1, 1, 1, 1]
     * <p>
     * [ 1, 1, 1, 1, 1]
     * [ 1, 1, 0, 1, 1]
     * [ 1, 1, 1, 1, 1]
     * <p>
     * // represent each value as a node of a graph
     * // source to destination there is always a path possible [0,0] [M,N]
     * <p>
     * 1-> [0,1] 0 / 1  ->
     * -> [1,0] [1,0/1] ->
     * <p>
     * root -> right -> right  (until N)
     * -> down
     * -> down
     * <p>
     * -> until(M)
     * <p>
     * 1 -> 1 -> 0/1
     */
    public int[][] getMaze(int rows, int cols) {
        int[][] maze = new int[rows][cols];
        while (!hasPath(maze)) { // combinations of R*C, goes exponential
            maze = createRandomMaze(rows, cols); // O(R*C)
        }
        return maze;
    }

    // would be validating the path from  source to destination
    // V(R*C)+E(R*C)) complexity  (R*C)
    private boolean hasPath(int[][] maze) {
        return true;
    }

    private int[][] createRandomMaze(int row, int column) {
        int[][] maze = new int[row][column];
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                maze[i][j] = random.nextBoolean() ? 1 : 0;
            }
        }
        return maze;
    }
}