package lisson_7;

public class Program {
    public static void main(String[] args) {
        Graph g = new Graph(11);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);

        g.addEdge(1, 3);
        g.addEdge(1, 5);

        g.addEdge(2, 3);
        g.addEdge(2, 6);

        g.addEdge(3, 4);

        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 7);

        g.addEdge(5, 7);
        g.addEdge(5, 8);
        g.addEdge(5, 9);

        g.addEdge(6, 7);

        g.addEdge(7, 8);

        g.addEdge(8, 9);
        g.addEdge(8, 10);

        g.addEdge(9, 10);

        BreadthFirstPaths bfsp = new BreadthFirstPaths(g, 0);

        System.out.println(bfsp.hasPathTo(10));
        System.out.println(bfsp.pathTo(10));
        System.out.println(bfsp.distTo(10));
    }
}