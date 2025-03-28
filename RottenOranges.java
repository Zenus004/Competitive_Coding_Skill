import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class RottenOranges {
    static class Cell {
        int x, y, time;
        Cell(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    private static int minTimeToRot(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int freshOranges = 0;

        // Initialize the queue with all rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0; // No fresh oranges to rot

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int timeElapsed = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int x = cell.x, y = cell.y, time = cell.time;
            timeElapsed = Math.max(timeElapsed, time);

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    queue.add(new Cell(newX, newY, time + 1));
                    freshOranges--;
                }
            }
        }

        return (freshOranges == 0) ? timeElapsed : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];
        System.out.println("Enter grid values (0=empty, 1=fresh, 2=rotten):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = minTimeToRot(grid);
        System.out.println("Minimum time to rot all oranges: " + result);

        sc.close();
    }
}
