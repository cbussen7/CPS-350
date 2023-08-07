/*
    Christopher Bussen
    CPS 350 02
    Assignment 1

    program has methods for both recursive binary search and insertion sort
 */

public class BinaryAndInsertion {
    public static void main(String [] args){
        //create new array with given values
        int [] numArray = {64, 5, 97, 101, 2, 0, -18, 13, 2008, 2};
        //created because binary search needs a sorted array to work
        int [] sortedNumArray = {-18, 0, 2, 2, 5, 13, 64, 97, 101, 2008};

        //use RecursiveBinarySearch to print index of target values
        System.out.println("Target index: " + RecursiveBinarySearch(sortedNumArray, 107, 0, numArray.length-1));
        System.out.println("Target index: " + RecursiveBinarySearch(sortedNumArray, 13, 0, numArray.length-1));

        //use insertionSort method to sort unsorted numArray
        insertionSort(numArray);
    }
    //end main method

    /**
     * method uses a recursive version of binary search to find a target element in an array
     * @param values the array to search
     * @param target the value to search for
     * @param low lower index for search parameter
     * @param high higher index for search parameter
     * @return index of target value in array
     */
    public static int RecursiveBinarySearch(int [] values, int target, int low, int high){
        while(low <= high){
            //declare int for the middle index
            int mid = (low + high) / 2;

            //if the target value is less than value at middle index, make recursive call with lower half of array
            if(target < values[mid]){
                //change high to mid - 1
                high = mid - 1;

                //recursively call method
                return RecursiveBinarySearch(values, target, low, high);
            }
            //if the target value is greater than value at middle index, make recursive call with upper half of array
            else if(target > values[mid]){
                //change low to mid + 1
                low = mid + 1;

                //recursively call method
                return RecursiveBinarySearch(values, target, low, high);
            }
            //else return the mid value since value is at mid
            else{
                //return the index where the value is found
                return mid;
            }
        }

        //return -1 meaning target was not found in array
        return -1;
    }
    //end RecursiveBinarySearch method

    /**
     * method uses insertion sort to sort a given array in ascending order - could be
     * implemented to return array instead of void but problem specified void return type
     * @param array array to be sorted
     */
    public static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int tmp = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > tmp){
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = tmp;
        }

        //use loop to print sorted array
        for(int arrayElement: array){
            System.out.print(arrayElement + " ");
        }
    }
    //end insertionSort method
}
//end public class BinaryAndInsertion
