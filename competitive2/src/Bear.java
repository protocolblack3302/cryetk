import graphs.Graph;

public class Bear {
    public static void main(String[] args){
Graph g =new Graph(5,5, Graph.TYPE.DIRECTED);
//g.bfs(0);
//g.printGraph(0,3);
//System.out.print(g.dfs(0,2));
//System.out.println(g.dfsStack(0,2));
        g.stronglyConnected();


    }
}
