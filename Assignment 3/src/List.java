// class for the linked lists
// the code should be kept in the file List.java
class List {
    Node head;  // reference of the head node
    Node tail;  // reference of the last node

    // default constructor, creating an empty list
    // (1 point)
    List() {
        head = new Node();
        head.next = tail;
        tail = null;
    }


    // copy constructor: creating a copy of the input list
    // (2 points)
    List(final List list) {
        Node curr = head;
        Node iter = list.head;

        while(iter.next != null){
            Node tmp = new Node(iter.next);
            curr.next = tmp;
            curr = curr.next;
            iter = iter.next;
        }

    }


    // appending a new node to the list
    // the time complexity is required to be O(1)
    // (2 points)
    void append(final String name) {
        Node addedNode = new Node(name);

        if (head.next == null) {
            head.next = addedNode;
            tail = addedNode;
        }
        else {
            tail.next = addedNode;
            tail = addedNode;
        }
    }


    // deleting the first element (not the head node) from the list
    // you also need to return its content as a string
    // the time complexity is required to be O(1)
    // (2 points)
    String delete() {
        Node deletedNode = head.next;
        head.next = deletedNode.next;

        char[] name = deletedNode.name;
        String str = new String(name);

        return str;
    }


    // displaying the content of all nodes from the beginning to the end
    // (2 points)
    void print() {
        for (Node iter = head.next; iter != null; iter = iter.next) {
            System.out.println(new String(iter.name));
        }

        System.out.println();
    }


    // Change the content (array content) of the node in the given
    // position. The method returns false if the index exceeds the boundaries,
    // and true if the change is made successfully.
    // (2 points)
    boolean changeName(final String newName, final int index) {
        Node iter = head;

        for (int i = 0; i < index; i++, iter = iter.next) {
            if (iter == null) {
                return false;
            }
        }

        for (int i = 0; i < iter.name.length; i++) {
            iter.name[i] = newName.charAt(i);
        }

        return true;
    }
}