import java.util.*;

class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // Helper function for cycle detection in a directed graph
    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        recStack[v] = true;

        for (int neighbor : adj.get(v)) {
            if (isCyclicUtil(neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    // Function to detect cycle in a directed graph
    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        Graph graph = new Graph(V);

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isCyclic()) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }

        sc.close();
    }
}
