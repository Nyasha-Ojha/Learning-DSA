import java.util.*;

public class Main {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        //In an array, initially, every index has null stored in it.
        // In our question,every index --> stores an ArrayList.
        // Jaha bhi null value ho, hum vaha data store nhi kr
        //  skte. So we need to change the null value to empty
        //arraylist, so that we can store values inside the arraylist.
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

    }
    public static void createWeightedGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }
    public static void main(String[] args) {
        int V= 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        //createGraph(graph);
        createWeightedGraph(graph);

        //printing neighbours of 2:
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest + " " + e.weight);
        }
    }
}
