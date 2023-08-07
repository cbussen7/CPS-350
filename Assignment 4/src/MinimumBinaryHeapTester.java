/*
    Christopher Bussen
    CPS 350 02
    Assignment 4

    program has creates a minimum heap, inserts 10 elements, displays the heap
    in array form, and performs deletions
 */

public class MinimumBinaryHeapTester {
    public static void main(String[] args){
        //create new minimum heap for 10 values
        MinimumBinaryHeap minHeap = new MinimumBinaryHeap(10);

        //insert the values 34, -10, 3, 7, 14, -3, 12, 0, 34, 1
        minHeap.insert(34);
        minHeap.insert(-10);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(14);
        minHeap.insert(-3);
        minHeap.insert(12);
        minHeap.insert(0);
        minHeap.insert(34);
        minHeap.insert(1);


        //print heap
        minHeap.displayArrayContent();

        //delete and display 10 elements from the heap using a loop
        for(int i = 0; i < 10; i++){
            System.out.println(minHeap.delete());
            minHeap.displayArrayContent();
        }

    }//end main method
}//end public class MinimumBinaryHeapTester
