import java.util.*;

public class CycleDetectionInGraph {

    // Function to check cycle using DFS
    static boolean isCyclicUtil(int v, boolean[] visited, int parent, List<List<Integer>> adj) {
        visited[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, v, adj))
                    return true;
            }
            // If neighbor is visited and not parent → cycle found
            else if (neighbor != parent)
                return true;
        }
        return false;
    }

    // Function to detect cycle in graph
    static boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1, adj))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);  // Undirected Graph
        }

        if (isCyclic(V, adj))
            System.out.println("Cycle Detected in the Graph");
        else
            System.out.println("No Cycle Detected in the Graph");
    }
}
