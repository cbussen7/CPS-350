public class RegularBinarySearch {
    public static void main(String [] args){
        //create new array
        int [] numArray = {64, 5, 97, 101, 2, 0, -18, 13, 2008, 2};
        int [] sortedNumArray = {-18, 0, 2, 2, 5, 13, 64, 97, 101, 2008};

        //use BinarySearch method to search the array for 107 and 13
        BinarySearch(sortedNumArray, -18);
        BinarySearch(sortedNumArray, 13);
    }

    /**
     * method uses binary search to search for a specific number in an array
     * @param values array of numbers to search through
     * @param target value to search for
     */
    public static void BinarySearch(int [] values, int target){
        //declare ints for low and high index of array
        int low = 0;
        int high = values.length-1;

        while(low <= high){
            //declare int for the middle index
            int mid = (low + high) / 2;

            //if the target value is less than value at middle index, make recursive call with lower half of array
            if(target < values[mid]){
                //change high to mid - 1
                high = mid - 1;
            }
            //if the target value is greater than value at middle index, make recursive call with upper half of array
            else if(target > values[mid]){
                //change low to mid + 1
                low = mid + 1;
            }
            //else return the mid value since value is at mid
            else{
                //print the index where the value is found
                System.out.println("Target value found at index: " + mid);
                return;
            }
        }

        //tell user value is not in array
        System.out.println("Target value not found in array");
    }
}
