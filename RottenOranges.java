import java.util.*;

class RottenOranges {

    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int minTimeToRot(int[][] grid, int n, int m) {
        Queue<Point> q = new LinkedList<>();
        int fresh = 0;

        // Add all rotten oranges to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new Point(i, j, 0));
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] dx = {-1, 1, 0, 0};  // Up, Down
        int[] dy = {0, 0, -1, 1};  // Left, Right
        int time = 0;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            time = curr.time;

            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;  // Rot the fresh orange
                    fresh--;
                    q.add(new Point(nx, ny, curr.time + 1));
                }
            }
        }

        if (fresh > 0)
            return -1; // Some oranges can't rot

        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter Grid values (0-Empty, 1-Fresh, 2-Rotten):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int result = minTimeToRot(grid, n, m);

        if (result == -1)
            System.out.println("Not all oranges can rot");
        else
            System.out.println("Minimum time to rot all oranges: " + result);
    }
}
