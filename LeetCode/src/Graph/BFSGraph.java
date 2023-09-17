package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFSGraph {
    //No of vertices
    private int V;
    //adjency list
    private LinkedList<Integer> adj[];

    //constructor
    BFSGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    //function to ad edge
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean []vistited = new boolean[V];
        List<Integer> queue = new ArrayList<Integer>();
        vistited[s]= true;

        queue.add(s);
        while(queue.size()>0){
            s = queue.remove(0);
            System.out.print(s+" - ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!vistited[n]){
                    vistited[n]=true;
                    queue.add(n);
                }
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
       graph.BFS(2);
        System.out.println("--------------------------------");




    }


}
