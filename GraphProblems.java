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
        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 1, 0));

        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));

        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));
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

    public static void main(String[] args) {
        int V = 7;
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
        


    }
}
