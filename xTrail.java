import java.util.*;
import java.util.LinkedList;

public class xTrail {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]){
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }

        return false;
    }

    public static boolean dfsUtilC(ArrayList<Edge> graph[], boolean vis[], int curr, int par){
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // case - 3
            if(!vis[e.dest]){
                if(dfsUtilC(graph, vis, e.dest, curr)){
                    return true;
                }
            }

            // case - 1
            if(vis[e.dest] && e.dest != par){
                return true;
            }

            //case - 2 -> do nothing -> continue
        }

        return false;
    }

    public static boolean dfsC(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(dfsUtilC(graph, vis, i, -1)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V]; // null -> empty ArrayList
        createGraph(graph);


        // BFS
        // bfs(graph);


        // DFS
        // dfsUtil(graph, 0, visited);


        // Has Path
        // int src = 0;
        // int dest = 5;
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));


        // Cycle Detection
        System.out.println(dfsC(graph));
        



    }
}
