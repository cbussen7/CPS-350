    // class for the nodes in the linked list
    // the code should be kept in the file Node.java
    class Node {
        char[] name;  // the content of a node is an array of characters
        Node next;   // the reference to the next node

        // the default constructor which sets name to be an empty string
        // and next to be null
        // (1 point)
        Node() {
            name = new char['\0'];
            next = null;
        }

        // you need to translate the input string to an array
        // and keep its reference in the variable name
        // (1 point)
        Node(final String str) {
            name = str.toCharArray();
            next = null;
        }

        // copy constructor
        // notice that you need to make a complete copy of the array
        // (1 point)
        Node(final Node node) {
            name = new char[node.name.length];
            for (int i = 0; i < name.length; i++) {
                name[i] = node.name[i];
            }
            next = node.next;
        }
    }

