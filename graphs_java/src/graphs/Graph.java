package graphs;

import java.util.*;

public class Graph {

    private int time;
    private  HashMap<Node,LinkedList<Node>> adj;
    private  HashMap<Node,LinkedList<Node>> transpose;
    private ArrayList<Node> index_nodes;
    private ArrayList<Node> index_nodes_transpose;//these are key objects of hashmap we stored refrence of them here to use
    private boolean cycle;
    private LinkedList<Node> transpose_stack=new LinkedList<>();
    private ArrayList<Edge> edges;

    public ArrayList<Edge> edgeList(){
        return  edges;
    }

    public enum TYPE{
        DIRECTED,UNDIRECTED
    }

    private enum ON{
        SIMPLE,
        TRANSPOSE
    }

    public enum WEIGHT{
        WEIGHTED,
        UNWEIGHTED;
    }

    public ArrayList<Node> vertices(){
        return index_nodes;
    }

    public static int distance(Graph g,int source,int destination){

        g.bfs(source);
        return g.index_nodes.get(destination).distance;
    }

    public static class Node{
        public  int[] weight;

        public int getNode_no() {
            return node_no;
        }

        public boolean isVisited() {
            return visited;
        }

        public int getDistance() {
            return distance;
        }

        public Node getPredecessor() {
            return predecessor;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getFinishTime() {
            return finishTime;
        }

        private int node_no;
    private boolean visited;
    private int distance;
    private Node predecessor;
    private int startTime;
    private int finishTime;



    Node(int node_no){
        this.node_no=node_no;
        visited=false;

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

    public static class Edge implements Comparable{
        public int source;
        public int destination;
        public int weight;

         Edge(int s,int d ,int w){
            source=s;
            destination=d;
            weight=w;
        }


        @Override
        public int compareTo(Object o) {
            return -((Edge)o).weight+this.weight;
        }

        @Override
        public String toString() {
            return (source+"---"+weight+"--->"+destination);
        }
    }

    public Graph(int vertices,int edges,TYPE t ,WEIGHT w){
        adj=new HashMap<>();
        this.edges=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            Node created_node=new Node(i);
            if(WEIGHT.WEIGHTED==w) {
                created_node.weight = new int[vertices];            //one node can be connected to that many no ,of vertices
            }
                adj.put((created_node),new LinkedList<>());
        }
        index_nodes=new ArrayList<>(adj.keySet());
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<edges;++i){
//            System.out.println("Enter Source and destination to add an edge :");
            int source=sc.nextInt();
            int destination= sc.nextInt();
            int weight=1;
            if(WEIGHT.WEIGHTED==w){
            weight = sc.nextInt();
            }
            Edge e=new Edge(source,destination,weight);
            this.edges.add(e);

            try {
                addEdge(source,destination,t,w,weight,vertices);

            }catch (NullPointerException|IndexOutOfBoundsException ex){
                System.err.println("enter correct number of nodes between 0 to "+(vertices-1));
                System.exit(-1);
            }
        }
    }

    private void transposeUtil(ON type){
        if(type==ON.TRANSPOSE) {

            for (int i = 0; i < index_nodes_transpose.size(); i++) {
                for (int j = 0; j < adj.get(new Node(i)).size(); j++) {
                    transpose.get(adj.get(index_nodes.get(i)).get(j)).add(index_nodes_transpose.get(i));  //copying values from adjacecny
                    // list to tranpose adjaceny list ,,,we do this by forming opposite links
                    //making sure nodes in linked list of transposed adj list as those same objects from key set of hasmap
                }
            }
        }
    }

    private void addEdge(int source,int destination,TYPE t,WEIGHT w,int weight,int vertices) throws NullPointerException,IndexOutOfBoundsException{

        Node s;
        Node d;

        d=index_nodes.get(destination);
        s=index_nodes.get(source);

        if(w==WEIGHT.WEIGHTED){
            d.weight[source]=weight;
        }
if(t==TYPE.DIRECTED){

    adj.get(s).add(d);   //directed graph
}
else {

        adj.get(s).add(d);
        adj.get(d).add(s); //else undirected


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


    private void dfsUtil(Node source,HashMap<Node,LinkedList<Node>> adj,ON type){
        time++;
        source.startTime=time;      //helps in studying strongly connected components
        source.visited=true;

        for(Node v:adj.get(source)){
            if(!v.visited) {
                //dfs visited each and every node in graph weather it is a forest graph
                v.predecessor = source;

                System.out.print("->" + v.node_no);


                dfsUtil(v, adj, type);
            }
            else if(v.visited && source.predecessor!=v && type==ON.SIMPLE){  //checking if graph has cycle and setting cycle variable of graph to true or false
                cycle=true;   //if the current source node has v in adjacency list and it is already visited and it is not parent of source node
                //then it is a backedge which meaans graph has a cycle
            }
        }
            if(type==ON.SIMPLE) {
                transpose_stack.push(index_nodes_transpose.get(source.node_no));
            //after a node finishes recursion push it onto the stack for tracking which has least or most time
                //and then we will perform dfs on transpose of graph for decreasing finishing time
            }


        time++;
        source.finishTime=time;
    }

    public void dfs(ON adj_list){

        if(adj_list==ON.SIMPLE) {

            for (Node n : index_nodes) {

                if (!n.visited) {
                     //making sure by pushing index_nodes_transpose nodes that
                    //that old visited node of old adj list should not cause problem as its a new node
                    dfsUtil(n, this.adj,ON.SIMPLE);

                }
            }
System.out.println();
        }
        else if(adj_list==ON.TRANSPOSE){
            time=0;

            while(!transpose_stack.isEmpty()) {
                Node n=transpose_stack.poll();
                if (!n.visited) {

                    System.out.println("COMPONENT TREE: "); //it will print the forest formed by kosarajus algorithm
                    System.out.print("->"+n.node_no);

                    dfsUtil(n,transpose,ON.TRANSPOSE);
                    System.out.println();

                }
            }

        }
    }

    public void transpose(){
     transposeUtil(ON.TRANSPOSE);
    }

    private void create_transpore_adj(){
        transpose = new HashMap<>();
        for (int i = 0; i < index_nodes.size(); i++) {
            transpose.put(new Node(i), new LinkedList<>());
        }
        index_nodes_transpose = new ArrayList<>(transpose.keySet());
    }
    public void stronglyConnected(){
        create_transpore_adj();
        dfs(ON.SIMPLE);
        transpose();
        dfs(ON.TRANSPOSE);
    }

    public boolean hasCycle(ON adj_list)
    {
        dfs(adj_list);
        return cycle;
    }
    public boolean dfsStack(int source ,int destination){
        Node s=index_nodes.get(source);
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
        //run dfs before printing this
        Node d=index_nodes.get(destination);
        if(d.predecessor==null){

        }else{
            printGraph(source,d.predecessor.node_no);
            System.out.print("->"+d.node_no);
        }
        System.out.println();
    }

}