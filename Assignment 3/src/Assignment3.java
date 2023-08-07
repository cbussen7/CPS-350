public class Assignment3 {
    public static void main(String[] args){
        //create empty linked list using default constructor
        List list1 = new List();

        //add Bob, Jane, Ann, and Tom to list
        list1.append("Bob");
        list1.append("Jane");
        list1.append("Ann");
        list1.append("Tom");

        list1.print();

        //create new list using copy constructor
        List list2 = new List(list1);

        //change content of second node to John
        list2.changeName("John", 2);

        //display both lists
        list1.print();
        list2.print();

        //delete first element in list1
        list1.delete();

        //display both lists
        list1.print();
        list2.print();
    }
}
