public class Project1 {
    public static void main(String[] args){
        //create empty simple hash table of size 11 - insert 96,81,22,35,4,15,57,46 and display each time
        HashTableSimple simpleTest = new HashTableSimple(11);
        simpleTest.insert(96);
        simpleTest.display();

        simpleTest.insert(81);
        simpleTest.display();

        simpleTest.insert(22);
        simpleTest.display();

        simpleTest.insert(35);
        simpleTest.display();

        simpleTest.insert(4);
        simpleTest.display();

        simpleTest.insert(15);
        simpleTest.display();

        simpleTest.insert(57);
        simpleTest.display();

        simpleTest.insert(46);
        simpleTest.display();
        
        //delete 81 and display
        System.out.println(simpleTest.delete(81));
        simpleTest.display();
        
        //search for 35 and display
        System.out.println(simpleTest.search(35));
        simpleTest.display();
        
        //insert 4 and display
        System.out.println(simpleTest.insert(4));
        simpleTest.display();


        System.out.println("-----------------------");


        //create empty linear hash table of size 11 - insert 96,81,22,35,4,15,57,46 and display each time
        HashTableLinear linearTest = new HashTableLinear(11);
        linearTest.insert(96);
        linearTest.display();

        linearTest.insert(81);
        linearTest.display();

        linearTest.insert(22);
        linearTest.display();

        linearTest.insert(35);
        linearTest.display();

        linearTest.insert(4);
        linearTest.display();

        linearTest.insert(15);
        linearTest.display();

        linearTest.insert(57);
        linearTest.display();

        linearTest.insert(46);
        linearTest.display();

        //delete 81 and display
        System.out.println(linearTest.delete(81));
        linearTest.display();

        //search for 35 and display
        System.out.println(linearTest.search(35));
        linearTest.display();

        //insert 4 and display
        System.out.println(linearTest.insert(4));
        linearTest.display();

    }//end main method
}//end public class Project1
