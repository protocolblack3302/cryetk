import java.util.ArrayList;

public class DisjointSet {

    ArrayList<Node> nodeList =new ArrayList<>();

    class Node{
        long data;
        Node parent;
        long rank;
    }

    public void makeSet(Long value){
        Node n=new Node();
        n.data=value;
        n.rank=0;
        n.parent=n;
        nodeList.add(n);
    }



}
