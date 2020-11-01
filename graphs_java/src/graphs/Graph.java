package graphs;

import java.util.*;

public class Graph {

    private HashMap<Node,LinkedList<Node>> adj;
    Set<Node> index_nodes;

    public static int distance(Graph g,int source,int destination){
        g.bfs(source);
        Node d=new Node(destination);
       for(Node n: g.index_nodes){
           if(n.equals(d)){
               return n.distance;
           }
       }
       return -1;
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
        index_nodes=adj.keySet();
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<edges;++i){
            System.out.println("Enter Source and destination to add an edge :");
            int source=sc.nextInt();
            int destination= sc.nextInt();
            addEdge(source,destination);
        }
    }

    public void addEdge(int source,int destination){


        Node s=null;
        Node d=null;
        for(Node n:index_nodes){
            if(n.equals(new Node(destination))){
                d=n;
            }
            if(n.equals(new Node(source))){
                s=n;
            }
        }


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
    Node s=new Node(source);
    Node current;

        Set<Node> set_keys=index_nodes;
        System.out.println(set_keys);
        Queue<Node> q=new LinkedList<>();

        for(Node first_node:set_keys){
            if(first_node.equals(s)){
             first_node.visited=true;
                q.add(first_node);

            }
        }

        while (!(q.isEmpty())){
            current=q.poll();
            for(Node vertex:adj.get(current)){
                if(!vertex.visited){
                    vertex.visited=true;
                    vertex.distance=current.distance+1;
                    vertex.predecessor=current;
                    q.add(vertex);
                }
            }
        }


    }
}
