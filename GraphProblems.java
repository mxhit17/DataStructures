import java.util.*;
import java.util.LinkedList;

public class GraphProblems {
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

        // Normal Graph
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));

        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4, 5, 1));

        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // graph[6].add(new Edge(6, 5, 1));


        // Graph for Cycle Detection (Directed Graph)
        // graph[0].add(new Edge(0, 2, 0));

        // graph[1].add(new Edge(1, 0, 0));

        // graph[2].add(new Edge(2, 3, 0));

        // graph[3].add(new Edge(3, 0, 0));


        // Graph for Topological Sort - DFS
        // graph[2].add(new Edge(2, 3, 0));

        // graph[3].add(new Edge(3, 1, 0));

        // graph[4].add(new Edge(4, 0, 0));
        // graph[4].add(new Edge(4, 1, 0));

        // graph[5].add(new Edge(5, 0, 0));
        // graph[5].add(new Edge(5, 2, 0));


        // Graph for Dijkstra's Algorithm
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));


        // Graph for Bellman Ford Algorithm
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));


        // Graph for Prim's Algorithm
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]){
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

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }

        return;
    }

    public static void dfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
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
            // e.dest = meighbour
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
            // visited[e.dest] = true;
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

    public static boolean bfsBipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i = 0; i < color.length; i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        // q.add(0);

        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        // case - 1 -> neigh has no color
                        if(color[e.dest] == -1){
                            int nextCol = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextCol;
                            q.add(e.dest);
                        }

                        // case - 2 neigh has different color -> continue
                        
                        // case - 3 neigh has same color
                        if(color[e.dest] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isCycleDirectedGraphUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(stack[e.dest] == true){ // cycle exists
                return true;
            }

            if(!vis[e.dest] && isCycleDirectedGraphUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }

        stack[curr] = false;

        return false;
    }
    public static boolean isCycleDirectedGraph(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(isCycleDirectedGraphUtil(graph, i, vis, stack)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void topologicalSortDFSUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSortDFSUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    public static void topologicalSortDFS(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                topologicalSortDFSUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void calcIndegree(ArrayList<Edge> graph[], int curr, int indegree[]){
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int idx = e.dest;
            indegree[idx]++;
        }
    }

    public static void topologicalSortBFS(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++){
            calcIndegree(graph, i, indegree);
        }

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    public static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src == dest){
            System.out.println(path + dest);
            return;
        }
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            allPaths(graph, e.dest, dest, path + src);
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        
        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }        
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src){
        boolean vis[] = new boolean[graph.length];
        // Initialize Distance
        int dist[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(i == src) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // Make PQ
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        // work
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;

                for(int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    if(dist[curr.n] + e.wt < dist[e.dest]) {
                        dist[e.dest] = dist[curr.n] + e.wt;
                        pq.add(new Pair(e.dest, dist[e.dest]));
                    } 
                }
            }
        }

        for(int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for(int i = 0; i < dist.length; i++){
            if(i == src){
                dist[i] = 0;
            }else{
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        // O(V*E)
        // algo - O(V)
        for(int i = 0; i < V - 1; i++){
            // edges - O(E)
            for(int j = 0; j < V; j++){
                for(int k = 0; k < graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    // relaxation step
                    if(dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]){
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }

        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    static class PrimsPair implements Comparable<PrimsPair>{
        int vertex;
        int cost;

        public PrimsPair(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(PrimsPair p2){
            return this.cost - p2.cost;
        }
    }
    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>();

        pq.add(new PrimsPair(0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            PrimsPair curr = pq.remove();
            if(!vis[curr.vertex]){
                vis[curr.vertex] = true;
                finalCost += curr.cost;
                for(int i = 0; i < graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new PrimsPair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Final/Min cost of MST : " + finalCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V]; // null -> empty ArrayList
        createGraph(graph);


        // BFS
        // bfsUtil(graph);


        // DFS
        // dfsUtil(graph, 0, visited);


        // Has Path
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));


        // Cycle Detection
        // System.out.println(dfsC(graph));


        // Bipartite Graph
        // System.out.println(bfsBipartite(graph));


        // Cycle Detection - Directed Graphs
        // System.out.println(isCycleDirectedGraph(graph));        // True


        // Topological Sorting - using DFS
        // topologicalSortDFS(graph);


        // Topological Sorting - using BFS / Kahn's Algorithm
        // topologicalSortBFS(graph);

        
        // All Paths from Source to Target
        // allPaths(graph, 5, 1, "");


        // Dijkstra's Algorithm
        // int src = 0;
        // dijkstra(graph, src);


        // Bellman Ford Algorithm
        // int src = 0;
        // bellmanFord(graph, src);


        // Prim's Algorithm
        // prims(graph);
    }
}