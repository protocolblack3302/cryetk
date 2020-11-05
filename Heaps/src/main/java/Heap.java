import java.util.ArrayList;
import java.util.LinkedList;

public interface Heap {
     int parent(int i);
    int leftChild(int i);
    int rightChild(int i);
    void heapify(ArrayList<Integer> heap,int i);
    void buildHeap(int[] arr);
    LinkedList<Integer> heapSort();

}
