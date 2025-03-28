import java.util.Arrays;

public class TSPBranchBound {
    private static final int INF = Integer.MAX_VALUE;
    private int n;
    private int[][] costMatrix;
    private boolean[] visited;
    private int minCost = INF;

    public TSPBranchBound(int[][] costMatrix) {
        this.n = costMatrix.length;
        this.costMatrix = costMatrix;
        this.visited = new boolean[n];
    }

    private void tsp(int currPos, int count, int cost, int start) {
        if (count == n && costMatrix[currPos][start] > 0) {
            minCost = Math.min(minCost, cost + costMatrix[currPos][start]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && costMatrix[currPos][i] > 0) {
                visited[i] = true;
                tsp(i, count + 1, cost + costMatrix[currPos][i], start);
                visited[i] = false;
            }
        }
    }

    public int findMinCost() {
        Arrays.fill(visited, false);
        visited[0] = true;
        tsp(0, 1, 0, 0);
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costMatrix = {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };

        TSPBranchBound tspSolver = new TSPBranchBound(costMatrix);
        System.out.println("Minimum cost of TSP: " + tspSolver.findMinCost());
    }
}
