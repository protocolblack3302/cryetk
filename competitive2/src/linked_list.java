class Node{
    int data;
    Node next;


Node(int data){
    this.data=data;
    this.next=null;
}

static void print_linkedList(Node root){
        while(root!=null){

            System.out.println(root.data);
            root=root.next;
        }
    }

static void insert(Node root,Node n){
    if(root==null){
        root=n;
    }
    while(root.next!=null){
        root=root.next;
    }
    root.next=n;
}
}



public class linked_list {

    public static void main(String[] args){
Node root=new Node(1);
Node.insert(root,new Node(5));
Node.insert(root,new Node(6));

Node.print_linkedList(root);

    }



}
