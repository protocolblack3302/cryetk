public class tester {


public static void main(String[] args){
    Heap h=new MaxHeap(new int[]{10,2,30,40,1});
    System.out.println(h);
    System.out.println(h.heapSort());
}
}

