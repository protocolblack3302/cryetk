import java.util.ArrayList;

public class DisjointSet {

    ArrayList<Node> nodeList =new ArrayList<>();

    static class Node{
        long data;
        Node parent;
        long rank;
    }

    public void makeSet(int value){
        Node n=new Node();
        n.data=value;
        n.rank=0;
        n.parent=n;
        nodeList.add(n);
    }

    public boolean union(int data1, int data2) {
        Node node1 = nodeList.get(data1);
        Node node2 = nodeList.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }


    public long findSet(int data) {
        return findSet(nodeList.get(data)).data;
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String[] args){

        DisjointSet set=new DisjointSet();
        set.makeSet(0);
        set.makeSet(1);
        set.makeSet(2);
        set.makeSet(3);
        set.makeSet(4);
        set.makeSet(5);
        set.makeSet(6);

        set.union(0,1);
        set.union(1,2);
        set.union(3,4);
        set.union(5,6);
        set.union(4,5);
        set.union(2,6);


        System.out.println(set.findSet(0));
        System.out.println(set.findSet(1));
        System.out.println(set.findSet(2));
        System.out.println(set.findSet(3));
        System.out.println(set.findSet(4));
        System.out.println(set.findSet(5));
        System.out.println(set.findSet(6));









    }

}
