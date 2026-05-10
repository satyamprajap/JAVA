// Maze Solver using BFS in Java

import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeSolverBFS {

    // Directions: Up, Down, Left, Right
    static int row[] = {-1, 1, 0, 0};
    static int col[] = {0, 0, -1, 1};

    // BFS Function
    static boolean bfs(int maze[][], int startX, int startY, int endX, int endY) {

        int n = maze.length;
        int m = maze[0].length;

        boolean visited[][] = new boolean[n][m];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            // Destination reached
            if (current.x == endX && current.y == endY) {
                return true;
            }

            // Explore 4 directions
            for (int i = 0; i < 4; i++) {

                int newX = current.x + row[i];
                int newY = current.y + col[i];

                // Check valid move
                if (newX >= 0 && newY >= 0 &&
                    newX < n && newY < m &&
                    maze[newX][newY] == 1 &&
                    !visited[newX][newY]) {

                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int maze[][] = {
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };

        int startX = 0, startY = 0;
        int endX = 3, endY = 3;

        if (bfs(maze, startX, startY, endX, endY)) {
            System.out.println("Path Found!");
        } else {
            System.out.println("No Path Exists!");
        }
    }
}
