package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    private HashMap<Node,LinkedList<Node>> adj;

    public int distance(int source,int destination){
        Node s=new Node(source);
        Node d=new Node(destination);
       for(Node n:adj.get(s)){
           if(n==d){
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
}

    public Graph(int vertices,int edges){
        adj=new HashMap();
        for(int i=0;i<vertices;i++){
            adj.put(new Node(i),new LinkedList<>());
        }
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<edges;++i){
            System.out.println("Enter Source and destination to add an edge :");
            int source=sc.nextInt();
            int destination= sc.nextInt();
            addEdge(source,destination);
        }
    }

    public void addEdge(int source,int destination){
    Node s=new Node(source);
    Node d=new Node(destination);
    try {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }
    catch (NullPointerException e){
        System.err.println("enter a valid node number in range of 0 to "+(adj.size()-1));
        System.exit(1);
    }

    }

    public static void bfs(Graph g,int source){
    Node s=new Node(source);
    Node current;
    s.visited=true;
        Queue<Node> q=new LinkedList<>();
        q.add(s);
        while (!(q.isEmpty())){
            current=q.poll();
            for(Node vertex:g.adj.get(current)){
                if(!vertex.visited){
                    vertex.visited=true;
                    vertex.distance++;
                    vertex.predecessor=current;
                    q.add(vertex);
                }
            }
        }


    }



}
