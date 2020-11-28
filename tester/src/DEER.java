import graphs.Graph;

public class DEER {

    public static void main(String[] arr){
        Graph g= new Graph(6,8, Graph.TYPE.UNDIRECTED);
        DisjointSet disjointSet=new DisjointSet();
        for(Graph.Node n:g.vertices()){
            disjointSet.makeSet(n.getNode_no());
        }
    }
}
