package graphs;

import java.util.*;

public class Graph {
    private int time;
    private final HashMap<Node,LinkedList<Node>> adj;
    private ArrayList<Node> index_nodes;  //these are key objects of hashmap we stored refrence of them here to use
    private boolean cycle;

    public static int distance(Graph g,int source,int destination){
        g.bfs(source);
        return g.index_nodes.get(destination).distance;

    }

    private static class Node{

    private int node_no;
    private boolean visited;
    private int distance;
    private Node predecessor;
    private int startTime;
    private int finishTime;


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

    private void addEdge(int source,int destination){

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
        System.out.println();

    }


    private void dfsUtil(Node source){
        time++;
        source.startTime=time;      //helps in studying strongly connected components
        source.visited=true;

        for(Node v:adj.get(source)){
            if(!v.visited){
                                //dfs visited each and every node in graph weather it is a forest graph
                v.predecessor=source;
                dfsUtil(v);

            }
            else if(v.visited && source.predecessor!=v){  //checking if graph has cycle and setting cycle variable of graph to true or false
                cycle=true;   //if the current source node has v in adjacency list and it is already visited and it is not parent of source node
                //then it is a backedge which meaans graph has a cycle
            }
        }
        time++;
        source.finishTime=time;
    }

    public void dfs(){
      for(Node n:index_nodes){
          if(!n.visited){
              dfsUtil(n);
          }
      }
    }

    public boolean hasCycle()
    {
        dfs();
        return cycle;
    }
    public boolean dfsStack(int source ,int destination){
        Node s=index_nodes.get(source);
        Node d=index_nodes.get(destination);
        s.visited=true;
        Stack<Node> stk=new Stack<>();
        stk.push(s);
        while(!stk.isEmpty()){
            Node current=stk.pop();
            if(current.node_no==destination){
                return true;
            }
            for(Node n:adj.get(current)){
                if(!n.visited){
                    n.visited=true;
                    stk.push(n);
                }
            }
        }
        return false;
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