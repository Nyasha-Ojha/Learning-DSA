import java.util.*;
public class BFSforDisconnectedGraph {
    static class Edge{
        int src;
        int dest;
         public Edge(int src, int dest){
             this.src = src;
             this.dest = dest;
         }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static void bfsForDisconnectedGraph(ArrayList<Edge> graph[], int V, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i =0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                bfsForDisconnectedGraph(graph, V, visited, i);
            }
            System.out.println();
        }

    }
}
