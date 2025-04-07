import java.util.*;

public class MinimumColoringProblem {

    // Function to print the colors assigned to each vertex
    static void printColors(int[] color) {
        System.out.println("Vertex -> Color");
        for (int i = 0; i < color.length; i++) {
            System.out.println("   " + i + "   ->   " + color[i]);
        }
    }

    // Function to solve Graph Coloring Problem
    static void graphColoring(int[][] graph, int V) {
        int[] color = new int[V];  // Stores color assigned to each vertex
        Arrays.fill(color, -1);    // Initially no color is assigned

        color[0] = 0;  // First vertex colored with first color (0)

        // Temporary array to store available colors
        boolean[] available = new boolean[V];

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++) {

            Arrays.fill(available, true); // Initially all colors are available

            // Check adjacent vertices and mark their colors as unavailable
            for (int v = 0; v < V; v++) {
                if (graph[u][v] == 1 && color[v] != -1) {
                    available[color[v]] = false;
                }
            }

            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr])
                    break;
            }

            color[u] = cr;  // Assign found color to vertex
        }

        printColors(color);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter Adjacency Matrix (0 or 1):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        graphColoring(graph, V);
    }
}
