import java.util.*;

public class graphConcept1 {

    static class Node {
        int src;
        int dest;

        Node(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create empty ArrayList for every vertex
    public static void createGraph(ArrayList<Node> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -- 1
        // |    |
        // 2 -- 3

        // Edge 0 - 1
        graph[0].add(new Node(0, 1));
        graph[1].add(new Node(1, 0));

        // Edge 0 - 2
        graph[0].add(new Node(0, 2));
        graph[2].add(new Node(2, 0));

        // Edge 1 - 3
        graph[1].add(new Node(1, 3));
        graph[3].add(new Node(3, 1));

        // Edge 2 - 3
        graph[2].add(new Node(2, 3));
        graph[3].add(new Node(3, 2));
    }

    // Print graph
    public static void printGraph(ArrayList<Node> graph[]) {

        for (int i = 0; i < graph.length; i++) {

            System.out.print("Vertex " + i + " -> ");

            for (int j = 0; j < graph[i].size(); j++) {
                Node edge = graph[i].get(j);

                System.out.print(edge.dest + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int v = 4;

        // Array of ArrayList
        ArrayList<Node> graph[] = new ArrayList[v];

        createGraph(graph);

        printGraph(graph);
    }
}