/*
    Christopher Bussen
    CPS 350 02
    Assignment 2

    program has methods for both quicksort and merge sort
 */

import java.util.Arrays;
import java.util.Random;

public class SortingMethods {
    public static void main(String [] args){
        //declare randNum as object of Random class
        Random randNum = new Random();

        //create int for array length
        int arrayLength = 10;
        //create int for array length 1,000,000 - commented out to make testing easier, but it runs as expected
        //NOTE:  quicksort appears to be slightly quicker for large scale arrays on my computer
        //int arrayLength = 1000000;

        //create array of given size
        int[] numArray = new int[arrayLength];

        //use for loop to add random integers to the array
        for(int i = 0; i < arrayLength; i++){
            numArray[i] = randNum.nextInt();
        }

        //print unsorted array
        System.out.println("Unsorted array: " + Arrays.toString(numArray));

        //print sorted array using merge sort method and
        int[] mergeSortArray = mergeSort(numArray);
        System.out.println("Sorted array using merge sort: " + Arrays.toString(mergeSortArray));

        //print sorted array using quicksort
        quickSort(numArray, 0, arrayLength-1);
        System.out.println("Sorted array using quick sort: " + Arrays.toString(numArray));
    }//end main method

    /**
     * method uses the quicksort algorithm to go through and sort the unsorted array
     * @param array the array to be sorted
     * @param low the lower bound of the current search
     * @param high the upper bound of the current search
     */
    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int index = partition(array, low, high);

            quickSort(array, low, index-1);
            quickSort(array, index+1, high);
        }
        else{
            return;
        }
    }//end quickSort method

    public static int partition(int[] array, int low, int high){
        //declare pivot as last index of array
        int pivot = array[high];

        //create int for index of smaller element
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(array[j] <= pivot){
                //increment index of smaller element
                i++;

                //swap elements i and j
                swap(array, i, j);
            }
        }

        //swap elements i+1 and high
        swap(array, i+1, high);
        return i+1;
    }//end partition method

    /**
     * method swaps two given elements in an array
     * @param array the array to take the elements from
     * @param index1 the index of the first element to swap
     * @param index2 the index of the second element to swap
     */
    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }//end swap method

    /**
     * method utilizes merge sort algorithm as well as merge method to sort an array
     * @param array unsorted array to be sorted
     * @return the sorted array
     */
    public static int[] mergeSort(int[] array){
        //break recursion if array length is less than 2
        if(array.length < 2){
            return array;
        }
        //create an int for the middle index
        int middle = array.length / 2;

        //break up arrays into halves
        int[] firstHalf = new int[middle];
        int[] secondHalf = new int[array.length-middle];

        //use for loops to add elements to arrays
        for(int i = 0; i < middle; i++){
            firstHalf[i] = array[i];
        }

        for(int i = middle; i < array.length; i++){
            secondHalf[i-middle] = array[i];
        }

        int[] array3 = mergeSort(firstHalf);
        int[] array4 = mergeSort(secondHalf);

        int[] sortedArray = merge(array3, array4);

        //return the sorted array
        return sortedArray;
    }//end mergeSort method

    /**
     * method merges two arrays together
     * @param firstArray first array to be merged
     * @param secondArray second array to be merged
     * @return the resulting merged array
     */
    public static int[] merge(int[] firstArray, int[] secondArray){
        //create new array the size of the two arrays combined
        int[] mergedArray = new int[firstArray.length + secondArray.length];

        //create int variables for the index of each array
        int first_index = 0;
        int second_index = 0;
        int merged_index = 0;

        while(first_index < firstArray.length && second_index < secondArray.length){
            //if number in first array is less than number in second array, add to merged array
            if(firstArray[first_index] < secondArray[second_index]){
                mergedArray[merged_index] = firstArray[first_index];
                //update array indices
                merged_index++;
                first_index++;
            }
            //otherwise add number in second array to merged array
            else{
                mergedArray[merged_index] = secondArray[second_index];
                //update array indices
                merged_index++;
                second_index++;
            }
        }

        //add remaining elements to merged array
        while(first_index < firstArray.length){
            mergedArray[merged_index] = firstArray[first_index];
            merged_index++;
            first_index++;
        }
        while(second_index < secondArray.length){
            mergedArray[merged_index] = secondArray[second_index];
            merged_index++;
            second_index++;
        }

        //return merged array
        return mergedArray;
    }//end merge method

}//end public class SortingMethods
