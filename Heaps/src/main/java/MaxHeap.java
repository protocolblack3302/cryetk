
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MaxHeap implements Heap {

private ArrayList<Integer> heap;
int size; //size of actual heap

public MaxHeap(int[] arr){
    heap=new ArrayList<>();
    heap.add(0,-1); //we will start it from index 1 for simplicity
    size=0;
    buildHeap(arr);
}

    @Override
    public String toString() {
        return new LinkedList<>(heap.subList(1,heap.size())).toString();

    }

    @Override
    public int parent(int i) {
        return (int)Math.floor(i/2);
    }

    @Override
    public int leftChild(int i) {
        return (i*2);
    }

    @Override
    public int rightChild(int i) {
        return (i*2+1);
    }

    @Override
    public void heapify(ArrayList<Integer> heap, int i) {
        int left=leftChild(i);
        int right=rightChild(i);
        int largest;
        if(left<=this.size() && heap.get(i)<heap.get(left)){
            largest=left;  //left child is in scope of heap and left child value is larger then parent value then
                            // left index is said to be largest of those 2
        }else {
            largest=i;      //otherwise parent is largest of both
        }
        if(right<=this.size() && heap.get(right)>heap.get(largest)){
            largest=right;
        }
        if(largest!=i){
            Collections.swap(heap,i,largest);
            heapify(heap,largest);
        }

    }

    public int size()
    {
        return size;
    }

    @Override
    public void buildHeap(int[] arr) {

        for(int i:arr){
        heap.add(i);
    }
        this.size=arr.length;

    for(int i=((heap.size()-1)/2);i>=1;i--){   //bcz heap size is 1 larger bcz of extra -1 at index 0
        heapify(heap,i);
    }
    }

    @Override
    public LinkedList<Integer> heapSort() {

    for(int i=heap.size()-1;i>=2;i--){
        Collections.swap(heap,i,1);
        this.size--;
        heapify(heap,1);
    }

return new LinkedList<>(heap.subList(1,heap.size()));
    }
}
