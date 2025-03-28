import java.util.Arrays;
import java.util.Scanner;

public class GraphColoring {
    private int V; // Number of vertices
    private int[][] graph;
    private int[] colors;

    public GraphColoring(int V) {
        this.V = V;
        this.graph = new int[V][V];
        this.colors = new int[V];
        Arrays.fill(colors, -1); // Initialize all vertices as uncolored
    }

    // Function to check if it's safe to assign a color to a vertex
    private boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && colors[i] == c) {
                return false;
            }
        }
        return true;
    }

    // Function to solve graph coloring using backtracking
    private boolean graphColoringUtil(int v, int m) {
        if (v == V) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;
                if (graphColoringUtil(v + 1, m)) {
                    return true;
                }
                colors[v] = -1; // Backtrack
            }
        }
        return false;
    }

    // Function to find the minimum number of colors required
    public void solveGraphColoring(int m) {
        if (!graphColoringUtil(0, m)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution();
        }
    }

    // Function to print the assigned colors
    private void printSolution() {
        System.out.println("Vertex Colors:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> Color " + colors[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        GraphColoring gc = new GraphColoring(V);

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                gc.graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the maximum number of colors allowed: ");
        int m = sc.nextInt();

        gc.solveGraphColoring(m);

        sc.close();
    }
}
