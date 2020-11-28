import graphs.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class DEER {

    public static void main(String[] arr){
        Graph g= new Graph(6,8, Graph.TYPE.UNDIRECTED, Graph.WEIGHT.WEIGHTED);
        DisjointSet disjointSet=new DisjointSet();
        ArrayList<Graph.Node> all_nodes=g.vertices();
        ArrayList<Integer> weights=new ArrayList<>();

        for(Graph.Node n:all_nodes){
            disjointSet.makeSet(n.getNode_no());
            for(int i:n.weight){
                weights.add(i);
            }
        }




    }
}
