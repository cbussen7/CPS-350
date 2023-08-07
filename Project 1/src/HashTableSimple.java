/*
    Christopher Bussen
    CPS 350 02
    Project 1

    class has simple hashing, search, insertion, deletion, and display methods for hash table
 */

public class HashTableSimple {
    int[] content;
    //array for whether or not given slot is occupied
    boolean[] bOccupied;

    public HashTableSimple(final int maxSize){
        content = new int[maxSize];
        bOccupied = new boolean[maxSize];
    }//end constructor method

    public int getHashIndex(int value){
        int index = value % content.length;
        return index;
    }//end getHashIndex method

    public int search(final int key){
        //obtain hash index
        int index = getHashIndex(key);
        if(!bOccupied[index]){
            System.out.println("Key not found");
            return -1;
        }
        else if(content[index] == key){
            //given key is in correct index
            return index;
        }
        else{
            System.out.println("Key not found");
            return -1;
        }
    }//end search method

    public boolean insert(final int value){
        //obtain the hash index
        int index = getHashIndex(value);

        if(!bOccupied[index]){
            //add value to index if spot isn't occupied and change occupied to true
            content[index] = value;
            bOccupied[index] = true;
            //inserted successfully
            return true;
        }
        else{
            //only happens when there's a conflict
            return false;
        }
    }//end insert method

    public boolean delete(final int key){
        //obtain the hash index
        int index = getHashIndex(key);
        if(!bOccupied[index]){
            //no such item
            return false;
        }
        else{
            //can't make int value in content null so just change occupied to false
            bOccupied[index] = false;
            //deleted successfully
            return true;
        }
    }//end delete method

    //modified display method from what was shown so that each value isn't printed on different line - makes it easier to read
    public void display(){
        //print values where occupied is true
        for(int i = 0; i < bOccupied.length; i++){
            if(bOccupied[i]){
                System.out.print(i + ": " + content[i] + "   ");
            }
        }
        System.out.println();
    }//end display method
}//end public class HashTableSimple

