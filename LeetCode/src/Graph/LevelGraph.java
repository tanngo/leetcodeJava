package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

///https://www.geeksforgeeks.org/find-the-level-of-given-node-in-an-undirected-graph/
//Input: V = 5, Edges = {{0, 1}, {0, 2}, {1, 3}, {2, 4}}, X = 3
//Output: 2
public class LevelGraph {
    //number of edges
    private int V;
    private ArrayList<Integer> adj[] ;
    public LevelGraph(int v) {
        V=v;
        adj= new ArrayList[V];
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }
    }

    public int findLeve(int n) {
        int level=0;
        //we have a queue to save
        ArrayList<Integer> queue = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        if(n> V || adj[n].size()==0)  {
            return -1;
        }
        queue.add(0);
        visited[0]=true;
        while(queue.size()>0){
            int size = queue.size();
            while(size-- >0){
                int currentNode = queue.remove(0);
                if(currentNode == n){
                    return level;
                }
                for(int it: adj[currentNode]){
                    if(!visited[it]){
                        queue.add(it);
                        visited[it]=true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public void setAdj(ArrayList<Integer> adj[]) {
        this.adj=adj;
    }

    public static void main(String[] args) {
        int V =5;
        int [][] edges ={{0,1},{0,2},{1,3},{2,4}};
        LevelGraph graph = new LevelGraph(V);
        ArrayList<Integer>adj[] = new ArrayList[V];
        for(int i=0; i<adj.length;i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0;i< edges.length;i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        graph.setAdj(adj);
        System.out.println(graph.findLeve(2));
    }

}
