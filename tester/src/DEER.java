import graphs.Graph;

import java.util.*;

public class DEER {

    public static void main(String[] arr){
        Graph g= new Graph(9,14, Graph.TYPE.UNDIRECTED, Graph.WEIGHT.WEIGHTED);
        DisjointSet disjointSet=new DisjointSet();
        ArrayList<Graph.Node> all_nodes=g.vertices();
        ArrayList<Graph.Edge> edges=g.edgeList();

        for(Graph.Node n:all_nodes){
            disjointSet.makeSet(n.getNode_no());
        }
    Collections.sort(edges, Comparator.naturalOrder());

        Set<Graph.Edge> minEdges=new HashSet<>();
        for(Graph.Edge e:edges){
            if(disjointSet.findSet(e.source)!=disjointSet.findSet(e.destination)){
                minEdges.add(e);
                disjointSet.union(e.source, e.destination);
            }
        }
        minEdges.forEach(System.out::println);


    }
}
