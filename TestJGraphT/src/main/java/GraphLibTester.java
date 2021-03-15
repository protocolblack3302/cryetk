
import org.jgrapht.Graph;
import org.jgrapht.traverse.*;
import org.jgrapht.graph.*;

import java.util.Iterator;

public class GraphLibTester {


    public static void main(String[] args){
        Graph<String,DefaultEdge> mygraph=new DefaultDirectedGraph<>(DefaultEdge.class);


        mygraph.addVertex("harsh");
        mygraph.addVertex("himanshu");
        mygraph.addVertex("mummy");
        mygraph.addEdge("mummy","harsh");
        mygraph.addEdge("harsh","himanshu");

        Iterator<String> itr= new DepthFirstIterator<>(mygraph,"mummy");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



    }
}
