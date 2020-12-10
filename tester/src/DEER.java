import graphs.Graph;

public class DEER {


//    public static void kruskal(Graph g){
//
//
//        ArrayList<Graph.Node> all_nodes=g.vertices();
//        ArrayList<Graph.Edge> edges=g.edgeList();
//
//        DisjointSet disjointSet=new DisjointSet();
//        for(Graph.Node n:all_nodes){
//            disjointSet.makeSet(n.getNode_no());
//        }
//        Collections.sort(edges,Comparator.naturalOrder());
//
//        Set<Graph.Edge> minEdges=new HashSet<>();
//        for(Graph.Edge e:edges){
//            if(disjointSet.findSet(e.source)!=disjointSet.findSet(e.destination)){
//                minEdges.add(e);
//                disjointSet.union(e.source, e.destination);
//            }
//        }
//        minEdges.forEach(System.out::println);
//    }


//
//    public static void prims(Graph g, int start){
//
//
//        PriorityQueue<Graph.Node> queue=new PriorityQueue<>(Comparator.comparingInt(Graph.Node::minEdgeConnected));
//        HashMap<Graph.Node,LinkedList<Graph.Node>> adj=g.getAdjacencyList();
//        queue.addAll(g.vertices());
//        while(!queue.isEmpty()){
//          Graph.Node n=queue.poll();
//
//      }
//    }



    public static void main(String[] arr){
        Graph g= new Graph(3,3, Graph.TYPE.UNDIRECTED, Graph.WEIGHT.UNWEIGHTED);
        g.dfs(Graph.ON.SIMPLE);
        System.out.println(g.hasCycle(Graph.ON.SIMPLE));

        //prims(g,0);





    }
}
