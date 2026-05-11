Moze solver using BFS 
import java.util.*;

class Point {
    int x, y, dist;

    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class MazeSolverBFS {

    // Directions: Up, Down, Left, Right
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(char[][] maze, int startX, int startY, int endX, int endY) {

        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            // Reached destination
            if (current.x == endX && current.y == endY) {
                return current.dist;
            }

            // Explore all directions
            for (int i = 0; i < 4; i++) {

                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                // Check boundaries and valid path
                if (newX >= 0 && newY >= 0 &&
                    newX < rows && newY < cols &&
                    maze[newX][newY] != '#' &&
                    !visited[newX][newY]) {

                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY, current.dist + 1));
                }
            }
        }

        return -1; // No path found
    }

    public static void main(String[] args) {

        char[][] maze = {
                {'S', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '#'},
                {'.', '#', '.', '#', '.', '.'},
                {'.', '.', '#', '.', '#', '.'},
                {'#', '.', '.', '.', '.', 'E'}
        };

        int startX = 0, startY = 0;
        int endX = 4, endY = 5;

        int shortestPath = bfs(maze, startX, startY, endX, endY);

        if (shortestPath != -1) {
            System.out.println("Shortest Path Length: " + shortestPath);
        } else {
            System.out.println("No path found!");
        }
    }
}
