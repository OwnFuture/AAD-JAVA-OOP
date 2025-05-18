package BFS.DFS;

import java.util.LinkedList;

public class Dfs {
    private int V;
    private LinkedList<Integer> adj[];


    public Dfs(int v){
        V=v;
        adj=new LinkedList[v];

        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    public void addEdge(int from,int to){
        adj[from].add(to);
    }

    public void DFS(int s){
        boolean visited[]=new boolean[V];

        DFSUtil(s,visited);
    }

    private void DFSUtil(int s,boolean visited[]){
        visited[s]=true;
        System.out.print(s+" ");

        for(int neighbour:adj[s]){
            if(!visited[neighbour]){
                DFSUtil(neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        Dfs g=new Dfs(7);

        g.addEdge(0,1);
         g.addEdge(0,2);
          g.addEdge(1,3);
           g.addEdge(1,4);
            g.addEdge(2,5);
             g.addEdge(2,6);

             System.out.println("Depth First Search (DFS) traversal starting from vertex 0");

             g.DFS(0);
    }
}
