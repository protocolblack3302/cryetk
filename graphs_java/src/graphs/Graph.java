package graphs;

import java.util.*;

public class Graph {

    private final HashMap<Node,LinkedList<Node>> adj;
    ArrayList<Node> index_nodes;  //these are key objects of hashmap we stored refrence of them here to use

    public static int distance(Graph g,int source,int destination){
        g.bfs(source);
        return g.index_nodes.get(destination).distance;

    }

    static class Node{
    public int node_no;
    public boolean visited;
    public int distance;
    public Node predecessor;
    Node(int node_no){
        this.node_no=node_no;
        visited=false;
        predecessor=null;
        distance=0;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof Node))
            return false;
        Node n=(Node) obj;
        return this.node_no == n.node_no;

    }

    @Override
    public int hashCode() {
        return node_no;
    }


        @Override
        public String toString() {
            return String.valueOf(node_no);
        }
    }

    public Graph(int vertices,int edges){
        adj=new HashMap();
        for(int i=0;i<vertices;i++){
            adj.put(new Node(i),new LinkedList<>());
        }
        index_nodes=new ArrayList<>(adj.keySet());
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<edges;++i){
            System.out.println("Enter Source and destination to add an edge :");
            int source=sc.nextInt();
            int destination= sc.nextInt();
            addEdge(source,destination);
        }
    }

    public void addEdge(int source,int destination){

        Node s;
        Node d;

        d=index_nodes.get(destination);
        s=index_nodes.get(source);


    try {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }
    catch (NullPointerException e){
        System.err.println("enter a valid node number in range of 0 to "+(adj.size()-1));
        System.exit(1);
    }

    }

    public void bfs(int source){

    Node current;


        Queue<Node> q=new LinkedList<>();

        index_nodes.get(source).visited=true;
        q.add(index_nodes.get(source));


        while (!(q.isEmpty())){
            current=q.poll();
            for(Node vertex:adj.get(current)){
                if(!vertex.visited){
                    vertex.visited=true;
                    vertex.distance=current.distance+1;
                    vertex.predecessor=current;
                    System.out.print(vertex+" ");
                    q.add(vertex);

                }
            }
        }
            System.out.println("");

    }

    public void printGraph(int source,int destination){
        Node s=index_nodes.get(source);
        Node d=index_nodes.get(destination);
        if(s.equals(d)){
//            System.out.println(source);
        }else if(d.predecessor==null){
            System.out.println("No path found");
        }else{
            printGraph(source,d.predecessor.node_no);
            System.out.print("->"+d.node_no);
        }
        System.out.println("");
    }

}
