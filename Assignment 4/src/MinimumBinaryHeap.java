/*
    Christopher Bussen
    CPS 350 02
    Assignment 4

    program has methods for minimum binary heaps - each lower level node should be
    greater than or equal to its parent
 */

public class MinimumBinaryHeap {
    private int[] Heap;
    private int currentSize;
    private int maxSize;

    private static final int TOP_OF_HEAP = 1;

    public MinimumBinaryHeap(int maxSize){
        this.currentSize = 0;
        this.maxSize = maxSize;

        Heap = new int[maxSize+1];
        Heap[0] = Integer.MIN_VALUE;
    }//end MinimumBinaryHeap constructor

    private int parent(int position){
        return position / 2;
    }//end parent method

    private int leftChild(int position){
        return 2 * position;
    }//end leftChild method

    private int rightChild(int position){
        return (2 * position) + 1;
    }//end rightChild method

    private boolean isLeaf(int position){
        if(position > (currentSize / 2) && position <= currentSize){
            return true;
        }
        return false;
    }//end isLeaf method

    private void swap(int firstPosition, int secondPosition){
        int tmp = Heap[firstPosition];
        Heap[firstPosition] = Heap[secondPosition];
        Heap[secondPosition] = tmp;
    }//end swap method

    private void minHeapify(int position){
        if(!isLeaf(position)){
            if(Heap[position] > Heap[leftChild(position)] || Heap[position] > Heap[rightChild(position)]){
                if(Heap[leftChild(position)] < Heap[rightChild(position)]){
                    swap(position, leftChild(position));
                    minHeapify(leftChild(position));
                }
                else{
                    swap(position, rightChild(position));
                    minHeapify(rightChild(position));
                }
            }
        }
    }//end minHeapify method

    public void insert(int element){
        if(currentSize >= maxSize){
            return;
        }

        Heap[++currentSize] = element;
        int size = currentSize;

        while(Heap[size] < Heap[parent(size)]){
            swap(size, parent(size));
            size = parent(size);
        }
    }//end insert method

    public void displayArrayContent(){
        for (int i = 1; i < Heap.length; i++){
            System.out.print(Heap[i] + " ");
        }
        System.out.println();
      }//end displayArrayContent method

    public int delete(){
        int deleted = Heap[TOP_OF_HEAP];
        Heap[TOP_OF_HEAP] = Heap[currentSize--];
        minHeapify(TOP_OF_HEAP);

        return deleted;
    }//end delete method

}//end public class MinimumBinaryHeap
