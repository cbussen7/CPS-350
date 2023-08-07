/*
    Christopher Bussen
    CPS 350 02
    Project 1

    class has linear hashing, search, insertion, deletion, and display methods for hash table
 */

public class HashTableLinear {
    int[] content;
    //array for whether or not given slot is occupied - 0:unoccupied, 1:occupied, 2:marked
    int[] occupied;

    public HashTableLinear(final int maxSize){
        content = new int[maxSize];
        occupied = new int[maxSize];
    }//end constructor method

    public int getHashIndex(int value){
        int index = value % content.length;
        return index;
    }//end getHashIndex method

    //could've declared as boolean method but problem specified int
    public int search(final int key){
        //obtain hash index
        int index = getHashIndex(key);
        int newPosition = index;
        int i = 0;

        do {
            i++;
            if(occupied[newPosition] == 0){
                System.out.println("Key not found");
                return -1;
            }
            else if(occupied[newPosition] == 1 && content[newPosition] == key){
                return index;
            }
            else{
                newPosition = getHashIndex(key+i);
            }
        }while(newPosition != index);

        System.out.println("Key not found");
        return -1;
    }//end search method

    public boolean insert(final int value){
        //obtain the hash index
        int index = getHashIndex(value);
        int newPosition = index;
        int i = 0;

        do{
            i++;
            if(occupied[newPosition] != 1){
                content[newPosition] = value;
                occupied[newPosition] = 1;
                return true;
            }
            else{
                newPosition = getHashIndex(value+i);
            }
        }while(newPosition != index);

        return false;
    }//end insert method

    public boolean delete(final int key){
        //obtain the hash index
        int index = getHashIndex(key);
        int newPosition = index;
        int i = 0;

        do{
            i++;
            if(occupied[newPosition] == 0){
                return false;
            }
            else if(occupied[newPosition] == 1 && content[newPosition] == key){
                occupied[newPosition] = 2;
                return true;
            }
            else{
                newPosition = getHashIndex(key+i);
            }
        }while(newPosition != index);

        return false;
    }//end delete method

    public void display(){
        //print values where occupied is true
        for(int i = 0; i < occupied.length; i++){
            if(occupied[i] == 1){
                System.out.print(i + ": " + content[i] + "   ");
            }
        }
        System.out.println();
    }//end display method
}//end class HashTableLinear